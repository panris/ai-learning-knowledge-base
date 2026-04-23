package com.ai.demo.llm;

import java.util.*;
import java.util.function.Consumer;

/**
 * LLM API 客户端
 * 
 * 知识点：
 * - Token 与 Tokenizer
 * - 上下文窗口
 * - Temperature 与采样策略
 * - 流式输出
 * - Token 计费
 * 
 * 对应面试题：
 * - Token 是什么？如何计算？
 * - Temperature 如何影响输出？
 * - 流式输出的实现原理？
 * - 如何优化 Token 使用？
 * 
 * 支持的 API：
 * - OpenAI (GPT-4, GPT-3.5)
 * - Claude (claude-3-opus, claude-3-sonnet)
 * - Ollama (本地模型)
 */
public class LLMClient {
    
    private String provider;
    private String apiKey;
    private String baseUrl;
    private String model;
    private double temperature;
    private int maxTokens;
    
    public LLMClient(String provider, String apiKey) {
        this(provider, apiKey, getDefaultBaseUrl(provider));
    }
    
    public LLMClient(String provider, String apiKey, String baseUrl) {
        this.provider = provider;
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.temperature = 0.7;
        this.maxTokens = 2048;
        this.model = getDefaultModel(provider);
    }
    
    /**
     * 聊天补全
     * 
     * @param message 用户消息
     * @return 助手回复
     */
    public String chat(String message) {
        return chat(Collections.singletonList(
            new ChatMessage("user", message)
        ));
    }
    
    /**
     * 多轮对话
     * 
     * @param messages 消息列表
     * @return 助手回复
     */
    public String chat(List<ChatMessage> messages) {
        // 构建请求
        ChatRequest request = new ChatRequest();
        request.model = model;
        request.messages = messages;
        request.temperature = temperature;
        request.maxTokens = maxTokens;
        
        // 调用 API（简化实现，实际应使用 HTTP 客户端）
        String response = callAPI(request);
        
        return response;
    }
    
    /**
     * 流式输出
     * 
     * @param message 用户消息
     * @param callback 每个chunk的回调
     */
    public void chatStream(String message, Consumer<String> callback) {
        chatStream(Collections.singletonList(
            new ChatMessage("user", message)
        ), callback);
    }
    
    /**
     * 流式输出（多轮对话）
     */
    public void chatStream(List<ChatMessage> messages, Consumer<String> callback) {
        // 实际实现应使用 SSE (Server-Sent Events)
        // 这里简化为模拟流式输出
        
        String fullResponse = chat(messages);
        
        // 模拟逐字输出
        for (int i = 0; i < fullResponse.length(); i++) {
            callback.accept(String.valueOf(fullResponse.charAt(i)));
            
            try {
                Thread.sleep(20);  // 模拟网络延迟
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    
    /**
     * Token 计数（估算）
     * 
     * 规则：
     * - 英文：约 4 字符 = 1 token
     * - 中文：约 1.5 字符 = 1 token
     * 
     * 精确计数需要使用对应的 Tokenizer
     */
    public int countTokens(String text) {
        // 简化估算
        int chineseCount = 0;
        int englishCount = 0;
        
        for (char c : text.toCharArray()) {
            if (Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN) {
                chineseCount++;
            } else {
                englishCount++;
            }
        }
        
        return (int) Math.ceil(chineseCount / 1.5) + englishCount / 4;
    }
    
    /**
     * 计算费用（美元）
     * 
     * @param inputTokens 输入 token 数
     * @param outputTokens 输出 token 数
     * @return 费用
     */
    public double calculateCost(int inputTokens, int outputTokens) {
        // 价格示例（实际价格请查看官方文档）
        Map<String, Pricing> pricing = getPricing();
        Pricing p = pricing.getOrDefault(model, new Pricing(0.01, 0.03));
        
        return (inputTokens * p.inputPrice / 1000) + (outputTokens * p.outputPrice / 1000);
    }
    
    /**
     * 调用 API（简化实现）
     */
    private String callAPI(ChatRequest request) {
        // 实际实现：
        // 1. 构建 HTTP 请求
        // 2. 设置 Headers (Authorization, Content-Type)
        // 3. 发送 POST 请求到 /v1/chat/completions
        // 4. 解析 JSON 响应
        
        // 简化：返回模拟响应
        return "这是一个来自 " + provider + " 的模拟响应。\n" +
               "模型: " + model + "\n" +
               "实际使用时请配置正确的 API Key。";
    }
    
    // Getters and Setters
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }
    
    // Helper methods
    
    private static String getDefaultBaseUrl(String provider) {
        return switch (provider.toLowerCase()) {
            case "openai" -> "https://api.openai.com/v1";
            case "claude", "anthropic" -> "https://api.anthropic.com/v1";
            case "ollama" -> "http://localhost:11434/v1";
            default -> throw new IllegalArgumentException("Unknown provider: " + provider);
        };
    }
    
    private static String getDefaultModel(String provider) {
        return switch (provider.toLowerCase()) {
            case "openai" -> "gpt-3.5-turbo";
            case "claude", "anthropic" -> "claude-3-sonnet-20240229";
            case "ollama" -> "llama2";
            default -> "unknown";
        };
    }
    
    private Map<String, Pricing> getPricing() {
        Map<String, Pricing> pricing = new HashMap<>();
        pricing.put("gpt-4", new Pricing(0.03, 0.06));
        pricing.put("gpt-3.5-turbo", new Pricing(0.001, 0.002));
        pricing.put("claude-3-opus", new Pricing(0.015, 0.075));
        pricing.put("claude-3-sonnet", new Pricing(0.003, 0.015));
        return pricing;
    }
    
    // Inner classes
    
    public static class ChatMessage {
        public String role;
        public String content;
        
        public ChatMessage(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
    
    private static class ChatRequest {
        String model;
        List<ChatMessage> messages;
        double temperature;
        int maxTokens;
    }
    
    private static class Pricing {
        double inputPrice;   // per 1K tokens
        double outputPrice;  // per 1K tokens
        
        Pricing(double inputPrice, double outputPrice) {
            this.inputPrice = inputPrice;
            this.outputPrice = outputPrice;
        }
    }
}
