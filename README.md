## sampleweb-java-maven

介绍：基于java httpserver模块实现简单的web服务器，并使用maven进行构建。

## 快速入门

运行容器

```
docker run -d --name sampleweb-java-maven -p 8080:8080 \
registry.cn-shenzhen.aliyuncs.com/cnmirror/sampleweb-java-maven:v1.0
```

浏览器访问

```
http://localhost:8080
```

## 构建示例

```
git clone https://github.com/willzhang/sampleweb-java-maven.git
cd sampleweb-java-maven
docker build -t registry.cn-shenzhen.aliyuncs.com/cnmirror/sampleweb-java-maven:v1.0 .
```

