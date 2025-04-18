package org.example;


public class Crop extends FarmItem {

    public Crop(String name) {
        super(name);
    }

    @Override
    public void maintain() {
        System.out.println("Maintaining crop: " + name);
    }

    @Override
    public String getType() {
        return "Crop";
    }
}

