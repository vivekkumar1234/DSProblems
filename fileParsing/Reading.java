package fileParsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Reading {

  @Test
  void testReadingThroughBufferedReader() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\project\\Practise\\src\\fileParsing\\test.txt"))) {
      String str = br.readLine();
      assertEquals("vivek,31,factset", str);
      str = br.readLine();
      assertEquals("vignesh,32,jda", str);
    }
  }

  @Test
  void testReadingThroughS() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\project\\Practise\\src\\fileParsing\\test.txt"));
        Scanner sc = new Scanner(br)) {
      String str = sc.nextLine();
      assertEquals("vivek,31,factset", str);
      sc.useDelimiter("[,\r\n]");
      assertEquals("vignesh", sc.next());
      assertEquals("32", sc.next());
      assertEquals("jda", sc.next());
    }
  }

  @Test
  void validateStdin() {
    String input = "2000";
    InputStream stdin = System.in;
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Scanner scanner = new Scanner(System.in);
    int isIntInput = scanner.nextInt();
    assertEquals(isIntInput, 2000);
    System.setIn(stdin);
    scanner.close();
  }
}
