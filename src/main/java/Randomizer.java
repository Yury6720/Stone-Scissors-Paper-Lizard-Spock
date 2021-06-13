import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;

import static javax.xml.crypto.dsig.SignatureMethod.HMAC_SHA256;

public class Randomizer {
    SecureRandom secureRandom;

    public Randomizer() {
        secureRandom = new SecureRandom();
    }

    public String GenerateSecureKey() {
        byte[] values = new byte[16];
        secureRandom.nextBytes(values);
        StringBuilder sb = new StringBuilder();
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String CalculateHMAC(String data, String key) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HMAC_SHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            return ToHexString(mac.doFinal(data.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {

            return "";
        }
    }
    public String ToHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    //    SecureRandom secureRandom = new SecureRandom();
//    int ir = secureRandom.nextInt();
//    SecureRandom secureRandom = SecureRandom.getInstance("HmacSHA256");
//
//    public Randimizer() throws NoSuchAlgorithmException {
//    }
//int ir = secureRandom.nextInt()
//    public void setSecureRandom(SecureRandom secureRandom) {
//        byte[] bytes = secureRandom.generateSeed(16);
//    }
}
