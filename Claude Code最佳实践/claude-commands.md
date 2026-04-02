# Commands Best Practice

[](../implementation/claude-commands-implementation.md)

Claude Code commands — frontmatter fields and official built-in slash commands.

---

## Frontmatter Fields (13)

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| `name` | string | No | Display name and `/slash-command` identifier. Defaults to the directory name if omitted |
| `description` | string | Recommended | What the command does. Shown in autocomplete and used by Claude for auto-discovery |
| `argument-hint` | string | No | Hint shown during autocomplete (e.g., `[issue-number]`, `[filename]`) |
| `disable-model-invocation` | boolean | No | Set `true` to prevent Claude from automatically invoking this command |
| `user-invocable` | boolean | No | Set `false` to hide from the `/` menu — command becomes background knowledge only |
| `paths` | string/list | No | Glob patterns that limit when this skill is activated. Accepts a comma-separated string or a YAML list. When set, Claude loads the skill automatically only when working with files matching the patterns |
| `allowed-tools` | string | No | Tools allowed without permission prompts when this command is active |
| `model` | string | No | Model to use when this command runs (e.g., `haiku`, `sonnet`, `opus`) |
| `effort` | string | No | Override the model effort level when invoked (`low`, `medium`, `high`, `max`) |
| `context` | string | No | Set to `fork` to run the command in an isolated subagent context |
| `agent` | string | No | Subagent type when `context: fork` is set (default: `general-purpose`) |
| `shell` | string | No | Shell for `` !`command` `` blocks — accepts `bash` (default) or `powershell`. Requires `CLAUDE_CODE_USE_POWERSHELL_TOOL=1` |
| `hooks` | object | No | Lifecycle hooks scoped to this command |

---

##  **(64)**

