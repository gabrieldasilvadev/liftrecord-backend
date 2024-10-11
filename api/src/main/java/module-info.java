module br.com.liftrecord.api {
    exports br.com.liftrecord.api;

    requires br.com.liftrecord.domain;
    requires io.micronaut.context;
    requires jakarta.annotation;
    requires io.micronaut.core;
    requires io.micronaut.http;
    requires jakarta.validation;
    requires io.micronaut.http_client_core;
    requires com.fasterxml.jackson.annotation;
    requires io.micronaut.serde.micronaut_serde_api;
    requires jakarta.inject;
    requires io.micronaut.inject;
}