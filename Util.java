import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Util {
    public String getMerkle_Root(ArrayList<String> lstItems) {

        MerkleNode Node1 = new MerkleNode();
        MerkleNode Node2 = new MerkleNode();
        MerkleNode Node3 = new MerkleNode();
        MerkleNode Node4 = new MerkleNode();
        MerkleNode Node5 = new MerkleNode();
        MerkleNode Node6 = new MerkleNode();
        MerkleNode Node7 = new MerkleNode();

        Node1.hash = generateHash(lstItems.get(0));
        Node2.hash = generateHash(lstItems.get(1));
        Node3.hash = generateHash(lstItems.get(2));
        Node4.hash = generateHash(lstItems.get(3));

        populateMerkleNode(Node5, Node1, Node2);
        populateMerkleNode(Node6, Node3, Node4);
        populateMerkleNode(Node7, Node5, Node6);

        return Node7.hash;
    }

    private void populateMerkleNode(MerkleNode Node, MerkleNode leftNode, MerkleNode rightNode) {
        Node.left = leftNode;
        Node.right = rightNode;
        Node.hash = generateHash(Node.left.hash + Node.right.hash);

    }

    public synchronized String generateHash(String sOriginal){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100,
                        16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){
            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    public String promptUser(String question) {
        return JOptionPane.showInputDialog(question);
    }

    public void sleepRandomTime(String threadName){
// Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;
        System.out.println(threadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }

    public void sleep(int Seconds) {
        try{
            Thread.sleep(Seconds*1000);
        }
        catch(Exception ex){

        }
    }

}
