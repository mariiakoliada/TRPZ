package ia32.koliada.finance.soa.server;

import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.UUID;

@Service
public class SecurityService {
    private static final String KEY = "LabWorkSecretKey";

    public String generateToken(String user) {
        return "TOKEN-" + UUID.randomUUID();
    }

    public String encrypt(String data) {
        try {
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    public String decrypt(String data) {
        try {
            SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) { return data; }
    }
}