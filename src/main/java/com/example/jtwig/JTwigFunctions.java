package com.example.jtwig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JTwigFunctions {

    public ArrayList<String> getFunctions() {

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

    public boolean hasFunction(String functionName) throws UnsupportedJTwigFilterException {
        if (!this.getFunctions().contains(functionName)) {
            throw new UnsupportedJTwigFilterException("This functionName is currently not supported.");
        }

        return this.getFunctions().contains(functionName);
    }

    public String applyFunction(String functionName, ArrayList<String> args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = JTwigFunctions.class.getMethod(functionName, ArrayList.class);
        JTwigFunctions jTwigFunctions = new JTwigFunctions();

        return (String) method.invoke(jTwigFunctions, args);
    }

    public String min(ArrayList<String> args) {
        String[] strArgs = args.get(0).split(",");

        int min = 0;

        for (int i = 0; i < strArgs.length; i++) {
            if (i == 1) {
                continue;
            }

            if (i == 0) {
                min = Math.min(
                        Integer.valueOf(strArgs[0].trim()),
                        Integer.valueOf(strArgs[1].trim())
                );
            } else {
                min = Math.min(min, Integer.parseInt(strArgs[i].trim()));
            }
        }

        return String.valueOf(min);
    }
}
