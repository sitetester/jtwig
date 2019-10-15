package com.example.jtwig;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JTwigFunctionsTest {

    @Test
    public void min() throws InvocationTargetException, UnsupportedJTwigFilterException, IllegalAccessException, NoSuchMethodException, IOException {

        Map<String, String> data = new HashMap<>();
        Path path = Paths.get("src/test/resources/functions/min", "min.html");

        String content = new JTwigTemplateParser().parseTemplate(path, data);

        assertTrue(content.contains("3"));
        assertFalse(content.contains("5"));
        assertFalse(content.contains("7"));
    }
}
