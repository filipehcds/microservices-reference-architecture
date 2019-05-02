FROM openjdk:12

ARG SPRING_PROFILES_ACTIVE
ARG JAVA_OPTS
ARG PORT

ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE:-docker}
ENV JAVA_OPTS ${JAVA_OPTS:-'-Xmx512m'}
ENV DEBUG_OPTS ${DEBUG_OPTS}
ENV PORT ${PORT:-8082}

ADD *.jar /app.jar

VOLUME /tmp

RUN sh -c 'touch /app.jar'

RUN yum install wget -y
RUN wget https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz
RUN tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.6.1.tar.gz

EXPOSE ${PORT}

CMD dockerize -wait http://config-server:8888/actuator/health -timeout 60s java ${JAVA_OPTS} ${DEBUG_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar