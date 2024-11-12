# **Tugas Week 7 PBO**

**Nama** : Adyuta Prajahita Murdianto

**NRP** : 5025221186

**Kelas** : PBO A

Disini kita akan merevisi tugas pada minggu kemarin dengan menambahkan sistem logging untuk menyimpan inputan user.

```java
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupportSystem {
  private InputReader inputReader;
  private Responder responder;
  private static final String LOG_FILE = "../support_log.txt";

  public SupportSystem() {
    inputReader = new InputReader();
    responder = new Responder();
  }

  public void start() {
    System.out.println("Welcome to the DodgySoft Technical Support System.");
    System.out.println("Please tell us about your problem.");
    System.out.println("We will assist you with any problem you might have.");
    System.out.println("Please type 'bye' to exit our system.");

    boolean finished = false;
    while (!finished) {
      System.out.print("> ");
      String userInput = inputReader.getInput();
      logInteraction("User input: " + userInput);

      if (userInput.equalsIgnoreCase("bye")) {
        finished = true;
        System.out.println("Goodbye! Thank you for using DodgySoft Technical Support.");
        logInteraction("System output: Goodbye! Thank you for using DodgySoft Technical Support.");
      } else {
        String response = responder.generateResponse(userInput);
        System.out.println(response);
        logInteraction("System response: " + response);
      }
    }
  }

  private void logInteraction(String message) {
    try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
      String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      writer.write(timestamp + " - " + message + "\n");
    } catch (IOException e) {
      System.err.println("Error writing to log file: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    SupportSystem supportSystem = new SupportSystem();
    supportSystem.start();
  }
}
```
Pada kode sebelumnya, kita cukup menambahkan atribut `LOG_FILE` yang akan menyimpan path ke file logging. Lalu kita juga menambahkan kelas `logInteraction` untuk melaksanakan logging interaksi ke dalam file yang diinginkan dengan keterangan waktu dalam bentuk `timestamp` dengan format `yyyy-MM-dd HH:mm:ss`. Fungsi ini memanfaatkan objek dari `FileWriter` yang merupakan kelas bawaan dari `java` yang berguna untuk menuliskan sesuatu ke dalam file. Selain itu, disini kita juga akan memanfaat kan `IOException` untuk menangkap error yang terjadi pada saat melakukan logging.

## **Hasil**

![alt text](Resource/image.png)