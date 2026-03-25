# 🤖 AI/算法面试

> 收录 AI 算法、机器学习、深度学习、编程题等面试相关资源，持续更新。

---

## 一、面试知识体系

### 📋 AI 算法面试知识图谱

```
基础            →  进阶              →  高级
────────────────────────────────────────────────
数组/链表        →  哈希表/集合        →  滑动窗口
二分查找        →  双指针             →  二叉树/图
排序算法        →  堆/优先队列        →  回溯/动态规划
└ 快速排序      →  └ 并查集           →  └ 贪心/分治
栈/队列        →  递归/分治          →  位运算
```

### 🧠 机器学习面试重点

| 模块 | 核心知识点 | 面试频率 |
|------|-----------|----------|
| 基础概念 | 欠拟合/过拟合、偏差方差、激活函数 | ⭐⭐⭐⭐⭐ |
| 经典算法 | 线性回归、逻辑回归、决策树、SVM | ⭐⭐⭐⭐⭐ |
| 集成学习 | Bagging、Boosting、Random Forest、XGBoost | ⭐⭐⭐⭐⭐ |
| 深度学习 | CNN、RNN/LSTM、注意力机制、优化器 | ⭐⭐⭐⭐⭐ |
| 大模型 | Transformer、RLHF、Prompt Engineering | ⭐⭐⭐⭐⭐ |
| 工程能力 | 模型部署、特征工程、性能优化 | ⭐⭐⭐⭐ |

---

## 二、必刷编程题（按难度）

### 🔰 入门级（必刷）

