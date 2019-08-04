package org.antop.spring.lazy.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Third {

    public Third() {
        System.out.println("third class constructor");
    }

    public void go() {
        System.out.println(Thread.currentThread().getName() + " Hello third!");
    }

}