# Claude Code 最佳实践

> 收录 Claude Code CLI 工具的使用技巧、配置指南和最佳实践。
> 
> 内容整理自 [claude-code-best-practice](https://github.com/shanraisshan/claude-code-best-practice)（30K+ ⭐）

---

## 📚 核心指南

| 文档 | 内容 | 行数 |
|------|------|------|
| [⚙️ 设置配置详解](./claude-settings.md) | 60+ 设置项、170+ 环境变量完整参考 | 964 行 |
| [🚀 CLI 启动参数](./claude-cli-startup-flags.md) | 命令行启动参数和子命令参考 | 221 行 |
| [📝 命令系统](./claude-commands.md) | 斜杠命令和 frontmatter 配置 | 106 行 |
| [🔌 MCP 服务器](./claude-mcp.md) | Model Context Protocol 配置指南 | 124 行 |
| [🧠 内存管理](./claude-memory.md) | CLAUDE.md 文件写法和加载机制 | 112 行 |
| [🎯 技能系统](./claude-skills.md) | Skills 技能配置和使用 | 47 行 |
| [🤖 子代理](./claude-subagents.md) | Subagents 配置和最佳实践 | 49 行 |

---

## 💡 Boris Cherny 技巧合集

> Boris Cherny 是 Claude Code 的创造者，以下是他的使用技巧分享。

| 文档 | 日期 | 内容 |
|------|------|------|
| [15 条技巧](./tips/claude-boris-15-tips-30-mar-26.md) | 2026-03-30 | 最新技巧合集 |
| [12 条技巧](./tips/claude-boris-12-tips-12-feb-26.md) | 2026-02-12 | 进阶使用技巧 |
| [10 条技巧](./tips/claude-boris-10-tips-01-feb-26.md) | 2026-02-01 | 基础使用技巧 |

---

## 🔗 相关资源

- [Claude Code 官方文档](https://docs.anthropic.com/claude-code)
- [Claude Code GitHub](https://github.com/anthropics/claude-code)
- [MCP 协议文档](https://modelcontextprotocol.io)
- [ClawdHub 技能市场](https://clawhub.com)

---

## 📋 快速参考

### 常用命令

```bash
# 启动 Claude Code
claude

# 指定模型
claude --model claude-sonnet-4-20250514

# 允许所有权限
claude --dangerously-skip-permissions

# 使用特定配置
claude --settings ./my-settings.json
```

### 常用斜杠命令

| 命令 | 功能 |
|------|------|
| `/help` | 显示帮助 |
| `/clear` | 清除上下文 |
| `/compact` | 压缩对话历史 |
| `/review` | 代码审查 |
| `/test` | 运行测试 |
| `/commit` | 提交代码 |

### CLAUDE.md 示例

```markdown
# 项目说明

这是一个示例项目。

## 代码规范

- 使用 TypeScript
- 遵循 ESLint 配置
- 测试覆盖率 > 80%

## 常用命令

- `npm run dev` - 启动开发服务器
- `npm run build` - 构建生产版本
- `npm test` - 运行测试
```

---

*最后更新: 2026-04-02*
