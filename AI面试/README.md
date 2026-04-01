# 🤖 AI/算法面试

> 收录 AI 算法、机器学习、深度学习、大模型面试相关资源，持续更新。
> 结合 Cursor、Claude 等 AI 工具，高效备战面试。

---

## 📑 AI 工程面试专题（200+ 题）

> 系统整理自 [ai-engineering-interview-questions](https://github.com/amitshekhariitbhu/ai-engineering-interview-questions)，覆盖 AI Engineer / LLM Engineer / Agent Engineer 岗位。

| 专题 | 题数 | 内容 |
|------|------|------|
| [🧠 LLM 基础](./LLM基础.md) | 25+ | Transformer、注意力、生成推理、MoE、蒸馏 |
| [💬 提示词工程](./提示词工程.md) | 16+ | CoT、ReAct、Prompt 注入、Few-shot、多语言 |
| [📚 RAG 专题](./RAG专题.md) | 22+ | 分块、Embedding、混合搜索、Graph RAG、评估 |
| [🤖 Agent 专题](./Agent专题.md) | 18+ | ReAct、MCP、工具调用、多 Agent、安全沙箱 |
| [🔧 微调专题](./微调专题.md) | 18+ | LoRA、QLoRA、RLHF、数据准备、灾难性遗忘 |
| [🗄️ 向量数据库](./向量数据库.md) | 13+ | Embedding、相似度、ANN、量化、漂移 |
| [🏗️ 系统设计与 LLMOps](./系统设计.md) | 30+ | 系统设计题、生产部署、评估测试、安全伦理 |

---

## 🎯 大模型后端开发面试系统

> 📄 [面试题库（Markdown）](./大模型后端面试系统.md) | 🌐 [交互式网页版（含 AI 自动评分）](./interview-scoring.html)

### 43 道面试题 + AI 自动评分，覆盖 6 大模块：

| 模块 | 题数 | 核心考点 |
|------|------|---------|
| LLM 基础 | 10 题 | Tokenizer、Transformer、KV Cache、RoPE、Flash Attention、MoE |
| 推理优化 | 10 题 | 量化、PagedAttention、Continuous Batching、TP、Speculative Decoding |
| RAG 与向量数据库 | 5 题 | Lost in Middle、混合搜索、Re-ranking、Graph RAG、HNSW |
| Agent 与工具调用 | 5 题 | ReAct、MCP、记忆系统、代码沙箱安全 |
| 模型部署与服务化 | 10 题 | vLLM/TGI/TRT-LLM、Gateway、限流调度、监控 |
| 向量数据库与 Embedding | 3 题 | 选型、MTEB、ANN 索引 |

### 评分维度
- **准确性**（35%）：核心概念是否正确
- **完整性**（35%）：是否覆盖主要知识点
- **深度**（30%）：是否有深入理解和独到见解

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
| 大模型 | Transformer、RLHF、Prompt Engineering、RAG | ⭐⭐⭐⭐⭐ |
| 工程能力 | 模型部署、特征工程、性能优化、量化 | ⭐⭐⭐⭐⭐ |

---

## 二、AI 辅助面试准备

### 🤖 用 AI 工具高效备战

AI 工具（Cursor、Claude 等）已经成为面试准备的核心利器，以下是最佳实践：

#### 🔧 Cursor 备战面试

| 场景 | 使用方法 |
|------|----------|
| **模拟面试** | 让 Claude/Cursor 扮演面试官，随机出题 |
| **代码评审** | 粘贴代码，让 AI 审查漏洞和优化空间 |
| **讲解算法** | 输入 LeetCode 题号，让 AI 详细讲解思路 |
| **生成变体题** | 让 AI 基于某道题生成类似题目练习 |
| **系统设计** | 让 AI 陪你演练系统设计题，追问深挖 |

**Cursor 实战 Prompt 示例**：
```
你是一个资深算法面试官，请随机出一道中等难度的算法题，
包含题目描述、示例输入输出、约束条件。
等我想出思路后再给出最优解法和代码实现。
```

#### 💬 Claude 备战面试

| 场景 | 使用方法 |
|------|----------|
| **知识点复习** | "请详细解释 [知识点]，并给出面试中可能被问到的问题" |
| **项目深挖** | "请针对 [项目经验]，从面试官角度深挖可能的问题" |
| **行为面准备** | "请用 STAR 法则帮我准备 [经历] 的描述" |
| **Mock Interview** | "请以 [公司] 面试风格进行一轮模拟面试" |
| **简历优化** | "请帮我优化简历中 [模块] 的描述，突出技术亮点" |

**Claude 面试模拟 Prompt**：
```
请扮演 [公司] 的高级算法工程师，进行一轮 45 分钟的模拟面试：
1. 先问 2 道算法题（难度适中）
2. 再问 2 道机器学习/深度学习问题
3. 最后问一个系统设计题
每道题请等我回答后再给出反馈，不要直接给答案。
```

---

## 三、必刷编程题（按难度）

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
| 环形链表 | [LeetCode 141](https://leetcode.cn/problems/linked-list-cycle/) | 双指针 |
| 平衡二叉树 | [LeetCode 110](https://leetcode.cn/problems/balanced-binary-tree/) | DFS |

### ⭐ 中级（高频）

| 题目 | 链接 | 知识点 |
|------|------|--------|
| 全排列 | [LeetCode 46](https://leetcode.cn/problems/permutations/) | 回溯 |
| 搜索旋转排序数组 | [LeetCode 33](https://leetcode.cn/problems/search-in-rotated-sorted-array/) | 二分 |
| LRU 缓存 | [LeetCode 146](https://leetcode.cn/problems/lru-cache/) | 哈希+链表 |
| 最长无重复子串 | [LeetCode 3](https://leetcode.cn/problems/longest-substring-without-repeating-characters/) | 滑动窗口 |
| 岛屿数量 | [LeetCode 200](https://leetcode.cn/problems/number-of-islands/) | DFS/BFS |
| 二叉树最大路径和 | [LeetCode 124](https://leetcode.cn/problems/binary-tree-maximum-path-sum/) | DFS |
| 括号生成 | [LeetCode 22](https://leetcode.cn/problems/generate-parentheses/) | 回溯 |
| 合并 K 个升序链表 | [LeetCode 23](https://leetcode.cn/problems/merge-k-sorted-lists/) | 堆 |

### 🚀 高级（加分项）

| 题目 | 链接 | 知识点 |
|------|------|--------|
| 接雨水 | [LeetCode 42](https://leetcode.cn/problems/trapping-rain-water/) | 双指针/单调栈 |
| 排序链表 | [LeetCode 148](https://leetcode.cn/problems/sort-list/) | 归并排序 |
| 单词搜索 II | [LeetCode 212](https://leetcode.cn/problems/word-search-ii/) | Trie + 回溯 |
| 滑动谜题 | [LeetCode 773](https://leetcode.cn/problems/sliding-puzzle/) | A* / BFS |
| 粉刷房子 | [LeetCode 1473](https://leetcode.cn/problems/paint-house-iii/) | 动态规划 |
| 编辑距离 | [LeetCode 72](https://leetcode.cn/problems/edit-distance/) | DP |

---

## 四、机器学习面试题精选

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

## 五、大模型面试专题（2024-2025高频）

大模型岗位必问，重点准备！

### 🧠 大模型基础

**Q16：LLM 的涌现能力是什么？有哪些涌现能力？**
> 涌现能力（Emergent Abilities）：当模型参数量超过某个阈值后，突然出现的能力
> 典型涌现能力：思维链（CoT）、上下文学习（ICL）、多步推理

**Q17：Transformer 的注意力机制是什么？Self-Attention 计算过程？**
> 通过 Query-Key-Value 计算 token 之间的相关性分数
> 公式：Attention(Q,K,V) = softmax(QK^T / √d) × V

**Q18：RAG 是什么？和微调的区别？如何选择？**
> RAG（检索增强生成）：结合向量数据库检索 + LLM 生成
> 适用场景：知识更新频繁、需要引用外部知识
> 微调适用：学习特定格式、风格、领域知识

**Q19：大模型推理加速有哪些方法？**
> 量化（GPTQ/GGUF/INT8/INT4）、KV Cache、Batch 优化、投机解码、蒸馏

**Q20：LoRA 的原理？为什么高效？**
> Low-Rank Adaptation：在原模型参数旁添加低秩矩阵，只训练新增部分
> 高效原因：参数量少（通常 <1%），显存占用低，无需全量微调

**Q21：Prefix Tuning vs LoRA vs Adapter 的区别？**
> Prefix Tuning：在输入前加可学习前缀
> LoRA：低秩矩阵分解，傍路更新
> Adapter：插入小型全连接层

**Q22：如何评估 LLM 的效果？有哪些指标？**
> 困惑度（Perplexity）、BLEU、ROUGE（文本生成）
> MMLU、CMMLU（中文评测）、BIG-Bench（综合能力）
> 人工评估（流畅性、准确性、安全性）

**Q23：Context Length 是如何扩展的？有哪些主流方案？**
> 位置编码扩展：RoPE（旋转位置编码）、ALiBi
> 长上下文方案：稀疏注意力、滑动窗口、FlashAttention

**Q24：Tokenization 方式有哪些？BPE vs WordPiece vs SentencePiece？**
> BPE：字节对编码，常用于 GPT 系列
> WordPiece：Google BERT 使用
> SentencePiece：统一Tokenizer，支持多语言

**Q25：什么是 LangChain？Agent 是什么？**
> LangChain：大模型应用开发框架，提供 RAG、Chain、Agent 等组件
> Agent：能够自主规划、调用工具、执行多步任务的 LLM 应用

---

## 六、刷题平台推荐

### 💻 在线评测平台

| 平台 | 特点 | 适合人群 |
|------|------|----------|
| [LeetCode（中文站）](https://leetcode.cn/) | 题目最全，讨论区丰富 | 所有求职者 |
| [LeetCode（国际站）](https://leetcode.com/) | 原版，面试真题多 | 外资/海外 |
| [牛客网](https://www.nowcoder.com/) | 国内求职真题多 | 校招/社招 |
| [洛谷](https://www.luogu.com.cn/) | 算法竞赛风格 | 竞赛选手 |
| [Codeforces](https://codeforces.com/) | 高强度竞赛 | 算法竞赛者 |
| [AtCoder](https://atcoder.jp/) | 日本竞赛平台 | 日企/外企 |

### 🤖 AI 辅助刷题

| 工具 | 用途 | 特点 |
|------|------|------|
| [Cursor](https://www.cursor.com/) | AI 代码编辑器，边写边学 | 实时补全 + AI 对话 |
| [Claude](https://claude.ai/) | 算法讲解、面试模拟 | 长上下文、讲解深入 |
| [Copilot](https://github.com/features/copilot) | 代码补全 | 集成 VS Code |
| [Code Interpreter](https://chat.openai.com/) | 代码执行 + 分析 | 边跑边改 |

---

## 七、面经资源

### 📚 面经网站

| 资源 | 内容 |
|------|------|
| [面试指南](https://www.interviewguide.cn/) | 国内求职面试指南 |
| [牛客网面经](https://www.nowcoder.com/interview/experience) | 各大公司真实面经 |
| [脉脉](https://maimai.cn/) | 职场八卦、内推机会 |
| [51CTO](https://www.51cto.com/) | IT 技术社区，面试经验 |

### 📖 GitHub 面经资源

| 资源 | 链接 | 说明 |
|------|------|------|
| AI-Interview-Notes | [GitHub](https://github.com/DarionYap/AI-Interview-Notes) | AI 面试笔记 |
| AI-Job-Notes | [GitHub](https://github.com/amusi/AI-Job-Notes) | AI 岗位面经 |
| 算法/ML/NLPCheatsheet | [GitHub](https://github.com/Zhisheng-Ai/ML-NLP) | ML/NLP 知识速查 |
| CodingInterview | [GitHub](https://github.com/CyC2018/CS-Notes) | CS 基础知识 |
| 互联网大厂面经 | [GitHub](https://github.com/AIOps-community/AI-Interview) | 大厂 AI 岗面经 |

### 📺 面试视频教程

| 视频 | 链接 | 内容 |
|------|------|------|
| 字节/阿里/腾讯面经 | [B站搜索](https://search.bilibili.com/?keyword=AI%E9%9D%A2%E7%BB%8F&order=totalrank) | 真实面试经验分享 |
| 算法面试全套 | [B站](https://www.bilibili.com/video/BV1UQPZzqEN6) | 系统学习视频 |

---

## 八、大厂面试真题

### 🏢 算法岗（偏 AI）

| 公司 | 面试特点 | 高频题类型 |
|------|----------|-----------|
| 字节跳动 | 算法题难度高 | Hard 常考，DP/图论 |
| 阿里巴巴 | 业务导向 | 项目深挖、系统设计 |
| 腾讯 | 基础扎实 | 中等难度 + 系统设计 |
| 百度 | AI 技术深度 | 大模型必问、论文讨论 |
| 美团 | 工程能力 | 中等难度 + 项目 |
| 华为 | 基础扎实 | 算法 + 场景设计 |
| 小红书 | 创意导向 | 产品思维 + 算法 |

### 🏢 大模型专项岗位

| 公司/团队 | 面试侧重点 |
|----------|-----------|
| 字节-Seed | LLM预训练、模型优化 |
| 阿里-通义 | RAG、Agent、应用落地 |
| 百度-文心 | NLP、大模型微调 |
| 月之暗面 | 长上下文、超长文本处理 |
| 智谱AI | 学术研究、论文实现 |
| MiniMax | 多模态、视频生成 |

### 📝 常见系统设计题

1. **设计一个推荐系统** - 协同过滤、Embedding、向量检索
2. **设计一个搜索系统** - 倒排索引、向量检索、排序模型
3. **设计 Twitter Feed** - Pull/Push 混合方案
4. **设计一个限流系统** - 令牌桶、滑动窗口
5. **设计 LLM + RAG 系统** - 向量数据库、召回优化、重排
6. **设计 AI Agent 系统** - Tool Use、Memory、Planning
7. **大模型推理服务部署** - 量化、加速、多并发

---

## 九、面试准备建议

### 📅 准备时间表（3个月）

```
第1月：基础夯实
├─ 复习数据结构与算法（每天2题）
├─ 过一遍机器学习核心概念
├─ 完成入门级 LeetCode 50 题
└─ 用 Claude 梳理项目经历

第2月：专项突破
├─ 深度学习进阶（CNN/RNN/Transformer）
├─ 大模型专项（LoRA/RAG/Agent）
├─ 完成中级 LeetCode 80 题
├─ 准备项目亮点与难点
└─ 刷目标公司历年真题

第3月：模拟冲刺
├─ 全真模拟面试（Claude/Mancer）
├─ 查漏补缺
├─ AI 辅助简历优化
├─ 准备 HR 面
└─ 调整心态
```

### 🤖 AI 辅助面试清单

- [ ] 用 Claude 生成个人面试模拟对话
- [ ] 用 Cursor 练习代码题，边写边问 AI 优化建议
- [ ] 用 Claude 深挖项目经历，准备 STAR 回答
- [ ] 用 AI 工具生成行为面高频问题回答
- [ ] 用 Claude 复习概念，要求它出追问

### ✅ 面试加分项

- 📁 能展示的代码项目（GitHub 有star更好）
- 📄 有影响力的技术博客
- 🏆 竞赛获奖经历（ACM、Kaggle）
- 📚 对 AI 前沿的持续关注
- 🤖 有 AI 工具使用经验的落地案例

---

## 十、面试高频 Prompt 模板

### 模拟面试 Prompt

```
【系统设定】
你是一位来自 [字节/阿里/腾讯] 的资深算法工程师。
请以该公司的面试风格进行一轮 45 分钟的模拟面试。

【面试流程】
第一部分（15分钟）：算法题
- 先出一道 [简单/中等/困难] 难度的算法题
- 等我回答后给出反馈（思路、复杂度、代码规范）
- 最多问 2 道题

第二部分（15分钟）：技术深度
- 问 2 道 [机器学习/深度学习/大模型] 问题
- 如果回答浅了，请追问深挖

第三部分（15分钟）：项目 & 行为面
- 深挖我的项目经历
- 问一道系统设计题

【我的背景】
[简要描述你的背景：研究方向、工作经验、目标岗位]

请开始面试！
```

### 简历优化 Prompt

```
请帮我优化简历中的 [项目名称] 模块。

项目描述：[当前描述]
技术栈：[使用的技术]
我的贡献：[我的工作]

要求：
1. 突出技术亮点和业务价值
2. 使用量化指标（提升X%、节省X时间）
3. 避免过于空泛的描述
4. 让面试官能针对这个项目深挖

请给出优化后的版本和修改理由。
```

### 算法讲解 Prompt

```
请详细讲解 LeetCode [题号] [题目名称]。

要求：
1. 先给出解题思路分析（3种以上方案）
2. 分析各方案的时间和空间复杂度
3. 给出最优解的 Python 代码实现
4. 如果有相似题目，请推荐
5. 在公司面试中，这道题的考察重点是什么？
```

---

*→ 相关：[大模型专区](../大模型专区/README.md) | [论文精选](../论文精选/README.md) | [实战项目](../实战项目/README.md)*
