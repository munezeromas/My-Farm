package org.example;


public class Animal extends FarmItem {

    public Animal(String name) {
        super(name);
    }

    @Override
    public void maintain() {
        System.out.println("Maintaining animal: " + name);
    }

    @Override
    public String getType() {
        return "Animal";
    }
}

