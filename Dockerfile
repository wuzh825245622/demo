#指定基础镜像
FROM java:8
WORKDIR /test/springboot
#将本地文件夹挂载到当前容器
VOLUME /log
#复制文件到容器

COPY /target/demo-0.0.2-SNAPSHOT.jar /test/springboot/app2.jar
#声明需要暴露的接口
EXPOSE 8080
#配置容器启动后执行的命令
ENTRYPOINT ["java","-jar"]
CMD ["/test/springboot/app2.jar"]
