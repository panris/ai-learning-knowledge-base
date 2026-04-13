# Claude-Mem：跨会话持久化记忆系统

> 为 Claude Code 提供持久化记忆，让 AI 在每次新会话都能记住之前做过什么。

- **GitHub**：https://github.com/thedotmack/claude-mem
- **文档**：https://docs.claude-mem.ai
- **版本**：12.1.0
- **许可证**：AGPL-3.0
- **Star**：Trending 项目

---

## 核心功能

| 功能 | 说明 |
|------|------|
| 🧠 **持久化记忆** | 上下文跨会话存活，不丢失项目背景 |
| 📊 **渐进式披露** | 分层记忆检索，Token 消耗可见 |
| 🔍 **语义搜索** | 按含义搜索历史，而非关键词 |
| 🖥️ **Web 界面** | http://localhost:37777 实时查看记忆流 |
| 🔒 **隐私控制** | `<private>` 标签排除敏感内容 |
| 🤖 **自动运行** | 无需手动干预，后台自动处理 |

---

## 安装

```bash
# 方式1：npx 安装（推荐）
npx claude-mem install

# 方式2：从插件市场安装
/plugin marketplace add thedotmack/claude-mem
/plugin install claude-mem

# 方式3：OpenClaw 网关
curl -fsSL https://install.cmem.ai/openclaw.sh | bash
```

> 注意：`npm install -g claude-mem` 只装 SDK，不会注册钩子，必须用上述方式安装。

---

## 技术架构

### 5 个生命周期钩子

| 钩子事件 | 做什么 | 超时 |
|---------|--------|------|
| **Setup** | 安装系统依赖（Bun、uv） | 300s |
| **SessionStart** | 安装依赖 + 启动 Worker + 注入上下文 | 60s |
| **UserPromptSubmit** | 注册会话 + 启动 SDK Agent + 语义注入 | 60s |
| **PostToolUse** | 捕获工具调用 → 加入处理队列 | 120s |
| **Summary** | LLM 生成会话摘要 | 120s |
| **SessionEnd** | 结束会话 + 排空待处理消息 | 30s |

### 数据流

```
工具调用 → observation → /api/sessions/observations
      │
      ↓
PendingMessageStore.enqueue()
      │
      ↓
SDKAgent.startSession()
      │
      ↓
Claude Agent SDK → ResponseProcessor
      │
      ├── storeObservations() → SQLite
      ├── chromaSync.sync() → ChromaDB（向量）
      └── broadcastObservation() → SSE/Web UI
```

---

## 常用命令

```bash
# Worker 管理
npm run worker:start    # 启动
npm run worker:stop     # 停止
npm run worker:restart  # 重启
npm run worker:status   # 状态
npm run worker:tail      # 实时日志

# 队列管理
npm run queue          # 查看待处理
npm run queue:process  # 处理队列
npm run queue:clear    # 清空失败

# 开发构建
npm run build-and-sync # 编译 + 同步 + 重启 Worker

# Cursor 集成
npm run cursor:install   # 安装
npm run cursor:uninstall # 卸载
```

---

## 隐私控制

用 `<private>` 标签排除敏感内容：

```markdown
这是我的密码：<private>123456</private>，不要记住它。
```

标签在钩子层直接剥离，不会存入数据库。

---

## 相关项目

| 项目 | 说明 |
|------|------|
| [claude-code](https://github.com/anthropics/claude-code) | Claude 官方 CLI 工具 |
| [awesome-claude-code](https://github.com/thedotmack/awesome-claude-code) | Claude Code 资源精选 |
| [claude-code-best-practice](https://github.com/shanraisshan/claude-code-best-practice) | Claude Code 最佳实践 |

---

*最后更新：2026-04-13*
