package com.api.gateway.service;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class ApiGatewayRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        restConfiguration().bindingMode(RestBindingMode.json);
        // Create Request
        rest("/say").get("/hello").to("direct:hello");
        rest().get("/bye").produces(MediaType.APPLICATION_JSON).to("direct:bye");
        // Create Response
        from("direct:hello").transform().constant("Hello World");
        from("direct:bye").transform().constant("Bye World");

        rest("/customers/").get("/{id}").to("direct:customerDetail");
        from("direct:customerDetail").transform().simple("Hello");


    }


}