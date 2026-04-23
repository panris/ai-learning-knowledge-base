package com.ai.demo.ml;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 线性回归测试
 */
class LinearRegressionTest {
    
    @Test
    void testFitAndPredict() {
        // 训练数据：y = 2x + 1
        double[][] X = {{1}, {2}, {3}, {4}, {5}};
        double[] y = {3, 5, 7, 9, 11};
        
        LinearRegression lr = new LinearRegression(0.1, 1000);
        lr.fit(X, y);
        
        // 预测
        double[] predictions = lr.predict(new double[][]{{6}, {7}});
        
        // 验证预测结果接近真实值
        assertEquals(13.0, predictions[0], 0.5);
        assertEquals(15.0, predictions[1], 0.5);
    }
    
    @Test
    void testMSE() {
        LinearRegression lr = new LinearRegression();
        
        double[] predictions = {2.0, 4.0, 6.0};
        double[] actual = {2.1, 3.9, 6.2};
        
        double mse = lr.meanSquaredError(predictions, actual);
        
        assertTrue(mse >= 0);
        assertTrue(mse < 0.05);
    }
    
    @Test
    void testR2Score() {
        LinearRegression lr = new LinearRegression();
        
        double[] predictions = {2.0, 4.0, 6.0, 8.0};
        double[] actual = {2.0, 4.0, 6.0, 8.0};
        
        double r2 = lr.r2Score(predictions, actual);
        
        assertEquals(1.0, r2, 0.01);  // 完美拟合
    }
}
