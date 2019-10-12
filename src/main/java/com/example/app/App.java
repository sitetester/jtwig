package com.example.app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static JTwig jtwig;

    public App() {
        this.jtwig = new JTwig();
    }

    public static void main(String[] args) throws IOException {
        /*String nextLine = "Welcome, {{ username }}";

        String regex = "\\{\\{.+\\}\\}";
        Pattern r = Pattern.compile(regex);
        String replaced = nextLine.replaceAll(regex, "sitetester");
        System.out.println(replaced);*/


       /* String replaced = nextLine.replaceAll(pattern, "sitetester");
        System.out.println(replaced);*/


        String filename = "welcome.html";
        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");
        data.put("username", "sitetester");

        String content = renderTemplate(filename, data);
        System.out.println(content);
    }

    private static String renderTemplate(String filename, Map<String, String> data) throws IOException {
        Path path = Paths.get("src/main/resources/", filename);
        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String regex = "\\{\\{\\s*" + pair.getKey() + "\\s*\\}\\}";
            content = content.replaceAll(regex, pair.getValue()) + "\n";
        }

        return content;
    }
}
