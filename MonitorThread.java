public class MonitorThread implements Runnable{
    public static String threadName;
    public void run() {
        Util Util = new Util();
        System.out.println("Hi there");
        while(true) {
            if (MerkleManager.nullMerkleRoot != null) {
                System.out.println("HELPME");
                if (MerkleManager.nullMerkleRoot.equals(MerkleManager.userMerkleRoot)) {
                    System.out.println("You Win: " + MerkleManager.userMerkleRoot);
                    System.exit(0);
                }

                else if (MerkleManager.strikes == 3) {
                    System.out.println("3 strikes: You Lost");
                }
                else {
                    System.out.println("You Lost");
                    System.exit(0);
                }
                Util.sleep(1);
            }

        }
    }
}
