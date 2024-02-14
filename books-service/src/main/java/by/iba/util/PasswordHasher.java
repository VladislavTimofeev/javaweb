package by.iba.util;

import by.iba.exception.PasswordHasherException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordHasher {
    public String getHashedPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(
                    password.getBytes(StandardCharsets.UTF_8)
            );
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new PasswordHasherException("No such algorithm hashing password");
        }
    }

    public boolean isPasswordMatched(String inputPassword, String storedPassword) {
        return getHashedPassword(inputPassword).equals(storedPassword);
    }

    public String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
