package com.example.app;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

class JTwigTemplateParser {

    String parseTemplate(String filename, Map<String, String> data) throws IOException {

        Path path = Paths.get("src/main/resources/", filename);
        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        for (Map.Entry<String, String> pair : data.entrySet()) {
            String regex = "\\{\\{\\s*" + pair.getKey() + "\\s*\\}\\}";
            content = content.replaceAll(regex, pair.getValue()) + "\n";
        }

        return content;
    }

}
