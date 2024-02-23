package org.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@PropertySource("classpath:city.properties")
public class City {

    @Value("${city.name}")
    private String name;

    @Value("${city.number_of_people}")
    private int numberOfPeople;

    @Value("${city.size}")
    private long size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", size=" + size +
                '}';
    }
}
