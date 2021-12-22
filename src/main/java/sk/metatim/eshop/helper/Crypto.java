package sk.metatim.eshop.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.controller.OrderController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class Crypto {

    private static final Logger logger = LogManager.getLogger(Crypto.class);

    @Value("crypto.salt")
    private String SALT;

    public String hash(String password){

        String pwd = null;

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(SALT.getBytes(StandardCharsets.UTF_8));

            byte[] bytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            pwd = sb.toString();

        }catch(NoSuchAlgorithmException e){
            logger.error("Unable to hash password: " + e.getMessage());
            e.printStackTrace();
        }

        return pwd;
    }
}
