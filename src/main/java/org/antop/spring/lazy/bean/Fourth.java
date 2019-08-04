package org.antop.spring.lazy.bean;

import org.springframework.stereotype.Component;

@Component
public class Fourth {
    private final Second second;

    public Fourth(Second second) {
        this.second = second;
        System.out.println("fourth class constructor");
    }

    public void go() {
        System.out.println(Thread.currentThread().getName() + " Hello fourth!");
        second.go();
    }

}
