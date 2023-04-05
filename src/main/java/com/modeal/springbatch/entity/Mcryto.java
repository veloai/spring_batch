package com.modeal.springbatch.entity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class Mcryto {

    public static byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

    public static String encryptAES(String text, String key) throws UnsupportedEncodingException
            , NoSuchAlgorithmException
            , NoSuchPaddingException
            , InvalidKeyException
            , IllegalBlockSizeException
            , BadPaddingException
    {
        if (text == null || text.length() == 0) {return text;}

        String[] key2 = key.split("");
        String[] key3 = new String[16];
        String key4 = "";

        for (int cnt=0; cnt < 13; cnt++) {
            if (key2[cnt] != null) {
                key3[cnt] = key2[cnt];
            }
        }
        for (int cnt2=13; cnt2 < 16; cnt2++) {
            key3[cnt2] = "\0";
        }
        key4 = arrayJoin("", key3);

        System.out.println(">>asd>>>"+key4.getBytes());

        String encrypted = null;
        byte[] source = text.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(key4.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        int mod = source.length % 16;
        byte[] changeSource = null;
        if (mod != 0) {
            changeSource = new byte[source.length + (16 - mod)];
            System.arraycopy(source, 0, changeSource, 0, source.length);
        } else {
            changeSource = source;
        }
        encrypted = byteArrayToHex(cipher.doFinal(changeSource));

        return encrypted;
    }

    // key는 16 바이트로 구성 되어야 한다.
    public static String decryptAES(String s, String key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        if (s == null || s.length() == 0) {
            return s;
        }
        String decrypted = null;

        String[] key2 = key.split("");
        String[] key3 = new String[16];
        String key4 = "";

        for (int cnt=0; cnt < 13; cnt++) {
            if (key2[cnt] != null) {
                key3[cnt] = key2[cnt];
            }
        }
        for (int cnt2=13; cnt2 < 16; cnt2++) {
            key3[cnt2] = "\0";
        }
        key4 = arrayJoin("", key3);

        SecretKeySpec skeySpec = new SecretKeySpec(key4.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        decrypted = new String(cipher.doFinal(hexToByteArray(s)), StandardCharsets.UTF_8);
        return decrypted.trim();
    }

    private static byte[] hexToByteArray(String s) {
        byte[] retValue = null;
        if (s != null && s.length() != 0) {
            retValue = new byte[s.length() / 2];
            for (int i = 0; i < retValue.length; i++) {
                retValue[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
            }
        }
        return retValue;
    }

    private static String byteArrayToHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            strbuf.append(String.format("%02X", buf[i]));
        }

        return strbuf.toString();
    }

    public static String encryptAES(String s, String key, String op1, String op2) throws Exception {
        String encrypted = null;
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), op1);

        Cipher cipher = Cipher.getInstance(op2);
        AlgorithmParameterSpec IVspec = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, IVspec);
        // cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        encrypted = byteArrayToHex(cipher.doFinal(s.getBytes(StandardCharsets.UTF_8)));
        return encrypted;
    }

    public static String arrayJoin(String glue, String array[]) {
        String result = "";

        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i < array.length - 1)
                result += glue;
        }
        return result;
    }


}
