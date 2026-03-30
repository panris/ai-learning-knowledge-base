# 🧠 LLM 基础面试题

> 大语言模型核心概念、Transformer 架构、推理机制等面试高频题。
> 内容整理自 [amitshekhariitbhu/ai-engineering-interview-questions](https://github.com/amitshekhariitbhu/ai-engineering-interview-questions)（Apache 2.0）

---

## 基础概念

**Q1：什么是基础模型？它如何改变了 AI 工程？**
> 基础模型（Foundation Model）是在大规模数据上预训练的大模型，通过微调/提示工程适配下游任务。
> 改变：从"为每个任务训练专用模型"转变为"一个模型+多种适配方式"。

**Q2：什么是大语言模型（LLM）？如何工作？**
> 基于 Transformer 的自回归语言模型，通过预测下一个 token 生成文本。
> 核心流程：输入 → Tokenization → Embedding → Transformer 层 → 输出 Logits → 采样

**Q3：什么是 Transformer 架构？关键组件有哪些？**
> 核心组件：
> - **Multi-Head Self-Attention**：捕获 token 间全局依赖
> - **Feed-Forward Network**：逐位置非线性变换
> - **Layer Normalization**：稳定训练
> - **Residual Connection**：缓解梯度消失
> - **Positional Encoding**：注入位置信息

**Q4：Encoder-only vs Decoder-only vs Encoder-Decoder 有什么区别？**
> - **Encoder-only**（BERT）：双向注意力，擅长理解（分类、NER）
> - **Decoder-only**（GPT）：单向（因果）注意力，擅长生成
> - **Encoder-Decoder**（T5）：编码输入+解码输出，擅长翻译/摘要

**Q5：什么是 Tokenization？**
> 将文本转换为模型可处理的数字序列。主流方式：BPE（GPT）、WordPiece（BERT）、SentencePiece（多语言）

**Q6：解释 BPE（Byte Pair Encoding）**
> 迭代合并语料中出现频率最高的字节对，构建词表。从字符级逐步合并为子词/词级。

**Q7：什么是位置编码？为什么需要？**
> Transformer 本身没有位置感知，需要位置编码注入序列顺序信息。
> 类型：正弦位置编码、可学习位置编码、RoPE（旋转位置编码）

**Q8：什么是因果掩码（Causal Masking）？**
> 在 Decoder 的自注意力中，屏蔽未来位置的 token，确保只能看到当前位置之前的内容。
> 保证自回归生成的正确性。

---

## 注意力机制

**Q9：什么是自注意力？在 Transformer 中如何工作？**
> 每个 token 通过 Query 与所有 token 的 Key 计算相似度，加权求和 Value 得到新表示。
> 公式：`Attention(Q,K,V) = softmax(QK^T / √d_k) × V`

**Q10：解释 Q、K、V 在注意力中的含义**
> - **Query (Q)**：当前 token "想要什么信息"
> - **Key (K)**：每个 token "提供什么信息"
> - **Value (V)**：每个 token "实际的信息内容"

**Q11：什么是多头注意力？为什么用多个头？**
> 将注意力拆分为多个子空间并行计算，再拼接。
> 好处：每个头关注不同的语义关系（语法、语义、位置），提升表达能力。

**Q12：什么是 Grouped-Query Attention (GQA)？**
> 多个 Query 头共享同一组 Key/Value 头，减少 KV Cache 内存。
> 介于 MHA（每头独立 KV）和 MQA（所有头共享 KV）之间。

---

## 生成与推理

**Q13：什么是上下文窗口？为什么重要？**
> 模型一次能处理的最大 token 数量。决定了能输入多少上下文、生成长度。
> 扩展方法：RoPE 缩放、滑动窗口注意力、稀疏注意力。

**Q14：Temperature 是什么？如何影响输出？**
> 控制 softmax 分布的"锐利"程度。Temperature 越高越随机（多样），越低越确定（保守）。
> `T → 0`：贪心解码，`T → ∞`：均匀分布。

**Q15：Top-p 和 Top-k 采样的区别？**
> - **Top-k**：从概率最高的 k 个 token 中采样
> - **Top-p（Nucleus）**：从累计概率达到 p 的最小 token 集合中采样
> Top-p 更灵活，自动调整候选数量。

**Q16：什么是 Logits？**
> 模型最后一层输出的原始分数（未归一化）。经过 softmax 后变为概率分布。

**Q17：什么是 KV Cache？如何加速推理？**
> 缓存已计算的 Key 和 Value，避免自回归生成时重复计算历史 token 的注意力。
> 显著减少推理延迟，但占用内存随序列长度线性增长。

**Q18：什么是 Flash Attention？**
> 一种注意力计算的 IO 感知算法，通过分块计算减少内存访问，加速注意力计算并降低显存峰值。

**Q19：什么是 RoPE（旋转位置编码）？**
> 通过旋转矩阵在复数域编码位置信息。优点：支持外推（通过缩放扩展上下文长度）。

---

## 模型架构进阶

**Q20：什么是残差连接（Skip Connections）？**
> 将层输入直接加到层输出：`output = Layer(x) + x`。解决深层网络的梯度消失问题。

**Q21：什么是 MoE（Mixture of Experts）？**
> 将 FFN 层替换为多个 Expert 网络，通过门控路由选择激活。如 Mixtral 8x7B。
> 优势：模型参数大但激活参数少，推理效率高。

**Q22：Dense 模型 vs Sparse 模型的区别？**
> - Dense：所有参数每次推理都激活
> - Sparse（MoE）：只激活部分参数，计算量与激活参数成正比

**Q23：什么是模型蒸馏？**
> 用大模型（教师）指导小模型（学生）训练，让小模型学习大模型的知识。
> 方法：软标签蒸馏、特征蒸馏。

**Q24：什么是自回归 vs 掩码语言建模？**
> - 自回归（GPT）：从左到右逐个预测下一个 token
> - 掩码语言建模（BERT）：随机遮蔽部分 token，预测被遮蔽的 token

---

## 开源 vs 闭源

**Q25：开源 LLM 和闭源 LLM 的区别？如何选择？**
> - **开源**（Llama、Mistral）：可自部署、可微调、数据隐私好，但能力通常略低
> - **闭源**（GPT-4、Claude）：能力最强，但成本高、数据需经过第三方
> 选择：敏感数据/定制化需求 → 开源；追求最强能力 → 闭源

---

## 🔧 场景排障题

| 场景 | 思路 |
|------|------|
| LLM 忽略指令，不按格式输出 | 使用结构化输出 Prompt + JSON Schema + 输出解析器 |
| 上下文窗口不够处理长文档 | 文档分块 + 滑动窗口 + 递归摘要 + Map-Reduce |
| LLM 不承认不知道，编造答案 | 在系统 Prompt 中明确"不知道就说不知道" + RAG + 事实核查 |
| 回答太啰嗦 | 调低 Temperature + 明确字数限制 + 示例约束 |
| 泄露训练数据中的专有信息 | 差分隐私 + 数据过滤 + 输出审查 + 法律审计 |
| 生成过时代码（使用废弃库） | RAG 接入最新文档 + 工具调用查询最新版本 |
| Tokenizer 拆分专业术语 | 添加自定义 token + 微调 Tokenizer + 特殊 token |
| KV Cache 内存过大 | Paged Attention + GQA + 滑动窗口 + 量化 KV Cache |
| 长文档注意力计算 O(n²) 内存不足 | Flash Attention + 稀疏注意力 + Ring Attention |
| 蒸馏模型复杂推理能力下降 | 知识蒸馏 + 保留困难样本 + 渐进式蒸馏 + 对齐蒸馏 |
| RLHF 后能力下降（对齐税） | DPO 替代 RLHF + 混合训练数据 + 分阶段对齐 |
| RLHF 模型奖励黑客行为 | 奖励模型迭代 + 多元奖励信号 + 红队测试 |
| 对话 10 轮后丢失上下文 | 滑动窗口摘要 + 向量检索历史 + 分层记忆 |
| 用户中途切换话题 | 话题检测 + 意图识别 + 上下文分段 |
| QA 对不存在答案的问题也乱答 | 置信度检测 + "无法回答"选项 + RAG 置信阈值 |
| 摘要系统编造原文不存在的事实 | 事实一致性检测 + 引用来源 + 约束解码 |
| 长文本生成重复短语 | 重复惩罚（repetition_penalty）+ 采样策略 + 后处理 |

---

*← [AI面试主页](./README.md) | → [提示词工程面试题](./提示词工程.md)*
