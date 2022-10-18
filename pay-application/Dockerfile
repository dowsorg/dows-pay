FROM openjdk:11

ENV LANG=en_US.UTF-8
ENV LC_ALL=en_US.UTF-8
ENV TZ=Asia/Shanghai

ENV JAVA_OPTIONS=""
ENV PARAMS=""

#多阶段构建方式：ADD maven/ /opt/
COPY target/*.jar /app.jar

# 记录一下最后保存进来的时间
RUN touch /app.jar

# docker run -e JAVA_OPTIONS="-Xmx -Xms..." imageName
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-Djava.security.egd=file:/dev/./urandom",'$JAVA_OPTIONS',"-jar","/opt/app.jar",'$PARAMS']

EXPOSE 8080