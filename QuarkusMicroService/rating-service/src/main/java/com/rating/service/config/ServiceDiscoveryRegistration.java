package com.rating.service.config;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.consul.ConsulClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;


@ApplicationScoped
public class ServiceDiscoveryRegistration {
    @ConfigProperty(name = "consul.host", defaultValue = "localhost")
    private String host;
    @ConfigProperty(name = "consul.port", defaultValue = "8500")
    private int port;

    @ConfigProperty(name = "quarkus.http.port", defaultValue = "6666")
    private int servicePort;

    @ConfigProperty(name = "quarkus.http.host", defaultValue = "localhost")
    private String serviceHost;

    @ConfigProperty(name = "quarkus.application.name", defaultValue = "rating-service")
    private String serviceName;

    private  ConsulClient consulClient;

    public void onStart(@Observes StartupEvent ev, Vertx vertx) {
        consulClient = ConsulClient.create(vertx, new ConsulClientOptions().setHost(host).setPort(port));
        consulClient.registerServiceAndAwait(new ServiceOptions().setPort(servicePort).setAddress(serviceHost).setName(serviceName).setId(serviceName+":"+servicePort));
    }

    public void onStop(@Observes ShutdownEvent event) {
        consulClient.deregisterServiceAndAwait(serviceName + ":" + servicePort);
    }
}