| # | Command | Tag | Description |
|---|---------|-----|-------------|
| 1 | `/login` |  | Sign in to your Anthropic account |
| 2 | `/logout` |  | Sign out from your Anthropic account |
| 3 | `/upgrade` |  | Open the upgrade page to switch to a higher plan tier |
| 4 | `/color [color\|default]` |  | Set the prompt bar color for the current session. Available colors: `red`, `blue`, `green`, `yellow`, `purple`, `orange`, `pink`, `cyan`. Use `default` to reset |
| 5 | `/config` |  | Open the Settings interface to adjust theme, model, output style, and other preferences. Alias: `/settings` |
| 6 | `/keybindings` |  | Open or create your keybindings configuration file |
| 7 | `/permissions` |  | View or update permissions. Alias: `/allowed-tools` |
| 8 | `/privacy-settings` |  | View and update your privacy settings. Only available for Pro and Max plan subscribers |
| 9 | `/sandbox` |  | Toggle sandbox mode. Available on supported platforms only |
| 10 | `/statusline` |  | Configure Claude Code's status line. Describe what you want, or run without arguments to auto-configure from your shell prompt |
| 11 | `/stickers` |  | Order Claude Code stickers |
| 12 | `/terminal-setup` |  | Configure terminal keybindings for Shift+Enter and other shortcuts. Only visible in terminals that need it, like VS Code, Alacritty, or Warp |
| 13 | `/theme` |  | Change the color theme. Includes light and dark variants, colorblind-accessible (daltonized) themes, and ANSI themes that use your terminal's color palette |
| 14 | `/vim` |  | Toggle between Vim and Normal editing modes |
| 15 | `/voice` |  | Toggle push-to-talk voice dictation. Requires a Claude.ai account |
| 16 | `/context` |  | Visualize current context usage as a colored grid. Shows optimization suggestions for context-heavy tools, memory bloat, and capacity warnings |
| 17 | `/cost` |  | Show token usage statistics. See cost tracking guide for subscription-specific details |
| 18 | `/extra-usage` |  | Configure extra usage to keep working when rate limits are hit |
| 19 | `/insights` |  | Generate a report analyzing your Claude Code sessions, including project areas, interaction patterns, and friction points |
| 20 | `/stats` |  | Visualize daily usage, session history, streaks, and model preferences |
| 21 | `/status` |  | Open the Settings interface (Status tab) showing version, model, account, and connectivity. Works while Claude is responding, without waiting for the current response to finish |
| 22 | `/usage` |  | Show plan usage limits and rate limit status |
| 23 | `/doctor` |  | Diagnose and verify your Claude Code installation and settings |
| 24 | `/feedback [report]` |  | Submit feedback about Claude Code. Alias: `/bug` |
| 25 | `/help` |  | Show help and available commands |
| 26 | `/release-notes` |  | View the full changelog, with the most recent version closest to your prompt |
| 27 | `/tasks` |  | List and manage background tasks |
| 28 | `/copy [N]` |  | Copy the last assistant response to clipboard. Pass a number `N` to copy the Nth-latest response: `/copy 2` copies the second-to-last. When code blocks are present, shows an interactive picker to select individual blocks or the full response. Press `w` in the picker to write the selection to a file instead of the clipboard, which is useful over SSH |
| 29 | `/export [filename]` |  | Export the current conversation as plain text. With a filename, writes directly to that file. Without, opens a dialog to copy to clipboard or save to a file |
| 30 | `/agents` |  | Manage agent configurations |
| 31 | `/chrome` |  | Configure Claude in Chrome settings |
| 32 | `/hooks` |  | View hook configurations for tool events |
| 33 | `/ide` |  | Manage IDE integrations and show status |
| 34 | `/mcp` |  | Manage MCP server connections and OAuth authentication |
| 35 | `/plugin` |  | Manage Claude Code plugins |
| 36 | `/reload-plugins` |  | Reload all active plugins to apply pending changes without restarting. Reports counts for each reloaded component and flags any load errors |
| 37 | `/skills` |  | List available skills |
| 38 | `/memory` |  | Edit `CLAUDE.md` memory files, enable or disable auto-memory, and view auto-memory entries |
| 39 | `/effort [low\|medium\|high\|max\|auto]` |  | Set the model effort level. `low`, `medium`, and `high` persist across sessions. `max` applies to the current session only and requires Opus 4.6. `auto` resets to the model default. Without an argument, shows the current level. Takes effect immediately without waiting for the current response to finish |
| 40 | `/fast [on\|off]` |  | Toggle fast mode on or off |
| 41 | `/model [model]` |  | Select or change the AI model. For models that support it, use left/right arrows to adjust effort level. The change takes effect immediately without waiting for the current response to finish |
| 42 | `/passes` |  | Share a free week of Claude Code with friends. Only visible if your account is eligible |
| 43 | `/plan [description]` |  | Enter plan mode directly from the prompt. Pass an optional description to enter plan mode and immediately start with that task, for example `/plan fix the auth bug` |
| 44 | `/add-dir ` |  | Add a new working directory to the current session |
| 45 | `/diff` |  | Open an interactive diff viewer showing uncommitted changes and per-turn diffs. Use left/right arrows to switch between the current git diff and individual Claude turns, and up/down to browse files |
| 46 | `/init` |  | Initialize project with a `CLAUDE.md` guide. Set `CLAUDE_CODE_NEW_INIT=1` for an interactive flow that also walks through skills, hooks, and personal memory files |
| 47 | `/pr-comments [PR]` |  | Fetch and display comments from a GitHub pull request. Automatically detects the PR for the current branch, or pass a PR URL or number. Requires the `gh` CLI |
| 48 | `/review` |  | Deprecated. Install the `code-review` plugin instead: `claude plugin install code-review@claude-plugins-official` |
| 49 | `/security-review` |  | Analyze pending changes on the current branch for security vulnerabilities. Reviews the git diff and identifies risks like injection, auth issues, and data exposure |
| 50 | `/desktop` |  | Continue the current session in the Claude Code Desktop app. macOS and Windows only. Alias: `/app` |
| 51 | `/install-github-app` |  | Set up the Claude GitHub Actions app for a repository. Walks you through selecting a repo and configuring the integration |
| 52 | `/install-slack-app` |  | Install the Claude Slack app. Opens a browser to complete the OAuth flow |
| 53 | `/mobile` |  | Show QR code to download the Claude mobile app. Aliases: `/ios`, `/android` |
| 54 | `/remote-control` |  | Make this session available for remote control from claude.ai. Alias: `/rc` |
| 55 | `/remote-env` |  | Configure the default remote environment for web sessions started with `--remote` |
| 56 | `/schedule [description]` |  | Create, update, list, or run Cloud scheduled tasks. Claude walks you through the setup conversationally |
| 57 | `/branch [name]` |  | Create a branch of the current conversation at this point. Alias: `/fork` |
| 58 | `/btw ` |  | Ask a quick side question without adding to the conversation |
| 59 | `/clear` |  | Clear conversation history and free up context. Aliases: `/reset`, `/new` |
| 60 | `/compact [instructions]` |  | Compact conversation with optional focus instructions |
| 61 | `/exit` |  | Exit the CLI. Alias: `/quit` |
| 62 | `/rename [name]` |  | Rename the current session and show the name on the prompt bar. Without a name, auto-generates one from conversation history |
| 63 | `/resume [session]` |  | Resume a conversation by ID or name, or open the session picker. Alias: `/continue` |
| 64 | `/rewind` |  | Rewind the conversation and/or code to a previous point, or summarize from a selected message. See checkpointing. Alias: `/checkpoint` |

Bundled skills such as `/debug` can also appear in the slash-command menu, but they are not built-in commands.

---

## Sources

- [Claude Code Slash Commands](https://code.claude.com/docs/en/slash-commands)
- [Claude Code Interactive Mode](https://code.claude.com/docs/en/interactive-mode)
- [Claude Code CHANGELOG](https://github.com/anthropics/claude-code/blob/main/CHANGELOG.md)