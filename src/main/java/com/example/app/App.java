package com.example.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException {
        String filename = "welcome.html";

        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");
        data.put("username", "sitetester");

        String content = new JTwigTemplateParser().parseTemplate(filename, data);
        System.out.println(content);
    }
}
