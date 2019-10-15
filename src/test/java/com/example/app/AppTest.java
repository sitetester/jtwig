package com.example.app;

import com.example.jtwig.JTwigFilters;
import com.example.jtwig.JTwigTemplateParser;
import com.example.jtwig.UnsupportedJTwigFilterException;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class AppTest {

    @Test
    public void main() throws IOException, InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException {

        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");
        data.put("username", "sitetester");

        Path path = Paths.get("src/main/resources/", "welcome.html");

        String content = new JTwigTemplateParser().parseTemplate(path, data);
        assertTrue(content.contains("My blog"));
    }

    @Test
    public void regex() throws IOException, UnsupportedJTwigFilterException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Map<String, String> data = new HashMap<>();
        data.put("title", "My blog");

        String content = "<title> {{title|defaultVal(\"var is not defined\") }}</title>";

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String regex = "\\{\\{\\s*((" + pair.getKey() + ")\\|(.+)" + ")\\s*\\}\\}";
            System.out.println(regex);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                System.out.println("matcher.group(0) --- " + matcher.group(0));
                System.out.println("matcher.group(1) --- " + matcher.group(1));
                System.out.println("matcher.group(2) --- " + matcher.group(2));
                System.out.println("matcher.group(3) --- " + matcher.group(3));

                String replacingRegex = "\\{\\{" + matcher.group(2) + "\\|(.+)" + "\\}\\}";
                System.out.println(replacingRegex);
                JTwigFilters jTwigFilters = new JTwigFilters();

                String filter = matcher.group(3).trim();
                String appliedValue = "";

                System.out.println(filter.indexOf("("));
                System.out.println(filter.substring(0, filter.indexOf("(")));
                // System.out.println(filter.substring(filter.indexOf("(") + 1, filter.indexOf(")")));
                String defaultValParam = filter.substring(filter.indexOf("(") + 2, filter.indexOf(")") - 1);
                System.out.println(defaultValParam);

                if (jTwigFilters.hasFilter(filter)) {
                    String arg = pair.getValue();
                    // appliedValue = jTwigFilters.applyFilter(filter, arg);
                }

                content = content.replaceAll(regex, appliedValue) + "\n";
            }

            System.out.println(content);
        }
    }
}
