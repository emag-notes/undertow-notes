package undertownotes;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class HelloWorldServer {

  public static void main(String[] args) {
    Undertow server = Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler(exchange -> {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "application/json");
        exchange.getResponseSender().send("{\"message\": \"Hello Undertow\"}");
      }).build();
    server.start();
  }

}
