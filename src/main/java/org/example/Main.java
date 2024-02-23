package org.example;


import org.example.beans.City;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (var context = new ClassPathXmlApplicationContext("settings.xml")) {
            City city = context.getBean(City.class);
            System.out.println(city);
        }
    }
}