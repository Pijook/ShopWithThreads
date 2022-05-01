package com.company;

public class Main {

    private static Shop shop;

    public static void main(String[] args) {

        shop = new Shop();

        new Producer(new String[]{"Apple", "Orange", "Kiwi"}).start();
        new Producer(new String[]{"Banana", "Volvo", "Air"}).start();
        new Producer(new String[]{"PC", "Mouse", "Table"}).start();
        new Producer(new String[]{"Bottle", "Plant", "Tree"}).start();
        new Producer(new String[]{"Coal", "Iron", "Diamond"}).start();

        for(int i = 0; i < 10; i++){
            new ProductConsumer().start();
        }

    }

    public static Shop getShop() {
        return shop;
    }
}
