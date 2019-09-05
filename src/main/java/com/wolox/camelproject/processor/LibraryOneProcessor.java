package com.wolox.camelproject.processor;

import com.wolox.camelproject.beans.LibraryOne;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LibraryOneProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        LibraryOne one = exchange.getIn().getBody(LibraryOne.class);
        System.out.println("ahhhhh "+one.getPrice());
        // exchange.getOut().setBody(body.)
        exchange.getOut().setBody(one.getPrice());
    }
}
