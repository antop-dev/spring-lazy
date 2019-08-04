package org.antop.spring.lazy.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Second {
    private final Third third;

    public Second(Third third) {
        this.third = third;
        System.out.println("second class constructor");
    }

    public void go() {
        System.out.println(Thread.currentThread().getName() + " Hello second");
        third.go();
    }

}
