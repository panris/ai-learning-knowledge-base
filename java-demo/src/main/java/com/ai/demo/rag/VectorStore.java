package com.ai.demo.rag;

import java.util.*;

/**
 * 向量存储实现
 * 
 * 知识点：
 * - 向量化（Embedding）
 * - 相似度计算（余弦相似度、欧氏距离）
 * - ANN（近似最近邻）检索
 * - 向量索引（HNSW、IVF）
 * 
 * 对应面试题：
 * - 向量数据库的核心原理？
 * - HNSW 如何加速检索？
 * - 如何处理向量漂移？
 */
public class VectorStore {
    
    private List<double[]> vectors;
    private List<String> documents;
    private int dimension;
    
    public VectorStore(int dimension) {
        this.dimension = dimension;
        this.vectors = new ArrayList<>();
        this.documents = new ArrayList<>();
    }
    
    /**
     * 添加向量
     * 
     * @param vector 向量
     * @param document 关联文档
     */
    public void add(double[] vector, String document) {
        if (vector.length != dimension) {
            throw new IllegalArgumentException(
                "Vector dimension mismatch: expected " + dimension + 
                ", got " + vector.length
            );
        }
        vectors.add(vector.clone());
        documents.add(document);
    }
    
    /**
     * 批量添加
     */
    public void addAll(List<double[]> vectors, List<String> documents) {
        if (vectors.size() != documents.size()) {
            throw new IllegalArgumentException("Vectors and documents size mismatch");
        }
        for (int i = 0; i < vectors.size(); i++) {
            add(vectors.get(i), documents.get(i));
        }
    }
    
    /**
     * 相似度搜索
     * 
     * @param query 查询向量
     * @param k 返回 top-k 结果
     * @return 搜索结果列表
     */
    public List<SearchResult> search(double[] query, int k) {
        if (query.length != dimension) {
            throw new IllegalArgumentException("Query dimension mismatch");
        }
        
        // 计算所有相似度
        List<SearchResult> results = new ArrayList<>();
        for (int i = 0; i < vectors.size(); i++) {
            double similarity = cosineSimilarity(query, vectors.get(i));
            results.add(new SearchResult(i, similarity, documents.get(i)));
        }
        
        // 排序并返回 top-k
        results.sort((a, b) -> Double.compare(b.similarity, a.similarity));
        
        return results.subList(0, Math.min(k, results.size()));
    }
    
    /**
     * 余弦相似度
     * 
     * cos(a, b) = (a · b) / (||a|| * ||b||)
     * 
     * 范围：[-1, 1]
     * 1 表示完全相同，-1 表示完全相反
     */
    public double cosineSimilarity(double[] a, double[] b) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        
        for (int i = 0; i < a.length; i++) {
            dotProduct += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }
        
        if (normA == 0 || normB == 0) {
            return 0.0;
        }
        
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
    
    /**
     * 欧氏距离
     * 
     * d(a, b) = sqrt(Σ(ai - bi)²)
     * 
     * 值越小越相似
     */
    public double euclideanDistance(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            double diff = a[i] - b[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }
    
    /**
     * 点积（内积）
     * 
     * a · b = Σ(ai * bi)
     * 
     * 值越大越相似
     */
    public double dotProduct(double[] a, double[] b) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
    
    /**
     * 归一化向量
     * 
     * v_norm = v / ||v||
     */
    public double[] normalize(double[] vector) {
        double norm = 0.0;
        for (double v : vector) {
            norm += v * v;
        }
        norm = Math.sqrt(norm);
        
        double[] normalized = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            normalized[i] = vector[i] / norm;
        }
        
        return normalized;
    }
    
    /**
     * 获取向量数量
     */
    public int size() {
        return vectors.size();
    }
    
    /**
     * 清空存储
     */
    public void clear() {
        vectors.clear();
        documents.clear();
    }
    
    /**
     * 搜索结果
     */
    public static class SearchResult {
        public final int index;
        public final double similarity;
        public final String document;
        
        public SearchResult(int index, double similarity, String document) {
            this.index = index;
            this.similarity = similarity;
            this.document = document;
        }
        
        @Override
        public String toString() {
            return String.format("SearchResult{similarity=%.4f, document='%s'}", 
                similarity, document.length() > 50 ? document.substring(0, 50) + "..." : document);
        }
    }
}
