package com.company;

import java.util.List;
import java.util.Random;

public class Producer extends Thread {

    private static int nextProducerID = 1;

    private final int producerID;
    private final String[] products;
    private final Random random;

    public Producer(String[] products){
        this.producerID = nextProducerID;
        this.products = products;
        this.random = new Random();

        nextProducerID++;
    }

    @Override
    public void run() {
        super.run();
        while(!isInterrupted()){
            synchronized (Shop.synchroKey){
                List<String> products = Main.getShop().getProducts();

                if(products.size() < 5){
                    String product = this.products[random.nextInt(this.products.length)];
                    products.add(product);
                    System.out.println("Producer " + producerID + " added " + product + " to the shop!");

                }
            }
            
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public String[] getProducts() {
        return products;
    }
}
