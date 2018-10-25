import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import io.ipfs.api.IPFS;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

public class SingleVsMulti {
    public static void main(String args[]) {
        /*for (int x = 1; x < 9; x++)
            for(int y = 1; y < 26; y++) {
                BlockChainReader blockChainReader = new SimpleBlockChainReader(3000);
                BlockchainQuery blockchainQuery = new MultiThreadedQuery(x, y*1600);
                long startTime = System.nanoTime();
                int count = blockchainQuery.panCount(blockChainReader, "97324985");
                long endTime = System.nanoTime();
                System.out.println(x + " " + y*8 + " " + (endTime - startTime));
            }
*/
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        BlockChainReader blockChainReader = new IPFSBlockChainReader(
                "1220709C6315EBD94498A296403216223EB6B4DC8B14A2BA998CB5B6906DFA494B9A", ipfs);
        BlockchainQuery blockchainQuery = new MultiThreadedQuery(2, 100);
        long startTime = System.nanoTime();
        int count = blockchainQuery.panCount(blockChainReader, "97324985");
        long endTime = System.nanoTime();
        System.out.println("Time taken is " + (endTime - startTime));
        System.out.println("Total Pan Count is " + count);
        /*Gson gson = new Gson();
        Block gen = new Block(0,(new Date()).toString(),null,null,null);
        String blockInJson = gson.toJson(gen);
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper(blockInJson.getBytes());
        MerkleNode a = null;
        try {
            a = ipfs.add(file).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String prevHash = a.hash.toHex();*/
        /*System.out.println("previous hash is " + prevHash);

        byte[] arr = new byte[0];
        try {
            arr = ipfs.cat( Multihash.fromHex(prevHash));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String g = null;
        try {
            g = new String(arr,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println(g);
*/
        /*Random objGenerator = new Random();
        for(int i = 0; i < 1500; i++) {
            ArrayList<Transaction> transactions = new ArrayList<>();
            for (int j = 0; j < 200; j++) {
                int ran = objGenerator.nextInt(100000000);
                Identiy buyer = new Identiy(ran + "", ran + "");
                Identiy seller = new Identiy(ran + "", ran + "");
                LandDescription landDescription = new LandDescription(ran, ran, ran + "");
                Transaction transaction = new Transaction(seller, buyer, landDescription, ran);
                transactions.add(transaction);
            }
            String timestamp = (new Date()).toString();
            Block t = new Block(0, timestamp, transactions, null, prevHash);
            blockInJson = gson.toJson(t);
            file = new NamedStreamable.ByteArrayWrapper(blockInJson.getBytes());
            MerkleNode merkleNode = null;
            try {
                merkleNode = ipfs.add(file).get(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            prevHash = merkleNode.hash.toHex();
        }
        System.out.println("The hash of the leading blockchain is " + prevHash);*/
    }
}
//Leading Block Hash = 1220709C6315EBD94498A296403216223EB6B4DC8B14A2BA998CB5B6906DFA494B9A;
/*
 Multithreading 3551309694 4786985739 3528476699 3453930826
 Singlethreading 4961137704 5098365120 5108707928 5057620632
 speed up 1.32
 */