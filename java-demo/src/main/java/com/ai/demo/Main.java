package com.ai.demo;

import com.ai.demo.ml.LinearRegression;
import com.ai.demo.ml.KNN;
import com.ai.demo.algorithm.Sorting;
import com.ai.demo.rag.SimpleRAG;

/**
 * AI Demo 主入口
 * 
 * 演示机器学习、数据结构、RAG 等核心知识点
 * 
 * @author AI Learning Course
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== AI Learning Demo ===\n");
        
        // 1. 机器学习示例
        demonstrateLinearRegression();
        demonstrateKNN();
        
        // 2. 数据结构示例
        demonstrateSorting();
        
        // 3. RAG 示例
        demonstrateRAG();
        
        System.out.println("\n=== Demo 完成 ===");
    }
    
    /**
     * 线性回归示例
     * 知识点：梯度下降、最小二乘法
     */
    private static void demonstrateLinearRegression() {
        System.out.println("\n【线性回归】");
        
        // 训练数据：y = 2x + 1 + noise
        double[][] X = {{1}, {2}, {3}, {4}, {5}};
        double[] y = {3.1, 4.9, 7.2, 9.1, 10.8};
        
        LinearRegression lr = new LinearRegression();
        lr.fit(X, y);
        
        // 预测
        double[] predictions = lr.predict(new double[][]{{6}, {7}});
        
        System.out.println("训练数据: y ≈ 2x + 1");
        System.out.println("预测 x=6: y=" + String.format("%.2f", predictions[0]));
        System.out.println("预测 x=7: y=" + String.format("%.2f", predictions[1]));
    }
    
    /**
     * KNN 分类示例
     * 知识点：欧氏距离、投票机制
     */
    private static void demonstrateKNN() {
        System.out.println("\n【KNN 分类】");
        
        // 训练数据：2D 坐标点，标签 0 或 1
        double[][] XTrain = {
            {1.0, 1.0}, {1.5, 1.5}, {2.0, 2.0},  // 类别 0
            {8.0, 8.0}, {8.5, 8.5}, {9.0, 9.0}   // 类别 1
        };
        int[] yTrain = {0, 0, 0, 1, 1, 1};
        
        KNN knn = new KNN(3);
        knn.fit(XTrain, yTrain);
        
        // 预测新点
        double[][] XTest = {{1.2, 1.3}, {8.3, 8.4}};
        int[] predicted = knn.predict(XTest);
        
        System.out.println("测试点 (1.2, 1.3) 分类: " + predicted[0]);
        System.out.println("测试点 (8.3, 8.4) 分类: " + predicted[1]);
    }
    
    /**
     * 排序算法示例
     * 知识点：快速排序、归并排序
     */
    private static void demonstrateSorting() {
        System.out.println("\n【排序算法】");
        
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("原始数组: " + arrayToString(arr));
        
        // 快速排序
        int[] quickSorted = arr.clone();
        Sorting.quickSort(quickSorted);
        System.out.println("快速排序: " + arrayToString(quickSorted));
        
        // 归并排序
        int[] mergeSorted = arr.clone();
        Sorting.mergeSort(mergeSorted);
        System.out.println("归并排序: " + arrayToString(mergeSorted));
    }
    
    /**
     * RAG 系统示例
     * 知识点：文档分块、向量检索、上下文构建
     */
    private static void demonstrateRAG() {
        System.out.println("\n【RAG 系统】");
        
        SimpleRAG rag = new SimpleRAG();
        
        // 添加知识库文档
        rag.addDocument("机器学习是人工智能的一个分支，它使计算机能够从数据中学习。");
        rag.addDocument("深度学习使用多层神经网络来学习数据的表示。");
        rag.addDocument("Transformer 是一种注意力机制架构，广泛用于 NLP 任务。");
        rag.addDocument("RAG（检索增强生成）结合了检索和生成模型。");
        
        // 查询
        String query = "什么是深度学习?";
        String answer = rag.query(query);
        
        System.out.println("查询: " + query);
        System.out.println("检索结果: " + answer);
    }
    
    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
