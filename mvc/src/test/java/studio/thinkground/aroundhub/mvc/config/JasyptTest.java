package studio.thinkground.aroundhub.mvc.config;

import org.springframework.boot.test.context.SpringBootTest;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class JasyptTest {

  @Test
  void encryptTest() {
    String id = "ddd";
    String password = "ddd";

    System.out.println(jasyptEncoding(id));
    System.out.println(jasyptEncoding(password));
  }

  public String jasyptEncoding(String value) {
    String key = "around_hub_studio";
    StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
    pbeEnc.setAlgorithm("PBEWithMD5AndDES");
    pbeEnc.setPassword(key);
    return pbeEnc.encrypt(value);
  }
}
