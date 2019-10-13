package com.example.jtwig;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class JTwigFiltersTest {

    @Test
    public void upper() throws IOException, InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException {

        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");

        Path path = Paths.get("src/test/resources/filters/upper", "welcome.html");

        String content = new JTwigTemplateParser().parseTemplate(path, data);
        assertTrue(content.contains("MY BLOG"));
    }

    @Test
    public void lower() throws IOException, InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException {

        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");

        Path path = Paths.get("src/test/resources/filters/lower", "welcome.html");

        String content = new JTwigTemplateParser().parseTemplate(path, data);
        assertTrue(content.contains("my blog"));
    }

    @Test
    public void capitalize() throws IOException, InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException {

        Map<String, String> data = new HashMap<>();
        data.put("title", "My Blog");

        Path path = Paths.get("src/test/resources/filters/capitalize", "welcome.html");

        String content = new JTwigTemplateParser().parseTemplate(path, data);
        assertTrue(content.contains("My blog"));
    }
}
