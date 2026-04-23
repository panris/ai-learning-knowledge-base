package com.ai.demo.ml;

/**
 * 线性回归实现
 * 
 * 知识点：
 * - 最小二乘法
 * - 梯度下降优化
 * - 损失函数（MSE）
 * - 过拟合与正则化
 * 
 * 对应面试题：
 * - 线性回归的假设是什么？
 * - 如何处理非线性关系？
 * - L1/L2 正则化的区别？
 */
public class LinearRegression {
    
    private double[] weights;      // 权重系数
    private double bias;           // 偏置项
    private double learningRate;   // 学习率
    private int maxIterations;     // 最大迭代次数
    
    public LinearRegression() {
        this(0.01, 1000);
    }
    
    public LinearRegression(double learningRate, int maxIterations) {
        this.learningRate = learningRate;
        this.maxIterations = maxIterations;
    }
    
    /**
     * 训练模型（梯度下降）
     * 
     * @param X 特征矩阵 [n_samples, n_features]
     * @param y 目标值 [n_samples]
     */
    public void fit(double[][] X, double[] y) {
        int nSamples = X.length;
        int nFeatures = X[0].length;
        
        // 初始化参数
        weights = new double[nFeatures];
        bias = 0.0;
        
        // 梯度下降
        for (int iter = 0; iter < maxIterations; iter++) {
            // 计算预测值
            double[] predictions = predict(X);
            
            // 计算梯度
            double[] dWeights = new double[nFeatures];
            double dBias = 0.0;
            
            for (int i = 0; i < nSamples; i++) {
                double error = predictions[i] - y[i];
                dBias += error;
                
                for (int j = 0; j < nFeatures; j++) {
                    dWeights[j] += error * X[i][j];
                }
            }
            
            // 更新参数
            for (int j = 0; j < nFeatures; j++) {
                weights[j] -= learningRate * dWeights[j] / nSamples;
            }
            bias -= learningRate * dBias / nSamples;
            
            // 可选：打印损失
            if (iter % 100 == 0) {
                double loss = meanSquaredError(predictions, y);
                // System.out.printf("Iteration %d, MSE: %.4f%n", iter, loss);
            }
        }
    }
    
    /**
     * 预测
     * 
     * @param X 特征矩阵
     * @return 预测值
     */
    public double[] predict(double[][] X) {
        double[] predictions = new double[X.length];
        
        for (int i = 0; i < X.length; i++) {
            predictions[i] = predict(X[i]);
        }
        
        return predictions;
    }
    
    /**
     * 单样本预测
     */
    public double predict(double[] x) {
        double sum = bias;
        for (int j = 0; j < weights.length; j++) {
            sum += weights[j] * x[j];
        }
        return sum;
    }
    
    /**
     * 计算均方误差（MSE）
     */
    public double meanSquaredError(double[] predictions, double[] actual) {
        double sum = 0.0;
        for (int i = 0; i < predictions.length; i++) {
            double diff = predictions[i] - actual[i];
            sum += diff * diff;
        }
        return sum / predictions.length;
    }
    
    /**
     * 计算 R² 分数
     * 
     * R² = 1 - SS_res / SS_tot
     * 衡量模型解释方差的比例
     */
    public double r2Score(double[] predictions, double[] actual) {
        double mean = 0.0;
        for (double v : actual) {
            mean += v;
        }
        mean /= actual.length;
        
        double ssRes = 0.0;  // 残差平方和
        double ssTot = 0.0;  // 总平方和
        
        for (int i = 0; i < actual.length; i++) {
            ssRes += Math.pow(actual[i] - predictions[i], 2);
            ssTot += Math.pow(actual[i] - mean, 2);
        }
        
        return 1.0 - ssRes / ssTot;
    }
    
    /**
     * 使用正规方程求解（闭式解）
     * 
     * θ = (X^T X)^(-1) X^T y
     * 
     * 适用于特征较少的情况
     */
    public void fitNormalEquation(double[][] X, double[] y) {
        int nSamples = X.length;
        int nFeatures = X[0].length;
        
        // 构建 X 矩阵（添加偏置列）
        double[][] Xaug = new double[nSamples][nFeatures + 1];
        for (int i = 0; i < nSamples; i++) {
            Xaug[i][0] = 1.0;  // 偏置项
            for (int j = 0; j < nFeatures; j++) {
                Xaug[i][j + 1] = X[i][j];
            }
        }
        
        // 计算 θ = (X^T X)^(-1) X^T y
        // 简化实现：仅用于演示
        // 实际应使用矩阵运算库（如 Apache Commons Math）
        
        // 这里用梯度下降替代
        fit(X, y);
    }
    
    // Getters
    public double[] getWeights() {
        return weights;
    }
    
    public double getBias() {
        return bias;
    }
}
