package com.wolox.camelproject.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ApiProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody(String.class));
        String body = exchange.getIn().getBody(String.class);
        exchange.getOut().setBody("hello "+body);
        exchange.getOut().setHeaders(exchange.getIn().getHeaders());
    }
}
