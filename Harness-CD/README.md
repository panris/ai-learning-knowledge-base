# Harness CD 社区版

> 现代持续交付平台 — **已于 2023 年 12 月归档**，转向 [Gitness](https://gitness.com/)

## 项目概述

Harness CD Community Edition 是 Harness CD 的免费开源版本，专为开发者设计，可在任意公有/私有云基础设施上快速部署云原生应用。

支持通过 **docker-compose**（Docker）或 **Helm Chart**（Kubernetes）快速自托管。

> ⚠️ **注意**：项目已于 2023 年 12 月正式归档，不再维护。官方推荐迁移至 [Gitness](https://gitness.com/)。

## 核心概念

### 部署架构

```
Harness CD Core
├── CI/CD Pipeline Engine
├── Git Experience          # Git 配置即代码
├── Kubernetes Deployer    # K8s 原生部署
├── Verification Module    # 自动验证 + 回滚
└── Approval Gate          # 内置审批节点
```

### 核心功能

| 功能 | 说明 |
|------|------|
| Kubernetes 部署 | 支持 Canary、Blue-Green、蓝绿发布 |
| Terraform 集成 | 基础设施即代码，自动化供应 |
| Pipeline-as-Code | YAML 定义流水线，Git 托管 |
| Git Experience | 实体配置 Git 化管理 |
| 自动回滚 | 验证失败自动回滚 |
| 内置审批 | 人工审批节点 |
| Harness SaaS | 官方托管版（Free/Team/Enterprise） |

## 快速部署

### Docker Compose 部署

```bash
cd docker-compose/harness
docker-compose up -d
```

详细步骤见 [docker-compose/README.md](./docker-compose部署指南.md)

### Helm Chart 部署

```bash
cd helm/harness
./harness.sh install
```

详细步骤见 [helm/README.md](./Helm部署指南.md)

## 部署模式

### 1. Canary 部署

渐进式流量切换，逐步将流量从旧版本迁移到新版本，支持自动监控和回滚。

### 2. Blue-Green 部署

双环境并行，通过负载均衡器切换流量，实现零 downtime 部署。

### 3. Rolling 部署

滚动更新，逐步替换 Pod，适用于无状态服务。

## 前置要求

| 方式 | 要求 |
|------|------|
| Docker Compose | Docker 20.10+、Docker Compose 1.29+、16GB+ RAM |
| Helm | Kubernetes 1.19+、Helm 3.x、Longhorn/NFS 存储 |

## 官方资源

- 📖 [官方文档](https://developer.harness.io/docs/continuous-delivery/)
- 💬 [社区 Slack](https://join.slack.com/t/harnesscommunity/) — `#cd-community` 频道
- 🌐 [社区论坛](https://community.harness.io/)
- 🔒 [安全策略](./SECURITY.md)

## 相关工具对比

| 工具 | 类型 | 特点 |
|------|------|------|
| Harness CD | 商业 + 开源 | 功能全面，CDaaS |
| ArgoCD | CNCF 项目 | GitOps 原生，Kubernetes 优先 |
| Flux | CNCF 项目 | GitOps，紧耦合 K8s |
| Jenkins X | Apache 2.0 | Jenkins 扩展，GitOps |
| Spinnaker | Netflix 出品 | 多云支持，成熟度高 |
