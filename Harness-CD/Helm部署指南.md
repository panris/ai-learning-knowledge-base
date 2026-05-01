# Harness CD — Helm Chart 部署指南

## 环境要求

- Kubernetes 1.19+
- Helm 3.x
- 8+ CPU 核心
- 32 GB+ 内存
- Longhorn / NFS / 云存储（持久卷）

## 部署步骤

### 1. 添加 Helm 仓库

```bash
helm repo add harness https://harness.github.io/harness-cd-community/helm
helm repo update
```

### 2. 安装 Chart

```bash
cd helm/harness
./harness.sh install
```

### 3. 或直接用 Helm 安装

```bash
helm install harness harness/harness \
  --namespace harness \
  --create-namespace
```

### 4. 验证部署

```bash
kubectl get pods -n harness
kubectl get svc -n harness
```

## 创建第一个 Pipeline

### 1. 登录 Harness UI

获取 LoadBalancer 入口：

```bash
kubectl get svc -n harness -o wide
```

### 2. 配置 Kubernetes 连接器

在 UI 中配置 kubeconfig，指向目标 K8s 集群。

### 3. 创建 Pipeline

```bash
# 示例：部署 nginx 微服务
# 1. 新建 Pipeline
# 2. 添加 Kubernetes 部署步骤
# 3. 配置服务（nginx）
# 4. 设置工作流（Canary/Rolling）
# 5. 部署！
```

### 4. Git Experience（可选）

将 Pipeline 配置存储在 Git 中，实现配置即代码：

```
Settings → Git Experience → Connect Repository
```

## 卸载

```bash
./harness.sh uninstall
# 或
helm uninstall harness -n harness
kubectl delete namespace harness
```
