import java.lang.reflect.Array;
import java.util.ArrayList;

public class MerkleThread implements Runnable{
    public String threadName;
    public static volatile ArrayList<String> lstWords;

    public void run(){
        System.out.println(threadName + " has started!");
        Util util = new Util();
        lstWords = new ArrayList<>();

        while(true){
            util.sleepRandomTime(threadName);
            String newWord = MerkleManager.grabWord();
            if (newWord != null) {
                System.out.println("Merkle grabbed a word:" + newWord);
                lstWords.add(newWord);
                System.out.println(util.generateHash(newWord));
                System.out.println(lstWords);
                MerkleManager.wordCount++;

                int merkleTreeInputs = 4;
                if (lstWords.size() == merkleTreeInputs) {
                    MerkleManager.nullMerkleRoot = util.getMerkle_Root(lstWords);
                    System.out.println("in if loop: " + util.getMerkle_Root(lstWords));
                }
            }
            System.out.println(threadName + " just woke up.");
        }
    }
}
