package com.satish.exp.reactive;

public class Demo {
    public static void main(String[] args) {
        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(10);
        subscriber.getSubscription().request(10);

    }
}
