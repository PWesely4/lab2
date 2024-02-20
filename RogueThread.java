public class RogueThread implements Runnable{
    public static String threadName;
    public void run() {
        Util Util = new Util();
        while(true) {
            Util.sleepRandomTime(threadName);
            String newWord = MerkleManager.grabWord();
            if (newWord != null) {
                //MerkleManager.strikes++;
                System.out.println("Word grabbed- STRIKE" + MerkleManager.strikes);

            }

        }
    }

}
