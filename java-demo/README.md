# Java Demo 模块

> AI/ML 知识点的 Java 实现示例，配合 [AI面试](../AI面试) 知识库使用。

---

## 项目结构

```
java-demo/
├── src/main/java/com/ai/demo/
│   ├── ml/              # 机器学习算法
│   │   ├── LinearRegression.java      # 线性回归
│   │   ├── LogisticRegression.java    # 逻辑回归
│   │   ├── KNN.java                   # K近邻
│   │   └── DecisionTree.java          # 决策树
│   ├── algorithm/       # 数据结构与算法
│   │   ├── LinkedList.java            # 链表实现
│   │   ├── BinaryTree.java            # 二叉树
│   │   └── Sorting.java               # 排序算法
│   ├── rag/             # RAG 实现
│   │   ├── SimpleRAG.java             # RAG 系统 demo
│   │   └── VectorStore.java           # 向量存储
│   ├── agent/           # Agent 实现
│   │   └── ReActAgent.java            # ReAct Agent
│   ├── llm/             # LLM 调用
│   │   └── LLMClient.java             # LLM API 客户端
│   └── Main.java        # 主入口
├── src/test/java/       # 单元测试
└── pom.xml              # Maven 配置
```

---

## 快速开始

### 前置条件

- JDK 17+
- Maven 3.6+

### 运行示例

```bash
# 编译
mvn clean compile

# 运行主程序
mvn exec:java -Dexec.mainClass="com.ai.demo.Main"

# 运行测试
mvn test
```

---

## 模块说明

### 📊 机器学习 (ml)

对应知识点：[机器学习基础](../AI面试/机器学习基础.md)

| 类名 | 说明 | 核心算法 |
|------|------|---------|
| LinearRegression | 线性回归实现 | 梯度下降、最小二乘法 |
| LogisticRegression | 逻辑回归实现 | Sigmoid、交叉熵损失 |
| KNN | K近邻分类器 | 欧氏距离、投票机制 |
| DecisionTree | 决策树实现 | ID3/C4.5、信息增益 |

**示例代码：**
```java
// 线性回归
LinearRegression lr = new LinearRegression();
lr.fit(X, y);
double[] predictions = lr.predict(XTest);

// KNN 分类
KNN knn = new KNN(3);  // k=3
knn.fit(XTrain, yTrain);
int[] predictedLabels = knn.predict(XTest);
```

---

### 🧮 数据结构与算法 (algorithm)

对应知识点：AI 面试中的算法题部分

| 类名 | 说明 | 时间复杂度 |
|------|------|-----------|
| LinkedList | 单链表实现 | 插入 O(1)，查找 O(n) |
| BinaryTree | 二叉搜索树 | 查找/插入 O(log n) |
| Sorting | 排序算法集 | 快排 O(n log n) |

**示例代码：**
```java
// 快速排序
int[] arr = {5, 2, 8, 1, 9};
Sorting.quickSort(arr);

// 二叉树遍历
BinaryTree tree = new BinaryTree();
tree.insert(5);
tree.insert(3);
tree.insert(7);
tree.inorderTraversal();  // 中序遍历
```

---

### 📚 RAG 系统 (rag)

对应知识点：[RAG 专题](../AI面试/RAG专题.md)

| 类名 | 说明 |
|------|------|
| SimpleRAG | 简单 RAG 系统实现 |
| VectorStore | 内存向量存储 |

**核心流程：**
1. 文档分块 (Chunking)
2. 向量化 (Embedding)
3. 向量存储 (Vector Store)
4. 相似度检索 (Similarity Search)
5. 上下文构建 (Context Building)

**示例代码：**
```java
SimpleRAG rag = new SimpleRAG();

// 添加文档
rag.addDocument("机器学习是人工智能的一个分支...");
rag.addDocument("深度学习使用神经网络...");

// 查询
String answer = rag.query("什么是机器学习?");
```

---

### 🤖 Agent (agent)

对应知识点：[Agent 专题](../AI面试/Agent专题.md)

| 类名 | 说明 |
|------|------|
| ReActAgent | ReAct 模式 Agent |

**ReAct 模式：**
```
Thought → Action → Observation → Thought → ...
```

**示例代码：**
```java
ReActAgent agent = new ReActAgent(llmClient);
agent.addTool("search", "搜索知识库", this::searchKnowledge);

String result = agent.run("查找关于 Transformer 的资料");
```

---

### 🧠 LLM 客户端 (llm)

对应知识点：[LLM 基础](../AI面试/LLM基础.md)

| 类名 | 说明 |
|------|------|
| LLMClient | 统一的 LLM API 客户端 |

**支持的 API：**
- OpenAI (GPT-4, GPT-3.5)
- Claude (claude-3-opus, claude-3-sonnet)
- 本地模型 (Ollama)

**示例代码：**
```java
LLMClient client = new LLMClient("openai", apiKey);

String response = client.chat(
    "请解释什么是 Transformer 架构"
);

// 流式输出
client.chatStream("写一首关于 AI 的诗", chunk -> {
    System.out.print(chunk);
});
```

---

## 学习路径

1. **基础算法** → `algorithm/` 包
   - 从链表、二叉树开始
   - 理解时间/空间复杂度

2. **机器学习** → `ml/` 包
   - 线性回归、逻辑回归
   - KNN、决策树

3. **LLM 应用** → `llm/` + `rag/`
   - API 调用
   - RAG 系统构建

4. **Agent 开发** → `agent/`
   - ReAct 模式
   - 工具调用

---

## 测试覆盖

每个模块都有对应的单元测试：

```bash
# 运行所有测试
mvn test

# 运行单个测试类
mvn test -Dtest=LinearRegressionTest
```

---

## 配置说明

在 `src/main/resources/application.properties` 中配置 API Key：

```properties
# OpenAI
openai.api.key=sk-xxx
openai.api.base=https://api.openai.com/v1

# Claude
claude.api.key=sk-ant-xxx

# Ollama (本地)
ollama.api.base=http://localhost:11434
```

---

## 相关资源

- [AI 面试知识库](../AI面试/)
- [大模型后端面试系统](../AI面试/大模型后端面试系统.md)
- [机器学习基础](../AI面试/机器学习基础.md)
- [RAG 专题](../AI面试/RAG专题.md)

---

## License

MIT
