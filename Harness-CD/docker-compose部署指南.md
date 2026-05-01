# Harness CD — Docker Compose 部署指南

## 环境要求

- Docker 20.10+
- Docker Compose 1.29+
- 16 GB+ 可用内存
- 50 GB+ 可用磁盘空间

## 部署步骤

### 1. 克隆仓库

```bash
git clone https://github.com/harness/harness-cd-community.git
cd harness-cd-community
```

### 2. 进入目录

```bash
cd docker-compose/harness
```

### 3. 配置环境（如需要自定义）

```bash
# 查看配置示例
cat README.md
```

### 4. 启动服务

```bash
docker-compose up -d
```

### 5. 验证启动

```bash
docker-compose ps
```

服务启动后访问 Harness UI（约需 2-3 分钟初始化）。

## 默认端口

| 服务 | 端口 | 说明 |
|------|------|------|
| Harness UI | 9080 | Web 管理界面 |
| API | 9000 | REST API |
| MongoDB | 27017 | 数据存储 |
| Redis | 6379 | 缓存 |
| MySQL | 3306 | 关系数据 |

## 访问 Harness UI

- URL：`http://<host>:9080`
- 默认创建超级管理员账户

## 停止服务

```bash
docker-compose down
```

## 数据持久化

默认数据卷在容器内，停止后数据丢失。如需持久化，配置外部卷：

```yaml
# docker-compose.yml 中
volumes:
  mongodb_data:
  mysql_data:
```

## 故障排查

### 服务启动失败

```bash
docker-compose logs <service-name>
```

### 端口被占用

```bash
# 查找占用进程
lsof -i :9080
```

### 内存不足

确保 Docker Desktop/Machine 分配足够内存：
```bash
docker system info | grep "Memory"
```
