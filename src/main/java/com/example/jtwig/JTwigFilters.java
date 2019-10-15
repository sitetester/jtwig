package com.example.jtwig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JTwigFilters {

    public ArrayList<String> getFilters() {
        ArrayList<String> filters = new ArrayList<>();

        filters.add("abs");
        filters.add("batch");
        filters.add("capitalize");
        filters.add("column");
        filters.add("convert_encoding");
        filters.add("country_name");
        filters.add("currency_symbol");
        filters.add("data_uri");
        filters.add("date");
        filters.add("date_modify");
        filters.add("escape");
        filters.add("filter");
        filters.add("format");
        filters.add("format_currency");
        filters.add("format_date");
        filters.add("format_datetime");
        filters.add("format_number");
        filters.add("format_time");
        filters.add("html_to_markdown");
        filters.add("inline_css");
        filters.add("inky_to_html");
        filters.add("join");
        filters.add("json_encode");
        filters.add("keys");
        filters.add("language_name");
        filters.add("last");
        filters.add("length");
        filters.add("locale_name");
        filters.add("lower");
        filters.add("map");
        filters.add("markdown_to_html");
        filters.add("merge");
        filters.add("nl2br");
        filters.add("number_format");
        filters.add("raw");
        filters.add("reduce");
        filters.add("replace");
        filters.add("reverse");
        filters.add("round");
        filters.add("slice");
        filters.add("sort");
        filters.add("spaceless");
        filters.add("split");
        filters.add("striptags");
        filters.add("timezone_name");
        filters.add("title");
        filters.add("trim");
        filters.add("upper");
        filters.add("url_encode");
        filters.add("first");

        return filters;
    }

    public boolean hasFilter(String filter) throws UnsupportedJTwigFilterException {
        if (!this.getFilters().contains(filter)) {
            throw new UnsupportedJTwigFilterException("This filter is currently not supported.");
        }

        return this.getFilters().contains(filter);
    }

    public String applyFilter(String filter, ArrayList<String> filterArgs) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = JTwigFilters.class.getMethod(filter, ArrayList.class);
        JTwigFilters jTwigFilters = new JTwigFilters();

        return (String) method.invoke(jTwigFilters, filterArgs);
    }

    public String upper(ArrayList<String> filterArgs) {
        return filterArgs.get(0).toUpperCase();
    }

    public String lower(ArrayList<String> filterArgs) {
        return filterArgs.get(0).toLowerCase();
    }

    public String title(ArrayList<String> filterArgs) {
        // return value.to();
        // TODO: pending
        return "";
    }

    public String capitalize(ArrayList<String> filterArgs) {
        String lowerCased = filterArgs.get(0).toLowerCase();
        String firstLetter = lowerCased.substring(0, 1).toUpperCase();
        String remainingChars = lowerCased.substring(1, lowerCased.length());

        return firstLetter + remainingChars;
    }

    public String defaultVal(ArrayList<String> filterArgs) {
        return filterArgs.get(0);
    }

    public String abs(ArrayList<String> filterArgs) {
        return String.valueOf(Math.abs(Integer.valueOf(filterArgs.get(0))));
    }

    public String nl2br(ArrayList<String> filterArgs) {
        return filterArgs.get(0).replace("\n", "</br>");
    }

    public String join(ArrayList<String> filterArgs) {
        String[] parts = filterArgs.get(0).split(",");

        String partsJoined = "";
        int counter = 0;
        for (String part : parts) {
            counter++;
            if (counter > 0) {
                partsJoined += filterArgs.get(1) + part.trim();
            }
        }

        return partsJoined;
    }

    public String split(ArrayList<String> filterArgs) {

        String partsJoined = "[";

        if (filterArgs.get(0).indexOf(",") > 0) {
            String[] parts = filterArgs.get(0).split(",");

            int counter = 0;
            for (String part : parts) {
                counter++;
                if (counter > 1) {
                    partsJoined += filterArgs.get(1) + " ";
                }

                partsJoined += part.trim();
            }

            partsJoined += "]";
        }

        return partsJoined;
    }

    public String first(ArrayList<String> filterArgs) {
        String[] parts = filterArgs.get(0).split(",");

        return parts[0];
    }

    public String last(ArrayList<String> filterArgs) {
        String[] parts = filterArgs.get(0).split(",");

        return parts[parts.length - 1];
    }

    public String reverse(ArrayList<String> filterArgs) {
        return new StringBuilder(filterArgs.get(0)).reverse().toString();
    }
}
