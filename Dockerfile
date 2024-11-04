# 第一阶段：构建项目
FROM maven:3.9.9-amazoncorretto-23 AS build

# 设置工作目录
WORKDIR /app

# 将 Maven 项目文件复制到镜像
COPY pom.xml .
COPY src ./src

# 使用 Maven 构建项目，生成 .jar 文件
RUN mvn clean package

# 第二阶段：创建运行环境
FROM amazoncorretto:23-alpine-full

# 设置工作目录
WORKDIR /app

# 从第一阶段复制生成的 .jar 文件到当前镜像中
COPY --from=build /app/target/my-simple-http-server-1.0-SNAPSHOT.jar app.jar

# 暴露端口
EXPOSE 8080

# 启动应用
CMD ["java", "-jar", "app.jar"]
