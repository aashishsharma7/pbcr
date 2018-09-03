import java.io.Serializable;
import java.util.ArrayList;

class PanCountTask implements Runnable {

    private int localCounter = 0;
    private int start;
    private int end;
    private ArrayList<Block> blockchain;
    private String panDetails;

    public PanCountTask(int start, int end, ArrayList<Block> blockchain, String panDetails){
        this.start = start;
        this.end = end;
        this.blockchain = blockchain;
        this.panDetails = panDetails;
    }

    public void run(){
        for(int i = start; i <= end; i++){
            ArrayList<Transaction> transactions = blockchain.get(i).getTransactions();
            for(int j = 0; j < transactions.size(); j++){
                if(transactions.get(j).getBuyerId().getPanDetails().equals(panDetails)
                        || transactions.get(j).getSellerId().getPanDetails().equals(panDetails))
                    localCounter++;
            }
        }
    }

    public int getCounter() {
        return localCounter;
    }
}

public class MultiThreadedQuery implements BlockchainQuery, Serializable {

    private int threadCount;

    public MultiThreadedQuery(int threadCount) {
        this.threadCount = threadCount;
    }

    public int panCount(ArrayList<Block> blockchain, String panDetails) {
        PanCountTask[] panCountTasks = new PanCountTask[threadCount];
        Thread[] threads = new Thread[threadCount];
        int size = blockchain.size() / threadCount;
        int tid = 0, en = -1;
        while (tid < threadCount - 1) {
            panCountTasks[tid] = new PanCountTask(en + 1, en + size, blockchain, panDetails);
            en += size;
            tid++;
        }
        panCountTasks[tid] = new PanCountTask(en + 1, blockchain.size() - 1, blockchain, panDetails);
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(panCountTasks[i]);
            threads[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int count = 0;
        for (int i = 0; i < threadCount; i++) {
            count += panCountTasks[i].getCounter();
        }
        return count;
    }
}
