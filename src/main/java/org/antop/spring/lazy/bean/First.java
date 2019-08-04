package org.antop.spring.lazy.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class First {
    private final Second second;

    public First(Second second) {
        this.second = second;
        // 인스턴스를 생성하는데 3초가 걸린다.
        System.out.println("It takes 3 seconds to create an instance");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println((3 - i) + "..");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("first class constructor");
    }

    public void go() {
        System.out.println(Thread.currentThread().getName() + " Hello first!");
        second.go();
    }
}
