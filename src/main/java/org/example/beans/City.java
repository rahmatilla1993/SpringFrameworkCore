package org.example.beans;

public class City {
    private String name;
    private int numberOfPeople;
    private long size;

    public City(String name, int numberOfPeople, long size) {
        this.name = name;
        this.numberOfPeople = numberOfPeople;
        this.size = size;
    }

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
