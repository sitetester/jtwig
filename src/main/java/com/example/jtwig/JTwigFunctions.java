package com.example.jtwig;

import java.util.ArrayList;

public class JTwigFunctions {

    public static ArrayList<String> getFunctions() {

        ArrayList<String> functions = new ArrayList<>();

        functions.add("attribute");
        functions.add("block");
        functions.add("constant");
        functions.add("cycle");
        functions.add("date");
        functions.add("dump");
        functions.add("include");
        functions.add("parent");
        functions.add("min");
        functions.add("max");
        functions.add("random");
        functions.add("range");
        functions.add("source");
        functions.add("template_from_string");

        return functions;
    }
}
