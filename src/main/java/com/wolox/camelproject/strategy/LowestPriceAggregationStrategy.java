package com.wolox.camelproject.strategy;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class LowestPriceAggregationStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if(oldExchange == null){
            System.out.println("old change es null");
            return newExchange;
        }
        if(oldExchange.getIn().getBody(float.class)<newExchange.getIn().getBody(float.class)){
            System.out.println("old change menor a newchange");
            System.out.println(oldExchange.getIn().getBody(float.class));
            System.out.println("dos");
            System.out.println(newExchange.getIn().getBody(float.class));
            return oldExchange;
        }else{
            System.out.println(oldExchange.getIn().getBody(float.class));
            System.out.println(newExchange.getIn().getBody(float.class));
            System.out.println("new change mayor a oldchange");
            return newExchange;
        }
    }
}
