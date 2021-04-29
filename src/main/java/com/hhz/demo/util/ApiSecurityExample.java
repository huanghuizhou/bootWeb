package com.hhz.demo.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.util.Optional;

public class ApiSecurityExample {

    public static String getTokenSign(String clientId, Long l, String token, String secret) {
        try {
            String message = clientId + Optional.ofNullable(token).orElse("") + l;
            System.out.println(message);
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            String hash = new HexBinaryAdapter().marshal(bytes).toUpperCase();
            System.out.println(hash);
            return hash;
        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }
}
