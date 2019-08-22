FROM openjdk:8-jre

RUN apt-get install -y ca-certificates
# Allow easy cert reference
ENV TGT_CA_BUNDLE_PATH=/usr/local/share/ca-certificates/tgt-ca-bundle.crt
# Add tgt cert chain
RUN wget http://browserconfig.target.com/tgt-certs/tgt-ca-bundle.crt -O ${TGT_CA_BUNDLE_PATH} -q \
&& update-ca-certificates --fresh 2>&1
WORKDIR /usr/src/app/target
COPY build/libs/*.jar .
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /usr/src/app/target/*.jar"]
