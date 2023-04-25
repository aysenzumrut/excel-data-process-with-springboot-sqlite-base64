# excel-data-process-with-springboot-sqlite-base64
Saving Excel File to SQLite Database with Spring Boot, encode and decode operations using Base64

Excel dosyasını DB ye kaydetmek için POST metodu yazılmıştır.
http://localhost:4000/save ENDPOINTine gidip file yüklenir.
POSTMAN kullanıyorsanız KEY:file VALUE:seçilen dosya olmalıdır.
Dosya DB ye kaydedilirken tc ler BASE64 ile şifrelenir.

Excel Dosyasındaki Verileri DB den getirme işlemi sırasında ilk olarak BASE64 ile şifrelenen veriler çözülmüştür.
Böylece GET metodunu http://localhost:4000/getdata ENDPOINTi ile çağırdığımızda orijinal veriyi elde ederiz.
