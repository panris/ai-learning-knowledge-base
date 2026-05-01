# Hermes Agent ☤

> 自改进 AI Agent，由 [Nous Research](https://nousresearch.com) 构建

## 项目概述

Hermes 是目前唯一一个内置**自我改进循环**的 AI Agent——它从经验中创建技能（Skill），在使用中持续优化技能，主动记忆知识，跨会话搜索对话，并逐步建立对用户的深度认知模型。

支持在 $5 VPS、GPU 集群或 serverless 基础设施上运行，不绑定的笔记本，可以通过 Telegram 等平台远程控制云端 VM 工作。

## 核心特性

| 特性 | 说明 |
|------|------|
| 多模型支持 | OpenRouter（200+模型）、OpenAI、Hugging Face、Nous Portal、小米 MiMo、GLM、MiniMax 等 |
| 多平台接入 | Telegram、Discord、Slack、WhatsApp、Signal、Email，统一 gateway |
| 自改进技能系统 | Agent 从复杂任务中自主创建技能，使用中持续优化 |
| 跨会话记忆 | FTS5 全文搜索 + LLM 摘要，支持跨会话上下文恢复 |
| 定时自动化 | 内置 Cron 调度器，支持任意通道的定时推送报告 |
| 终端接口 | 完整 TUI，支持多行编辑、斜杠命令自动补全、流式工具输出 |
| 研究工具 | 批量轨迹生成、RL 环境（Atropos）、轨迹压缩 |
| 多种后端 | 本地、Docker、SSH、Daytona、Singularity、Modal |
| OpenClaw 兼容 | 提供 `/claw migrate` 命令从 OpenClaw 迁移 |

## 快速安装

```bash
curl -fsSL https://raw.githubusercontent.com/NousResearch/hermes-agent/main/scripts/install.sh | bash
source ~/.bashrc   # 或 source ~/.zshrc
hermes             # 启动交互式 CLI
```

安装后配置：

```bash
hermes model        # 选择 LLM 提供商和模型
hermes tools       # 配置启用的工具
hermes gateway     # 启动消息网关
hermes setup       # 运行完整配置向导
hermes doctor      # 诊断问题
```

## 文档入口

- 📖 [官方文档](https://hermes-agent.nousresearch.com/docs/)
- 💬 [Discord 社区](https://discord.gg/NousResearch)

## 本知识库索引

- [快速入门](./快速入门.md)
- [核心架构解析](./核心架构.md)
- [技能系统与自改进机制](./技能系统.md)
- [网关与消息通道配置](./网关与消息通道.md)
