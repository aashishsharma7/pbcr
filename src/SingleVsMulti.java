import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SingleVsMulti {
    public static void main(String args[]) {
        //Blockchain blockchain = new Blockchain(false);
        /*Block t = new Block(0,null,null,null,null);
        Random objGenerator = new Random();
        for(int i = 0; i < 50000; i++) {
            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            for (int j = 0; j < 200; j++) {
                int ran = objGenerator.nextInt(100000000);
                Identiy buyer = new Identiy(ran + "", ran + "");
                Identiy seller = new Identiy(ran + "", ran + "");
                LandDescription landDescription = new LandDescription(ran, ran, ran + "");
                Transaction transaction = new Transaction(seller, buyer, landDescription, ran);
                transactions.add(transaction);
            }
            String timestamp = (new Date()).toString();
            t = new Block(0, timestamp, transactions, null, null);
            //blockchain.addBlock(transactions);

            FileOutputStream f = null;
            try {
                f = new FileOutputStream(new File("blockChain/block"+i));
                ObjectOutputStream o = new ObjectOutputStream(f);
                o.writeObject(t);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

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
        System.out.println("Exection time of query is "+(stopTime-startTime));*/
        BlockChainReader blockChainReader = new SimpleBlockChainReader(7000);
        BlockchainQuery blockchainQuery = new MultiThreadedQuery(100, 10000);
        int count = blockchainQuery.panCount(blockChainReader, "97324985");
        System.out.println(count);
    }
}
/*
 Multithreading 3551309694 4786985739 3528476699 3453930826
 Singlethreading 4961137704 5098365120 5108707928 5057620632
 speed up 1.32
 */