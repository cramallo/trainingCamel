package com.wolox.camelproject.processor;

import com.wolox.camelproject.beans.SecondLibrary;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SecondLibraryProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        SecondLibrary second = exchange.getIn().getBody(SecondLibrary.class);
        System.out.println("ahhhhh "+second.getPrice());
        // exchange.getOut().setBody(body.)
        exchange.getOut().setBody(second.getPrice());
    }
}
