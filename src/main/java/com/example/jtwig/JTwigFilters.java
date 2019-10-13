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
        filters.add("defaultVal");
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

        return filters;
    }

    public boolean hasFilter(String filter) throws UnsupportedJTwigFilterException {
        if (!this.getFilters().contains(filter)) {
            throw new UnsupportedJTwigFilterException("This filter is currently not supported.");
        }

        return this.getFilters().contains(filter);
    }

    public String applyFilter(String filter, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = JTwigFilters.class.getMethod(filter, String.class);
        JTwigFilters jTwigFilters = new JTwigFilters();

        return (String) method.invoke(jTwigFilters, value);
    }

    public String upper(String value) {
        return value.toUpperCase();
    }

    public String lower(String value) {
        return value.toLowerCase();
    }

    public String title(String value) {
        // return value.to();
        // TODO: pending
        return "";
    }

    public String capitalize(String value) {
        String lowerCased = value.toLowerCase();

        String firstLetter = lowerCased.substring(0, 1).toUpperCase();
        String remainingChars = lowerCased.substring(1, lowerCased.length());

        return firstLetter + remainingChars;
    }

    public String defaultVal(String value) {
        return value;
    }

    public String abs(String value) {
        return String.valueOf(Math.abs(Integer.valueOf(value)));
    }
}
