package org.example;

public abstract class FarmItem {
    protected String name;

    public FarmItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void maintain();

    public abstract String getType();
}

