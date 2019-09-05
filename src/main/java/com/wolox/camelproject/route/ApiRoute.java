package com.wolox.camelproject.route;
import com.wolox.camelproject.beans.LibraryOne;
import com.wolox.camelproject.beans.SecondLibrary;
import com.wolox.camelproject.processor.LibraryOneProcessor;
import com.wolox.camelproject.processor.SecondLibraryProcessor;
import com.wolox.camelproject.strategy.LowestPriceAggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ApiRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //restConfiguration().component("").port(9091).bindingMode(RestBindingMode.json);


        //scatter-gather static netty-http

        /*from("netty-http:http://0.0.0.0:9091/books")
                .multicast()
                .to("seda:libraryone");


        from("seda:libraryone")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("netty-http:http://localhost:8081/api/books/9780590353427")
                .streamCaching()
                .unmarshal().json(JsonLibrary.Jackson, LibraryOneProcessor.class)
                .process(new LibraryOneProcessor());
                //.to("seda:quoteAggregator");*/



        //scatter gather jetty

        from("jetty://http://0.0.0.0:9091/books")
                .removeHeaders("CamelHttp*")
                .multicast()
                .to("seda:libraryOne","seda:secondLibrary");

        from("seda:libraryOne")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("jetty://https://library-one.herokuapp.com/api/books/isbn/9780545010221")
                .streamCaching()
                .unmarshal().json(JsonLibrary.Jackson, LibraryOne.class)
                .process(new LibraryOneProcessor())
                .to("seda:priceAggregator");

        from("seda:secondLibrary")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("jetty://https://library-second.herokuapp.com/api/books/9780545010221")
                .streamCaching()
                .unmarshal().json(JsonLibrary.Jackson, SecondLibrary.class)
                .process(new SecondLibraryProcessor())
                .to("seda:priceAggregator");

        /*from("seda:priceAggregator")
                .aggregate(header("id"),
                        new LowestPriceAggregationStrategy())
                        .ignoreInvalidCorrelationKeys()
                        .completionSize(10).id("myAggregator")
                        .to("mock:result");*/

        from("seda:priceAggregator")
                .aggregate(constant(true),
                        new LowestPriceAggregationStrategy())
                //.parallelProcessing()
                .completionSize(10).id("myAggregator")
                .to("mock:result");


        //funca

        /*from("netty-http:http://0.0.0.0:9091/hola").to("direct:hello");

        from("netty-http:http://0.0.0.0:9091/books").to("direct:libraryone");


        from("direct:libraryone")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("netty-http:http://localhost:8081/api/books/9780590353427")
                .process(new ApiProcessor());

        from("direct:hello")
                .transform().constant("Hello world");

         */


        /*restConfiguration().component("restlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

        rest().get("/hello")
                .produces("application/json")
                .route().setBody(constant("hola"));*/

        /*//Endpoints
        rest("/api/books")
                .get("/recommendations")
                .to("direct:libraryone");


        from("direct:libraryone").setHeader(Exchange.HTTP_METHOD, simple("GET"))
                //.to("http://localhost:8081/api/books/9780590353427")
                .process(new ApiProcessor())
                .end();

        from("direct:hello")
                .transform().constant("Hello world");

        from("direct:libraryone")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8081/api/books/9780590353427")
                .process(new ApiProcessor());*/

        /*rest("/api")
                .consumes("application/json")
                .produces("application/json")
                .get("/books")
                .to("direct:hello");

        from("direct:hello")
                .transform().constant("Hello world");

        from("seda:libraryone").setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8081/api/books/9780590353427").process(new ApiProcessor());*/

        /*from("direct:start").multicast().to("seda:library1","seda:library2",
                                            "seda:library3");
        from("seda:library1").to("bean:library1").to("seda:quoteAggregator");
        from("seda:library2").to("bean:library2").to("seda:quoteAggregator");

        from("seda:quoteAggregator").aggregate(header("quoteRequestId"),
                new LowestQuoteAggregationStrategy()).to("mock:result");*/




        /*rest("/api")
                .consumes("application/json")
                .produces("application/json")
                .get("/books")
                .to("direct:libraryone");

        from("direct:libraryone")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8081/api/books/9780590353427")
                .process(new ApiProcessor()).end();*/


        //ActiveMQ exercise
        /*from("activemq:Origin")
                .choice()
                .when()
                    .simple("${in.header.Type} == 'Type 1'")
                    .to("activemq:one")
                .when()
                    .simple("${in.header.Type} == 'Type 2'")
                    .to("activemq:two")
                .when()
                    .simple("${in.header.Type} == 'Type 3'")
                    .to("activemq:three")
                .otherwise()
                    .to("activemq:other");*/
    }

}
