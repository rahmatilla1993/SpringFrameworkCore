package org.example;


import org.example.beans.City;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        xml();
//        javaConfig();
    }

    private static void javaConfig() {
        try (var context = new AnnotationConfigApplicationContext("org.example.beans")) {
            City city = context.getBean(City.class);
            City city2 = context.getBean(City.class);
            System.out.println(System.identityHashCode(city));
            System.out.println(System.identityHashCode(city2));
        }
    }

    private static void xml() {
        try (var context = new ClassPathXmlApplicationContext("settings.xml")) {
            City city = context.getBean(City.class);
            City city2 = context.getBean(City.class);
            System.out.println(System.identityHashCode(city));
            System.out.println(System.identityHashCode(city2));
        }
    }
}