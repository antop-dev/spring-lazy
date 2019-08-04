package org.antop.spring.lazy;

import org.antop.spring.lazy.bean.First;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyApplicationTests {

    @Test
    public void lazy() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LazyApplication.class);
        System.out.println("Spring context loaded");
        System.out.println("call first.go()");

        First first = context.getBean(First.class);
        first.go();
    }

    @Test
    public void concurrency() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(LazyApplication.class);
        System.out.println("Spring context loaded");

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " call first.go()");
                First first = context.getBean(First.class);
                first.go();
            });

            thread.start();
            System.out.println(thread.getName() + " started.");
            Thread.sleep(100);
        }

        // 결과를 보기 위해 5초 대기
        Thread.sleep(5000);
    }

}
