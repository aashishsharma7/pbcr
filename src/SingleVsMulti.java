import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class SingleVsMulti {
    public static void main(String args[]){
        /*Blockchain blockchain = new Blockchain(false);
        Random objGenerator = new Random();
        for(int i = 0; i < 100000; i++) {
            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            for (int j = 0; j < 10; j++) {
                int ran = objGenerator.nextInt(100000000);
                Identiy buyer = new Identiy(ran + "", ran + "");
                Identiy seller = new Identiy(ran + "", ran + "");
                LandDescription landDescription = new LandDescription(ran, ran, ran + "");
                Transaction transaction = new Transaction(seller, buyer, landDescription, ran);
                transactions.add(transaction);
            }
            blockchain.addBlock(transactions);
        }
            FileOutputStream f = null;
            try {
                f = new FileOutputStream(new File("blockchainSingleThreading"));
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(blockchain);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        Blockchain blockchain = new Blockchain(true);
        try {
            FileInputStream fi = new FileInputStream(new File("blockchainMultiThreading"));
            ObjectInputStream oi = new ObjectInputStream(fi);
            blockchain = (Blockchain) oi.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //System.out.println(blockchain.getBlockchain().get(8000).getTransactions().get(3).getBuyerId().getPanDetails());
        System.out.println("Blockchain read into memory");
        int count = 0;
        long startTime = System.nanoTime();
        for(int i=0;i<100;i++)
            count = blockchain.panCount("11588981");
        long stopTime = System.nanoTime();
        System.out.println("Pan count is " + count);
        System.out.println("Exection time of query is "+(stopTime-startTime));
    }
}
/*
 Multithreading 3551309694 4786985739 3528476699 3453930826
 Singlethreading 4961137704 5098365120 5108707928 5057620632
 */