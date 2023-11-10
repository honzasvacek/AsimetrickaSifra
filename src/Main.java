import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator kPG = KeyPairGenerator.getInstance("RSA");
        kPG.initialize(512);
        KeyPair keyPair = kPG.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate(); //privátní key z dvojice klíčů
        PublicKey publicKey = keyPair.getPublic(); //analogicky

        byte[] k = privateKey.getEncoded();
        Path publicKeyF = Paths.get("myKeyPublic.dat");
        Files.write(publicKeyF, k);

        byte[] l = publicKey.getEncoded();
        Path privateKeyF = Paths.get("myKeyPrivate.dat");
        Files.write(privateKeyF, k);
    }
}