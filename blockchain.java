import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

class Block {
    private String previousHash;
    private String pseudonym;
    private int difficulty;
    private String hash;
    private long nonce;

    public Block(String previousHash, String pseudonym, int difficulty) {
        this.previousHash = previousHash;
        this.pseudonym = pseudonym;
        this.difficulty = difficulty;
        this.hash = null;
        this.nonce = 0;
    }

    public void generateMine() {
        String prefix = "0".repeat(difficulty);
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            Random rand = new Random();
            while (true) {
                this.nonce = rand.nextLong();
                String blockHeader = this.previousHash + this.pseudonym + this.nonce;
                byte[] blockHeaderBytes = blockHeader.getBytes();
                byte[] hashBytes = digest.digest(blockHeaderBytes);
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1)
                        hexString.append('0');
                    hexString.append(hex);
                }
                this.hash = hexString.toString();
                if (this.hash.startsWith(prefix)) {
                    break;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return String.format("Block: - Previous Hash: %s, Miner: %s, Nonce: %d, Difficulty: %d, Hash: %s",
                this.previousHash, this.pseudonym, this.nonce, this.difficulty, this.hash);
    }

    public String getDifficulty() {
        return "0".repeat(this.difficulty);
    }

    public static void main(String[] args) {
        String previousHash = "000000000a1049209e53f14b7acbbb580273372946c4058647dd6311fa4c81e5";
        String miner = "maquina";
        int currentDifficulty = 1;

        while (currentDifficulty <= 40) {
            Block block = new Block(previousHash, miner, currentDifficulty);
            block.generateMine();
            System.out.println(block);
            currentDifficulty++;
        }
    }
}
