package com.ai.demo.ml;

import java.util.*;

/**
 * K近邻分类器实现
 * 
 * 知识点：
 * - 欧氏距离/曼哈顿距离
 * - K 值选择
 * - 投票机制
 * - 距离度量
 * - KD树加速（进阶）
 * 
 * 对应面试题：
 * - KNN 的 K 值如何选择？
 * - KNN 的优缺点？
 * - 如何处理不同量纲的特征？
 * - KNN 的时间复杂度？
 */
public class KNN {
    
    private int k;
    private double[][] XTrain;
    private int[] yTrain;
    private DistanceMetric metric;
    
    /**
     * 距离度量方式
     */
    public enum DistanceMetric {
        EUCLIDEAN,    // 欧氏距离
        MANHATTAN,    // 曼哈顿距离
        COSINE       // 余弦距离
    }
    
    public KNN(int k) {
        this(k, DistanceMetric.EUCLIDEAN);
    }
    
    public KNN(int k, DistanceMetric metric) {
        this.k = k;
        this.metric = metric;
    }
    
    /**
     * 训练（实际上只是存储训练数据）
     * 
     * KNN 是惰性学习算法，训练阶段不构建模型
     */
    public void fit(double[][] X, int[] y) {
        this.XTrain = X;
        this.yTrain = y;
    }
    
    /**
     * 批量预测
     */
    public int[] predict(double[][] X) {
        int[] predictions = new int[X.length];
        for (int i = 0; i < X.length; i++) {
            predictions[i] = predict(X[i]);
        }
        return predictions;
    }
    
    /**
     * 单样本预测
     */
    public int predict(double[] x) {
        // 1. 计算到所有训练样本的距离
        List<Neighbor> neighbors = new ArrayList<>();
        
        for (int i = 0; i < XTrain.length; i++) {
            double distance = calculateDistance(x, XTrain[i]);
            neighbors.add(new Neighbor(i, distance, yTrain[i]));
        }
        
        // 2. 按距离排序
        neighbors.sort(Comparator.comparingDouble(n -> n.distance));
        
        // 3. 取前 K 个邻居
        Map<Integer, Integer> voteCount = new HashMap<>();
        for (int i = 0; i < Math.min(k, neighbors.size()); i++) {
            int label = neighbors.get(i).label;
            voteCount.put(label, voteCount.getOrDefault(label, 0) + 1);
        }
        
        // 4. 多数投票
        int predictedLabel = -1;
        int maxVotes = -1;
        for (Map.Entry<Integer, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                predictedLabel = entry.getKey();
            }
        }
        
        return predictedLabel;
    }
    
    /**
     * 计算距离
     */
    private double calculateDistance(double[] x1, double[] x2) {
        switch (metric) {
            case EUCLIDEAN:
                return euclideanDistance(x1, x2);
            case MANHATTAN:
                return manhattanDistance(x1, x2);
            case COSINE:
                return cosineDistance(x1, x2);
            default:
                return euclideanDistance(x1, x2);
        }
    }
    
    /**
     * 欧氏距离
     * d(x, y) = sqrt(Σ(xi - yi)²)
     */
    private double euclideanDistance(double[] x1, double[] x2) {
        double sum = 0.0;
        for (int i = 0; i < x1.length; i++) {
            double diff = x1[i] - x2[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }
    
    /**
     * 曼哈顿距离
     * d(x, y) = Σ|xi - yi|
     */
    private double manhattanDistance(double[] x1, double[] x2) {
        double sum = 0.0;
        for (int i = 0; i < x1.length; i++) {
            sum += Math.abs(x1[i] - x2[i]);
        }
        return sum;
    }
    
    /**
     * 余弦距离
     * d(x, y) = 1 - cos(x, y) = 1 - (x·y) / (||x|| * ||y||)
     */
    private double cosineDistance(double[] x1, double[] x2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        
        for (int i = 0; i < x1.length; i++) {
            dotProduct += x1[i] * x2[i];
            norm1 += x1[i] * x1[i];
            norm2 += x2[i] * x2[i];
        }
        
        double similarity = dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
        return 1.0 - similarity;
    }
    
    /**
     * 预测概率（每个类别的得票比例）
     */
    public Map<Integer, Double> predictProba(double[] x) {
        List<Neighbor> neighbors = new ArrayList<>();
        
        for (int i = 0; i < XTrain.length; i++) {
            double distance = calculateDistance(x, XTrain[i]);
            neighbors.add(new Neighbor(i, distance, yTrain[i]));
        }
        
        neighbors.sort(Comparator.comparingDouble(n -> n.distance));
        
        Map<Integer, Integer> voteCount = new HashMap<>();
        for (int i = 0; i < Math.min(k, neighbors.size()); i++) {
            int label = neighbors.get(i).label;
            voteCount.put(label, voteCount.getOrDefault(label, 0) + 1);
        }
        
        Map<Integer, Double> probabilities = new HashMap<>();
        int totalVotes = Math.min(k, neighbors.size());
        
        for (Map.Entry<Integer, Integer> entry : voteCount.entrySet()) {
            probabilities.put(entry.getKey(), (double) entry.getValue() / totalVotes);
        }
        
        return probabilities;
    }
    
    /**
     * 邻居记录
     */
    private static class Neighbor {
        int index;
        double distance;
        int label;
        
        Neighbor(int index, double distance, int label) {
            this.index = index;
            this.distance = distance;
            this.label = label;
        }
    }
}
