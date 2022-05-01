package com.company;

import java.util.List;
import java.util.Random;

public class ProductConsumer extends Thread {

    private static int nextConsumerID = 1;

    private final int consumerID;
    private final Random random;

    public ProductConsumer(){
        this.consumerID = nextConsumerID;
        this.random = new Random();

        nextConsumerID++;
    }

    @Override
    public void run() {
        super.run();
        while(!isInterrupted()){
            synchronized (Shop.synchroKey){
                List<String> products = Main.getShop().getProducts();
                if(products.size() > 0){
                    String product = products.remove(random.nextInt(products.size()));
                    System.out.println("Consumer with ID " + consumerID + " just bought " + product + " from the shop!");
                }
                else{
                    System.out.println("Consumer with ID" + consumerID + " tried to buy something but shelves are empty!");
                }
            }

            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
