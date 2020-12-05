#FROM java:8
## 维护者信息
#MAINTAINER HuangKai
## 这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
#VOLUME /tmp
## 复制上下文目录下的 /build/libs/fastboot-0.0.1.jar 到容器里
#COPY target/git-demo-0.0.1-SNAPSHOT.jar git-demo-0.0.1-SNAPSHOT.jar
## bash方式执行，使fastboot-0.0.1.jar可访问
## RUN新建立一层，在其上执行这些命令，执行结束后， commit 这一层的修改，构成新的镜像。
#RUN bash -c "touch /git-demo-0.0.1-SNAPSHOT.jar"
## 指定时区
## ENV TZ='Asia/Shanghai'
## 声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务
#EXPOSE 10007
## 指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
#ENTRYPOINT ["java","-jar","git-demo-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]


FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

#FROM adoptopenjdk/openjdk8-openj9
#VOLUME /tmp
#
#ARG JAR_FILE=target/git-demo-0.0.1-SNAPSHOT.jar
#ARG PORT=8080
#ARG TIME_ZONE=Asia/Shanghai
#
#ENV TZ=${TIME_ZONE}
#ENV JAVA_OPTS="-Xms64m -Xmx256m"
#
#COPY ${JAR_FILE} git-demo.jar
#
#EXPOSE ${PORT}
#
#ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -server -jar git-demo.jar
