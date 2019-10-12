package com.example.app;

import java.util.ArrayList;

public class JTwigFilters {

    public static ArrayList<String> getFilters() {
        ArrayList<String> filters = new ArrayList<String>();

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
        filters.add("default");
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
}
