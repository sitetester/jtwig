package com.example.jtwig;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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

                String filterWithParams = matcher.group(3).trim();

                if (filterWithParams.length() == 0) {
                    content = content.replaceAll(regex, arg) + "\n";
                } else {
                    String appliedValue = "";

                    String filter = "";
                    if (filterWithParams.indexOf("(") > 0) {
                        filter = filterWithParams.substring(0, filterWithParams.indexOf("("));
                    } else {
                        filter = filterWithParams;
                    }

                    if (jTwigFilters.hasFilter(filter)) {
                        if (pair.getValue().trim().length() == 0) {
                            arg = filterWithParams.substring(filterWithParams.indexOf("(") + 2, filterWithParams.indexOf(")"));
                        }

                        String filterArg = filterWithParams.substring(filterWithParams.indexOf("(") + 2, filterWithParams.indexOf(")") - 1);

                        ArrayList<String> filterArgs = new ArrayList<>();
                        filterArgs.add(arg);
                        filterArgs.add(filterArg);

                        appliedValue = jTwigFilters.applyFilter(filter, filterArgs);
                    }

                    content = content.replaceAll(regex, appliedValue) + "\n";
                }

            }
        }

        return content;
    }
}
