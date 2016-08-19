package com.virtustream.java;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/", new Hello());
    server.setExecutor(null);
    server.start();
  }

  static class Hello implements HttpHandler {
    @Override
    public void handle(HttpExchange t) throws IOException {
      String response = "hello world";
      t.sendResponseHeaders(200, response.length());
      OutputStream os = t.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }
}