package ch08.ex11;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

/**
 * http://www.kens-web.com/school/test/
 * ID:admin
 * PASS:1397
 */
public class Ex11 {
  
  
public static void main(String[] args) throws IOException {
  final String sUrl = "http://www.kens-web.com/school/test/";
  final String auth = "admin:1397";
  URL url = new URL(sUrl);
  URLConnection c = url.openConnection();
  String b64 = Base64.getEncoder().encodeToString(auth.getBytes());
  c.setRequestProperty("Authorization", "Basic " + b64);
  c.connect();
  Reader out = new InputStreamReader(c.getInputStream());
  int ch;
  Writer writer = null;
  while((ch = out.read()) != -1) {
    writer = new OutputStreamWriter(System.out);
    writer.write(ch);
    writer.flush();
  }
  
}
}
