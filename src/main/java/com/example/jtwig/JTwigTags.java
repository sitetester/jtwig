package com.example.jtwig;

import java.util.ArrayList;

public class JTwigTags {

    public static ArrayList<String> getTags() {

        ArrayList<String> tags = new ArrayList<>();

        tags.add("do");
        tags.add("include");
        tags.add("extends");
        tags.add("autoescape");
        tags.add("if");
        tags.add("for");
        tags.add("block");

        return tags;
    }
}