| 题目 | 链接 | 知识点 |
|------|------|--------|
| 两数之和 | [LeetCode 1](https://leetcode.cn/problems/two-sum/) | 哈希表 |
| 合并两个有序链表 | [LeetCode 21](https://leetcode.cn/problems/merge-two-sorted-lists/) | 链表 |
| 有效的括号 | [LeetCode 20](https://leetcode.cn/problems/valid-parentheses/) | 栈 |
| 爬楼梯 | [LeetCode 70](https://leetcode.cn/problems/climbing-stairs/) | 动态规划 |
| 二叉树的中序遍历 | [LeetCode 94](https://leetcode.cn/problems/binary-tree-inorder-traversal/) | 二叉树 |
| 反转链表 | [LeetCode 206](https://leetcode.cn/problems/reverse-linked-list/) | 链表 |
| 多数元素 | [LeetCode 169](https://leetcode.cn/problems/majority-element/) | 分治/投票 |
| 买卖股票最佳时机 | [LeetCode 121](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/) | 贪心 |

### ⭐ 中级（高频）

| 题目 | 链接 | 知识点 |
|------|------|--------|
| 全排列 | [LeetCode 46](https://leetcode.cn/problems/permutations/) | 回溯 |
| 搜索旋转排序数组 | [LeetCode 33](https://leetcode.cn/problems/search-in-rotated-sorted-array/) | 二分 |
| LRU 缓存 | [LeetCode 146](https://leetcode.cn/problems/lru-cache/) | 哈希+链表 |
| 最长无重复子串 | [LeetCode 3](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) | 滑动窗口 |
| 岛屿数量 | [LeetCode 200](https://leetcode.cn/problems/number-of-islands/) | DFS/BFS |
| 二叉树最大路径和 | [LeetCode 124](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) | DFS |

### 🚀 高级（加分项）

| 题目 | 链接 | 知识点 |
|------|------|--------|
| 接雨水 | [LeetCode 42](https://leetcode.cn/problems/trapping-rain-water/) | 双指针/单调栈 |
| 排序链表 | [LeetCode 148](https://leetcode.cn/problems/sort-list/) | 归并排序 |
| 单词搜索 II | [LeetCode 212](https://leetcode.cn/problems/word-search-ii/) | Trie + 回溯 |
| 滑动谜题 | [LeetCode 773](https://leetcode.cn/problems/sliding-puzzle/) | A* / BFS |
| 粉刷房子 | [LeetCode 1473](https://leetcode.cn/problems/paint-house-iii/) | 动态规划 |

---

## 三、机器学习面试题精选

### 📖 基础概念（100 问）

**Q1：什么是过拟合？如何解决？**
> 过拟合是模型在训练数据上表现很好，但在测试数据上泛化能力差。
> **解决**：增加数据量、正则化（L1/L2）、Dropout、早停、模型简化、交叉验证

**Q2：偏差和方差是什么关系？**
> 偏差：预测值与真实值的偏离程度（模型准确度）
> 方差：预测值的分散程度（模型稳定性）
> 好的模型：低偏差 + 低方差

**Q3：L1 和 L2 正则化的区别？**
> L1（ Lasso）：产生稀疏权重，可用于特征选择
> L2（ Ridge）：权重衰减，使所有特征都较小更稳定

**Q4：激活函数有哪些？Sigmoid 的问题？**
> 常用：ReLU、Leaky ReLU、Softmax、Tanh
> Sigmoid 问题：梯度消失、输出非零中心、计算开销大

**Q5：Dropout 的原理？为什么有效？**
> 训练时随机丢弃部分神经元，增强泛化能力
> 原理：类似集成学习，每个步骤训练不同子网络

---

### 🧠 算法原理面试题

**Q6：逻辑回归的损失函数？为什么用对数损失？**
> 损失函数：$L = -[y \log \hat{y} + (1-y) \log(1-\hat{y})]$
> 对数损失具有概率解释，且是凸函数便于优化

**Q7：XGBoost vs GBDT 的区别？**
> XGBoost 支持并行计算、缺失值自动处理、正则化、剪枝优化

**Q8：SVM 的核函数有哪些？如何选择？**
> 线性核、多项式核、RBF 核（高斯）
> RBF 适合非线性，数据量大时优先选线性

**Q9：决策树如何防止过拟合？**
> 预剪枝（限制深度、节点数量）、后剪枝（先生成再裁剪）、设置最小样本数

**Q10：K-means 的 K 如何选择？**
> 肘部法则（Elbow Method）、轮廓系数、Gap Statistic

---

### 🔥 深度学习面试题

**Q11：BatchNorm 的原理？为什么有效？**
> 对每层输出做归一化（均值0、方差1），再缩放平移
> 有效原因：加速收敛、缓解梯度消失、正则化效果

**Q12：Transformer 的核心是什么？**
> 自注意力机制（Self-Attention），并行计算、捕获长距离依赖

**Q13：残差网络（ResNet）为什么能训练深层网络？**
> 恒等映射让梯度直接回传，缓解梯度消失

**Q14：BERT vs GPT 的区别？**
> BERT：双向上下文，适用理解任务（分类、NER）
> GPT：单向（从左到右），适用生成任务

**Q15：RLHF 是什么？为什么重要？**
> Reinforcement Learning from Human Feedback
> 通过人类反馈微调，让模型输出更符合人类偏好

---

## 四、刷题平台推荐

### 💻 在线评测平台

| 平台 | 特点 | 适合人群 |
|------|------|----------|
| [LeetCode（中文站）](https://leetcode.cn/) | 题目最全，讨论区丰富 | 所有求职者 |
| [LeetCode（国际站）](https://leetcode.com/) | 原版，面试真题多 | 外资/海外 |
| [牛客网](https://www.nowcoder.com/) | 国内求职真题多 | 校招/社招 |
| [洛谷](https://www.luogu.com.cn/) | 算法竞赛风格 | 竞赛选手 |
| [Codeforces](https://codeforces.com/) | 高强度竞赛 | 算法竞赛者 |

### 📚 面经资源

| 资源 | 内容 |
|------|------|
| [面试指南](https://www.interviewguide.cn/) | 国内求职面试指南 |
| [牛客网面经](https://www.nowcoder.com/interview/experience) | 各大公司真实面经 |
| [一亩三分地](https://www.1point3acres.com/) | 海外留学生求职 |
| [GitHub: AI-Interview](https://github.com/DarionYap/AI-Interview-Notes) | AI 面试笔记 |

### 📖 算法学习资料

| 资料 | 链接 | 说明 |
|------|------|------|
| labuladong 算法笔记 | [GitHub](https://github.com/labuladong/fucking-algorithm) | 刷题技巧总结 |
| 程序员代码面试指南 | [GitHub](https://github.com/CyC2018/CS-Notes) | CS 基础知识 |
| AI 算法工程师面试手册 | [GitHub](https://github.com/amusi/AI-Job-Notes) | AI 岗位面经 |
| 百面机器学习 | [书籍](https://book.douban.com/subject/35039511/) | 经典 ML 面试书 |

---

## 五、大厂面试真题

### 🏢 算法岗（偏 AI）

| 公司 | 面试特点 |
|------|----------|
| 字节跳动 | 算法题难度高，LeetCode Hard 常考 |
| 阿里巴巴 | 业务导向，项目经验问得深 |
| 腾讯 | 基础扎实，注重系统设计 |
| 百度 | AI 技术深度考察，大模型必问 |
| 美团 | 偏向工程能力，代码题中等难度 |

### 📝 常见系统设计题

1. **设计一个推荐系统** - 协同过滤、Embedding
2. **设计一个搜索系统** - 倒排索引、向量检索
3. **设计 Twitter Feed** - Pull/Push 混合方案
4. **设计一个限流系统** - 令牌桶、滑动窗口
5. **大模型推理优化** - KV Cache、量化、蒸馏

---

## 六、面试准备建议

### 📅 准备时间表（3个月）

```
第1月：基础夯实
├─ 复习数据结构与算法（每天2题）
├─ 过一遍机器学习核心概念
└─ 完成入门级 LeetCode 50 题

第2月：专项突破
├─ 深度学习进阶（CNN/RNN/Transformer）
├─ 完成中级 LeetCode 80 题
├─ 准备项目亮点与难点
└─ 刷目标公司历年真题

第3月：模拟冲刺
├─ 全真模拟面试（牛客/LeetCode）
├─ 查漏补缺
├─ 准备 HR 面
└─ 调整心态
```

### ✅ 面试加分项

- 📁 能展示的代码项目（GitHub 有star更好）
- 📄 有影响力的技术博客
- 🏆 竞赛获奖经历（ACM、Kaggle）
- 📚 对 AI 前沿的持续关注

---

*→ 相关：[大模型专区](../大模型专区/README.md) | [论文精选](../论文精选/README.md) | [实战项目](../实战项目/README.md)*
