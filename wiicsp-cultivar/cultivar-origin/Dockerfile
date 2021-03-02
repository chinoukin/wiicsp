FROM 192.168.20.17:5000/wbf-cloud/wbf-cloud-service-dpds-lib:v0.0.4

COPY --from=192.168.20.17:5000/wbf-cloud/wbf-cloud-quartz-lib:v0.0.4 /env/wisea-cloud-lib/* /env/wisea-cloud-lib/

ARG SVC="cultivar-origin" 
ARG CONF="dktest"
ENV ENV_SERVICE=${SVC} ENV_CONF=${CONF}

# Add the service itself
COPY ./target/${ENV_SERVICE}-0.0.1-SNAPSHOT.jar /usr/local/wiseapp/${ENV_SERVICE}-latest.jar
COPY ./target/lib/* /env/wisea-cloud-lib/
COPY ./target/config/* /usr/local/wiseapp/config/
COPY ./target/config-env/bootstrap-${CONF}.yml /usr/local/wiseapp/config/bootstrap-${CONF}.yml
COPY ./target/config-env/application-${CONF}.yml /usr/local/wiseapp/config/application-${CONF}.yml
ENTRYPOINT startbootapp -a ${ENV_SERVICE} -v latest -p ${ENV_CONF}