# Excel Data Process With Spring Boot SQLite Base64
## Purpose 
- Saving Excel File to SQLite Database with Spring Boot, encode and decode operations using Base64

- POST method is written to save the Excel file to the DB. Go to http://localhost:4000/save ENDPOINT and upload the file. If you are using POSTMAN, KEY:file should be VALUE:the selected file. While saving the file to DB, TC numbers are encrypted with BASE64.

- During the process of fetching the Data in the Excel File from the DB, the data encrypted with BASE64 was first decrypted. So when we call the GET method with http://localhost:4000/getdata ENDPOINTi we get the original data.

## Technologies
- Java 17
- Spring Boot 2.7.10
- Maven
- SQLite
- Base64

## Features
- Save Data from Excel to SQLite Database 
- Get Data from SQLite

## Base64
#### Encode
```java
    public static String encode(String plainText) {
        byte[] plainTextBytes = plainText.getBytes();
        return Base64.getEncoder().encodeToString(plainTextBytes);
    }
```
#### Decode
```java
    public static String decode(String base64Text) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Text);
        return new String(decodedBytes);
    }
```

