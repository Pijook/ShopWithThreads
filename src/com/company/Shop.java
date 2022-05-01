package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    public final static String synchroKey = "test";

    private final List<String> products;

    public Shop(){
        products = new ArrayList<>();
    }

    public List<String> getProducts() {
        return products;
    }
}
