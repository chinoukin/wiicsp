FROM scratch as builder
WORKDIR /workspace/app
ARG CONF="dktest"

ADD ./target/lib/* ./wisea-cloud-lib/
ADD ./target/config/* ./config/
ADD ./target/config-env/bootstrap-${CONF}.yml ./config/bootstrap-${CONF}.yml
ADD ./target/config-env/application-${CONF}.yml ./config/application-${CONF}.yml


FROM 192.168.20.17:5000/wbf-cloud/wbf-cloud-service-dpds-lib:v0.0.4

COPY --from=192.168.20.17:5000/wbf-cloud/wbf-cloud-files-lib:v0.0.4 /env/wisea-cloud-lib/* /env/wisea-cloud-lib/
COPY --from=192.168.20.17:5000/wbf-cloud/wbf-cloud-security-lib:v0.0.4 /env/wisea-cloud-lib/* /env/wisea-cloud-lib/
COPY --from=192.168.20.17:5000/wbf-cloud/wbf-cloud-system-lib:v0.0.4 /env/wisea-cloud-lib/* /env/wisea-cloud-lib/
COPY --from=192.168.20.17:5000/wbf-cloud/wbf-cloud-tencentim-lib:v0.0.4 /env/wisea-cloud-lib/* /env/wisea-cloud-lib/
COPY --from=192.168.20.17:5000/wbf-cloud/wbf-cloud-quartz-lib:v0.0.4 /env/wisea-cloud-lib/* /env/wisea-cloud-lib/

ARG SVC="cultivar-operation" 
ARG CONF="dktest"
ENV ENV_SERVICE=${SVC} ENV_CONF=${CONF}

# Add the service itself
COPY ./target/${ENV_SERVICE}-0.0.1-SNAPSHOT.jar /usr/local/wiseapp/${ENV_SERVICE}-latest.jar

COPY --from=builder /workspace/app/wisea-cloud-lib/* /env/wisea-cloud-lib/
COPY --from=builder /workspace/app/config/* /usr/local/wiseapp/config/

ENTRYPOINT startbootapp -a ${ENV_SERVICE} -v latest -p ${ENV_CONF}