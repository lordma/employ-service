# 基础镜i像
FROM openjdk:11

# 作者信息
MAINTAINER lordma <lordma@msn.cn>

# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp

# 将当前目录下的jar包复制到容器里（crm-0.0.1-SNAPSHOT.jar修改为你的jar包名字）
COPY employ-generator-0.0.1-SNAPSHOT.jar  /employ-service.jar

# 提示当前项目在容器运行的端口
CMD ["========server.port = 8181=========="]

# 暴露运行的端口
EXPOSE 8181

# 执行jar包
ENTRYPOINT ["java","-jar","/employ-service.jar"]
