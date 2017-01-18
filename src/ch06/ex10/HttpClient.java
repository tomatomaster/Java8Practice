package ch06.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClient {


  private String url;

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompletableFuture<String> html = new HttpClient("http://www.yahoo.co.jp").getHtml();
    CompletableFuture<List<URL>> links = html.thenApply(HttpClient::getLinks);
    links.thenAccept(System.out::println);
    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
  }
  
  public HttpClient(String url) {
    this.url = url;
  }

  CompletableFuture<String> getHtml() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        return _getHtml();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return "";
    });
  }
  
  static public List<URL> getLinks(String page) {
    Pattern ptn = Pattern.compile("<a href=\"(.*?)\">");
    Matcher m = ptn.matcher(page);
    List<URL> result = new ArrayList<>();
    while(m.find()) {
      String url = m.group(1);
      try {
        result.add(new URL(url));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  private CompletableFuture<List<URL>> getLinks() {
    return getHtml().thenApply(html -> {
      Pattern ptn = Pattern.compile("<a href=\"(.*?)\">");
      Matcher m = ptn.matcher(html);
      List<URL> result = new ArrayList<>();
      while(m.find()) {
        String url = m.group(1);
        try {
          result.add(new URL(url));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return result;
    });
  }

  private String _getHtml() throws IOException {
    HttpURLConnection connector = (HttpURLConnection) new URL(url).openConnection();
    StringBuilder sb = new StringBuilder();
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(connector.getInputStream()))) {
      String line = reader.readLine();
      do {
        sb.append(line + System.lineSeparator());
        line = reader.readLine();
      } while (line != null);
    }
    return sb.toString();
  }
}
