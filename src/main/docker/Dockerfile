#依赖java1.8,如果此镜像不行，请重新更换
FROM frolvlad/alpine-oraclejdk8:slim

#在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp

#copy项目jar，并重新命名
ADD code-1.0.jar code.jar

#缩短Tomcat启动时间，添加一个系统属性指向 “/dev/urandom”作为Entropy Source
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/code.jar"]