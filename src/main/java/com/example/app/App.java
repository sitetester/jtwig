package com.example.app;

import com.example.jtwig.JTwigTemplateParser;
import com.example.jtwig.UnsupportedJTwigFilterException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws IOException, InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException {
        String filename = "welcome.html";

        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");
        data.put("username", "sitetester");

        Path path = Paths.get("src/main/resources/", filename);

        String content = new JTwigTemplateParser().parseTemplate(path, data);
        System.out.println(content);
    }
}
