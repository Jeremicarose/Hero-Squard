package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private LocalDateTime createdAt;

    public  Hero(String name, int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return this.name;
    }

    public String getPower() {
        return this.power;
    }

    public String getWeakness() {
        return this.weakness;
    }

    public int getAge() {
        return this.age;
    }

    public static ArrayList<Hero> getInstances() {
        return instances;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public static void clearAllHeroes() {
        instances.clear();
    }
    public  static Hero findBy(int id) {
        return instances.get(id-1);
    }
    public void deleteHero(){
        instances.remove(id-1);
    }
    public static Hero setUpNewHero2(){
        return new Hero("Jay",30,"Night Vision","Light");
    }
}

