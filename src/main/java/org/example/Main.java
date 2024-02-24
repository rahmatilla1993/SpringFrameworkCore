package org.example;


import org.example.beans.Transform;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        xml();
//        auto();
    }

    private static void auto() {
        try (var context = new AnnotationConfigApplicationContext("org.example.beans")) {
            Transform transform = context.getBean(Transform.class);
            transform.start();
        }
    }

    private static void xml() {
        try (var context = new ClassPathXmlApplicationContext("ioc-settings.xml")) {
            Transform transform = context.getBean(Transform.class);
            transform.start();
        }
    }
}