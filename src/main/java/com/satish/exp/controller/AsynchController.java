package com.satish.exp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
public class AsynchController {

    private static  final Logger logger = LoggerFactory.getLogger(AsynchController.class);

    @RequestMapping("/test")
    public CompletableFuture<String> getAsynch(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        logger.info("before asynch call");
        Executors.newFixedThreadPool(3).submit( () -> {
             completableFuture.complete("Hello man");
        });
        return completableFuture;
    }

    @RequestMapping("/test2")
    public CompletableFuture<String> getAsynch2(){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync( () -> "hello, ");

        return completableFuture.
                thenApplyAsync((hel) -> hel + " world").
                thenCompose( (res) -> CompletableFuture.supplyAsync(() -> res + "\n Whats up dude!")).
                thenCombine(CompletableFuture.supplyAsync( () -> "\n big boss this is: "), (s1, s2) -> s1+ s2);
    }

    @RequestMapping("/test3")
    public CompletableFuture<String> getAsynch3(){
        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        List<CompletableFuture<String>> completableFutureList = new ArrayList<>();
        completableFutureList.add(future1);
        completableFutureList.add(future2);
        completableFutureList.add(future3);

        /*return CompletableFuture
                .allOf(future1, future2, future3)
                .thenApply( v ->
                    completableFutureList
                        .stream()
                        .map(CompletableFuture::join)
                        .reduce( " ", (s1, s2) -> s1 + " " + s2)
                );*/
        return CompletableFuture.supplyAsync( () -> completableFutureList
                                .stream()
                                .map(CompletableFuture::join)
                                .reduce( " ", (s1, s2) -> s1 + " " + s2));

    }
}
