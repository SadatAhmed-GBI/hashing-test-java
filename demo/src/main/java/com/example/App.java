package com.example;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String rawValue = "abc";
        String salt = "f9c977ea-b423-4b3e-9952-d38cec720b70"; // https://www.uuidgenerator.net/
        String input = String.format("%s%s", salt, rawValue);
        System.out.println(String.format("The hash of %s with salt %s is:\n  %s", rawValue, input, hash(input)));
    }

    public static String hash(String rawValue) {
        Encoder base64Encoder = Base64.getEncoder();
        String sha256 = base64Encoder.encodeToString(DigestUtils.sha256(rawValue));
        return sha256;
    }
}
