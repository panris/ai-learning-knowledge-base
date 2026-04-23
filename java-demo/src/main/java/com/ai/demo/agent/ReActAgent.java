package com.ai.demo.agent;

import java.util.*;
import java.util.function.Function;

/**
 * ReAct Agent 实现
 * 
 * ReAct = Reasoning + Acting
 * 
 * 知识点：
 * - Thought → Action → Observation 循环
 * - 工具调用
 * - 上下文管理
 * - 规划与执行分离
 * 
 * 对应面试题：
 * - ReAct 模式的优势？
 * - 如何处理工具调用失败？
 * - Agent 如何管理记忆？
 * - 多 Agent 协作如何实现？
 * 
 * 核心流程：
 * User Query
 *   ↓
 * Thought: 分析问题，决定下一步
 *   ↓
 * Action: 调用工具
 *   ↓
 * Observation: 获取结果
 *   ↓
 * [循环直到得出答案]
 *   ↓
 * Final Answer
 */
public class ReActAgent {
    
    private Map<String, Tool> tools;
    private List<Message> history;
    private int maxIterations;
    
    public ReActAgent() {
        this(10);
    }
    
    public ReActAgent(int maxIterations) {
        this.tools = new HashMap<>();
        this.history = new ArrayList<>();
        this.maxIterations = maxIterations;
    }
    
    /**
     * 添加工具
     * 
     * @param name 工具名称
     * @param description 工具描述
     * @param function 工具函数
     */
    public void addTool(String name, String description, Function<String, String> function) {
        tools.put(name, new Tool(name, description, function));
    }
    
    /**
     * 执行任务
     * 
     * @param query 用户查询
     * @return 最终答案
     */
    public String run(String query) {
        history.clear();
        history.add(new Message("user", query));
        
        StringBuilder trace = new StringBuilder();
        trace.append("=== ReAct Agent 执行追踪 ===\n\n");
        trace.append("Query: ").append(query).append("\n\n");
        
        for (int i = 0; i < maxIterations; i++) {
            trace.append("--- Iteration ").append(i + 1).append(" ---\n");
            
            // 1. 思考（实际应调用 LLM）
            ThoughtResult thought = think(query, trace);
            
            if (thought.isFinal) {
                trace.append("\n=== 最终答案 ===\n");
                trace.append(thought.answer).append("\n");
                return thought.answer;
            }
            
            // 2. 执行动作
            String observation = act(thought.action, trace);
            
            // 3. 记录观察
            history.add(new Message("observation", observation));
            trace.append("Observation: ").append(observation).append("\n\n");
        }
        
        return "达到最大迭代次数，未能得出答案。";
    }
    
    /**
     * 思考阶段
     * 
     * 实际应用中应调用 LLM，让其决定：
     * 1. 是否有足够信息回答
     * 2. 如果没有，需要调用哪个工具
     */
    private ThoughtResult think(String query, StringBuilder trace) {
        // 简化实现：基于规则的决策
        // 实际应让 LLM 根据 prompt 决定
        
        String queryLower = query.toLowerCase();
        
        // 检查是否需要搜索
        if (queryLower.contains("什么是") || queryLower.contains("解释") || queryLower.contains("查找")) {
            trace.append("Thought: 需要搜索知识库获取信息\n");
            trace.append("Action: search(\"").append(query).append("\")\n");
            return new ThoughtResult(false, null, "search", query);
        }
        
        // 检查是否需要计算
        if (queryLower.contains("计算") || queryLower.contains("+") || queryLower.contains("*")) {
            trace.append("Thought: 需要计算\n");
            trace.append("Action: calculate(\"").append(query).append("\")\n");
            return new ThoughtResult(false, null, "calculate", query);
        }
        
        // 否则直接回答
        trace.append("Thought: 我有足够的信息回答这个问题\n");
        return new ThoughtResult(true, "这是根据我的知识生成的回答。", null, null);
    }
    
    /**
     * 执行动作
     */
    private String act(String action, StringBuilder trace) {
        Tool tool = tools.get(action);
        
        if (tool == null) {
            return "Error: Unknown tool '" + action + "'";
        }
        
        // 执行工具
        String result = tool.execute(history.get(history.size() - 1).content);
        return result;
    }
    
    /**
     * 获取可用工具列表
     */
    public String getToolDescriptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("可用工具：\n");
        
        for (Tool tool : tools.values()) {
            sb.append(String.format("- %s: %s\n", tool.name, tool.description));
        }
        
        return sb.toString();
    }
    
    /**
     * 构建系统提示词
     */
    private String buildSystemPrompt() {
        return String.format("""
            你是一个 ReAct Agent，使用 Thought-Action-Observation 循环解决问题。
            
            %s
            
            格式：
            Thought: [你的思考]
            Action: [工具名称]
            Action Input: [工具输入]
            
            或当有答案时：
            Thought: 我有足够的信息回答
            Final Answer: [最终答案]
            """, getToolDescriptions());
    }
    
    /**
     * 思考结果
     */
    private static class ThoughtResult {
        final boolean isFinal;
        final String answer;
        final String action;
        final String actionInput;
        
        ThoughtResult(boolean isFinal, String answer, String action, String actionInput) {
            this.isFinal = isFinal;
            this.answer = answer;
            this.action = action;
            this.actionInput = actionInput;
        }
    }
    
    /**
     * 工具定义
     */
    private static class Tool {
        final String name;
        final String description;
        final Function<String, String> function;
        
        Tool(String name, String description, Function<String, String> function) {
            this.name = name;
            this.description = description;
            this.function = function;
        }
        
        String execute(String input) {
            try {
                return function.apply(input);
            } catch (Exception e) {
                return "Error executing tool: " + e.getMessage();
            }
        }
    }
    
    /**
     * 消息记录
     */
    private static class Message {
        final String role;
        final String content;
        
        Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}
