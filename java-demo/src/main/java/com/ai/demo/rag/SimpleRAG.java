package com.ai.demo.rag;

import java.util.*;

/**
 * 简单 RAG 系统实现
 * 
 * RAG = Retrieval-Augmented Generation
 * 
 * 知识点：
 * - 文档分块（Chunking）
 * - 向量化（Embedding）
 * - 相似度检索
 * - 上下文构建
 * - Re-ranking（重排序）
 * 
 * 对应面试题：
 * - RAG 如何解决 LLM 的幻觉问题？
 * - 分块策略有哪些？
 * - 如何评估 RAG 系统效果？
 * - Graph RAG 是什么？
 * 
 * 核心流程：
 * 1. 文档 → 分块 → 向量化 → 存储
 * 2. 查询 → 向量化 → 检索 → 构建上下文 → 生成回答
 */
public class SimpleRAG {
    
    private VectorStore vectorStore;
    private int chunkSize;
    private int overlap;
    private int topK;
    
    public SimpleRAG() {
        this(100, 20, 3);  // 默认：分块100字符，重叠20字符，检索top-3
    }
    
    public SimpleRAG(int chunkSize, int overlap, int topK) {
        this.chunkSize = chunkSize;
        this.overlap = overlap;
        this.topK = topK;
        this.vectorStore = new VectorStore(128);  // 假设embedding维度为128
    }
    
    /**
     * 添加文档
     * 
     * @param document 文档内容
     */
    public void addDocument(String document) {
        // 1. 分块
        List<String> chunks = chunkDocument(document);
        
        // 2. 向量化并存储
        for (String chunk : chunks) {
            double[] embedding = embed(chunk);
            vectorStore.add(embedding, chunk);
        }
    }
    
    /**
     * 文档分块
     * 
     * 策略：固定大小 + 滑动窗口
     * 
     * @param document 文档内容
     * @return 分块列表
     */
    private List<String> chunkDocument(String document) {
        List<String> chunks = new ArrayList<>();
        
        int start = 0;
        while (start < document.length()) {
            int end = Math.min(start + chunkSize, document.length());
            
            // 尝试在句子边界切分
            if (end < document.length()) {
                int lastPeriod = document.lastIndexOf('。', end);
                int lastQuestion = document.lastIndexOf('？', end);
                int lastExclaim = document.lastIndexOf('！', end);
                int boundary = Math.max(lastPeriod, Math.max(lastQuestion, lastExclaim));
                
                if (boundary > start) {
                    end = boundary + 1;
                }
            }
            
            chunks.add(document.substring(start, end).trim());
            start = end - overlap;
            
            if (start < 0) start = 0;
        }
        
        return chunks;
    }
    
    /**
     * 文本向量化（简化实现）
     * 
     * 实际应用中应调用 Embedding API（如 OpenAI text-embedding-ada-002）
     * 
     * 这里用简单的词袋模型模拟
     */
    private double[] embed(String text) {
        double[] embedding = new double[128];
        
        // 简单的哈希 embedding（仅用于演示）
        String[] words = text.split("\\s+");
        for (String word : words) {
            int hash = Math.abs(word.hashCode()) % 128;
            embedding[hash] += 1.0;
        }
        
        // 归一化
        return vectorStore.normalize(embedding);
    }
    
    /**
     * 查询
     * 
     * @param query 查询文本
     * @return 回答
     */
    public String query(String query) {
        // 1. 向量化查询
        double[] queryEmbedding = embed(query);
        
        // 2. 检索相关文档
        List<VectorStore.SearchResult> results = vectorStore.search(queryEmbedding, topK);
        
        // 3. 构建上下文
        StringBuilder context = new StringBuilder();
        context.append("参考文档：\n\n");
        
        for (int i = 0; i < results.size(); i++) {
            VectorStore.SearchResult result = results.get(i);
            context.append(String.format("[%d] %s\n", i + 1, result.document));
        }
        
        // 4. 构建回答（实际应调用 LLM API）
        String answer = buildAnswer(query, results);
        
        return answer;
    }
    
    /**
     * 构建回答
     * 
     * 实际应用中应调用 LLM API，传入上下文和查询
     * 
     * Prompt 模板：
     * 根据以下参考文档回答问题。
     * 
     * 参考文档：
     * [1] xxx
     * [2] xxx
     * 
     * 问题：xxx
     * 
     * 回答：
     */
    private String buildAnswer(String query, List<VectorStore.SearchResult> results) {
        if (results.isEmpty()) {
            return "抱歉，未找到相关信息。";
        }
        
        // 简化实现：直接返回最相关的文档
        VectorStore.SearchResult topResult = results.get(0);
        
        return String.format(
            "基于知识库检索（相似度：%.2f）：\n%s",
            topResult.similarity,
            topResult.document
        );
    }
    
    /**
     * 带分数的查询
     * 
     * @param query 查询文本
     * @return 包含检索结果的详细回答
     */
    public QueryResult queryWithDetails(String query) {
        double[] queryEmbedding = embed(query);
        List<VectorStore.SearchResult> results = vectorStore.search(queryEmbedding, topK);
        String answer = buildAnswer(query, results);
        
        return new QueryResult(answer, results);
    }
    
    /**
     * 获取知识库统计信息
     */
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("chunkCount", vectorStore.size());
        stats.put("chunkSize", chunkSize);
        stats.put("overlap", overlap);
        stats.put("topK", topK);
        return stats;
    }
    
    /**
     * 查询结果
     */
    public static class QueryResult {
        public final String answer;
        public final List<VectorStore.SearchResult> sources;
        
        public QueryResult(String answer, List<VectorStore.SearchResult> sources) {
            this.answer = answer;
            this.sources = sources;
        }
    }
}
