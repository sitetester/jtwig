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

    @Test
    public void defaultVal() throws IOException, InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException {

        // case 1: given variable is NOT empty
        Map<String, String> data1 = new HashMap<>();
        data1.put("title", "abc");

        Path path = Paths.get("src/test/resources/filters/defaultVal", "welcome.html");

        String content1 = new JTwigTemplateParser().parseTemplate(path, data1);
        assertTrue(content1.contains("abc"));

        // case 2: given variable IS empty
        Map<String, String> data2 = new HashMap<>();
        data2.put("title", "");

        String content2 = new JTwigTemplateParser().parseTemplate(path, data2);
        assertTrue(content2.contains("var is not defined"));
    }


    @Test
    public void abs() throws InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException, IOException {

        Map<String, String> data = new HashMap<>();
        data.put("someNumber", "-11");

        Path path = Paths.get("src/test/resources/filters/abs", "welcome.html");

        String content = new JTwigTemplateParser().parseTemplate(path, data);
        assertTrue(content.contains("11"));
    }
}
