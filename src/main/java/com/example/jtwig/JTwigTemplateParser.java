package com.example.jtwig;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JTwigTemplateParser {

    public String parseTemplate(Path path, Map<String, String> data) throws IOException, UnsupportedJTwigFilterException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String regex = "\\{\\{\\s*((" + pair.getKey() + ")\\|?(.+)?" + ")\\s*\\}\\}";
            System.out.println(regex);

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            if (matcher.find()) {
                JTwigFilters jTwigFilters = new JTwigFilters();
                String arg = pair.getValue();

                if (matcher.group(3).trim().length() == 0) {
                    content = content.replaceAll(regex, arg) + "\n";
                } else {
                    String filter = matcher.group(3).trim();
                    String appliedValue = "";

                    if (jTwigFilters.hasFilter(filter)) {
                        appliedValue = jTwigFilters.applyFilter(filter, arg);
                    }

                    content = content.replaceAll(regex, appliedValue) + "\n";
                }

            }
        }

        return content;
    }
}
