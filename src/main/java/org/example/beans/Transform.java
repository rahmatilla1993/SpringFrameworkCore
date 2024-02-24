package org.example.beans;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Transform {

    public void start() {
        if (new Random().nextBoolean()) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        } else {
            throw new RuntimeException("Runtime exception occurred!");
        }
    }
}
