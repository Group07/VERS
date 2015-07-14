package com.avers.Utils.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Amila on 7/10/2015.
 */
public class PasswordEncoderGenerator {

    public static String bCrypt(String password, int iterations){
        int i = 0;
        String hashedPassword = "";
        while (i<iterations){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            hashedPassword = passwordEncoder.encode(password);
            i++;
        }
        return hashedPassword;
    }
}
