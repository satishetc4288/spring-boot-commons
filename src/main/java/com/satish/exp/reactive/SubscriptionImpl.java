package com.satish.exp.reactive;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriptionImpl implements Subscription {

    private final  Subscriber<? super String> subscriber;
    private boolean isCancelled;
    private final int MAX_COUNT = 10;

    public SubscriptionImpl(Subscriber<? super String> subscriber) {
        this.subscriber=subscriber;
    }

    private static final Logger log = LoggerFactory.getLogger(SubscriptionImpl.class);

    @Override
    public void request(long requested) {
        if(isCancelled){
            log.info("already cancelled");
            return;
        }
        log.info("subscriber has requested {} items", requested);
        for(int i=0; i<requested && i<MAX_COUNT; i++){
            this.subscriber.onNext("this is satish: " + i);
        }
        subscriber.onComplete();
        isCancelled=true;
    }

    @Override
    public void cancel() {
        log.info("subscriber has cancelled");
        this.isCancelled=true;
    }
}
