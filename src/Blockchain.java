import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Blockchain implements Serializable {

    private BlockchainQuery blockchainQuery;
    private ArrayList<Block> blockchain;

    public Blockchain(boolean multiThreading){
        if(multiThreading)
            blockchainQuery = new MultiThreadedQuery(100);
        else
            blockchainQuery = new SingleThreadedQuery();

        String timestamp = (new Date()).toString();
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(new Identiy("0","0"),new Identiy("0","0"),
        new LandDescription(0,0,"0"), 0));
        Block genesis = new Block(0, timestamp, transactions, null,null);
        blockchain = new ArrayList<Block>();
        blockchain.add(genesis);
    }

    public void addBlock(ArrayList<Transaction> transactions){
        String timestamp = (new Date()).toString();
        Block t = new Block( blockchain.size(), timestamp, transactions, null, null);
        blockchain.add(t);
    }

    public int panCount(String panDetails){
        return blockchainQuery.panCount(blockchain, panDetails);
    }

    public ArrayList<Block> getBlockchain() {
        return blockchain;
    }
}
