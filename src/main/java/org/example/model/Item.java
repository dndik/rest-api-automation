package org.example.model;

import java.util.Map;

public class Item {

    private String name;
    private Map<String, String> data;

    public Item(String name, Map<String, String> data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
