import java.util.ArrayList;
import javax.swing.JOptionPane;
public class MerkleManager {
    public static volatile String userWord;
    public static int wordCount = 0;
    public static String userMerkleRoot;
    public static String nullMerkleRoot;
    public static int strikes = 0;

    public void manage() {
        Util Util = new Util();
        userMerkleRoot = Util.promptUser("Enter the merkle root");
        System.out.println(userMerkleRoot);

        //1. Create instance of target class
        MerkleThread Merkle = new MerkleThread();
        Merkle.threadName = ("MerkleThread");

        RogueThread Rogue = new RogueThread();
        RogueThread.threadName = ("RogueThread");

        MonitorThread Monitor = new MonitorThread();
        MonitorThread.threadName = ("MonitorThread");

        // 2. instantiate thread class and pass object

        Thread merkleThread = new Thread(Merkle);
        Thread rogueThread = new Thread(Rogue);
        Thread monitorThread = new Thread(Monitor);

        // 3.

        merkleThread.start();
        rogueThread.start();
        monitorThread.start();

        while(wordCount < 4) {
            userWord = Util.promptUser("Enter a word: ");

        }

    }
    public static synchronized String grabWord() {
        String temp = userWord;
        userWord = null;
        return temp;
    }


}
