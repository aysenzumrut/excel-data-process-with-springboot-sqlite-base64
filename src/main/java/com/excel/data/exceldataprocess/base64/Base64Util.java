package com.excel.data.exceldataprocess.base64;

import java.util.Base64;

public class Base64Util {
//VERİYİ ŞİFRELEMEK(ENCODE) VE ÇÖZÜMLEMEK(DECODE) İÇİN METODLAR YAZILMIŞTIR
    public static String encode(String plainText) {
        byte[] plainTextBytes = plainText.getBytes();
        return Base64.getEncoder().encodeToString(plainTextBytes);
    }

    public static String decode(String base64Text) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Text);
        return new String(decodedBytes);
    }
}
