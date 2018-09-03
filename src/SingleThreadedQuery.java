import java.io.Serializable;
import java.util.ArrayList;

public class SingleThreadedQuery implements  BlockchainQuery, Serializable {

    public int panCount(ArrayList<Block> blockchain, String panDetails){
        int count = 0;
        for(int i = 1; i < blockchain.size(); i++){
            ArrayList<Transaction> transactions = blockchain.get(i).getTransactions();
            for(int j = 0; j < transactions.size(); j++){
                if(transactions.get(j).getBuyerId().getPanDetails().equals(panDetails)
                    || transactions.get(j).getSellerId().getPanDetails().equals(panDetails))
                    count++;
            }
        }
        return count;
    }

}
