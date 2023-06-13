import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
  private ByteArrayOutputStream byteArrayOutputStream;

  @BeforeEach
  void setUp() {
    byteArrayOutputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
  }

  @AfterEach
  void tearDown() {
    // System.setOut(System.out);
  }

  @Test
  @DisplayName("mainメソッドを実行")
  public void main() {
    // main()メソッドを実行
    Main.main(new String[]{});

    // 標準出力の内容を取得
    System.out.flush();
    final String actual = byteArrayOutputStream.toString();

    // 期待値を設定
    final String expected = "Hello world!" + System.lineSeparator();
    assertEquals(expected, actual, "Hello world!となるように修正して");
  }
}