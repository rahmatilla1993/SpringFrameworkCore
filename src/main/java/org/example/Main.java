package org.example;


import org.example.beans.Store;
import org.example.beans.Student;
import org.example.config.AutoConfig;
import org.example.config.JavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        xmlConfig();
//        javaConfig();
//        autoConfig();
        var context = new ClassPathXmlApplicationContext("xml-config.xml");
        Student student = context.getBean(Student.class);
        System.out.println(student);
    }

    private static void autoConfig() {
        try (var context = new AnnotationConfigApplicationContext(AutoConfig.class)) {
            Store store = context.getBean(Store.class);
            System.out.println(store);
        }
    }

    private static void javaConfig() {
        try (var context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
            Store store = context.getBean(Store.class);
            System.out.println(store);
        }
    }

    private static void xmlConfig() {
        try (var context = new ClassPathXmlApplicationContext("xml-config.xml")) {
            Store store = context.getBean(Store.class);
            System.out.println(store);
        }
    }
}