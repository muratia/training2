package com.am.training.demo.utils;

import org.apache.catalina.util.ParameterMap;

/**
 * A class that handles the colors
 */
public class ColorHandler {

    private final ParameterMap<Integer, String> colors;
    private final ParameterMap<String, Integer> colorNames;

    public ColorHandler() {
        this.colors = new ParameterMap<> ();
        this.colorNames = new ParameterMap<> ();

        this.colors.put (1, "blue");
        this.colors.put (2, "green");
        this.colors.put (3, "purple");
        this.colors.put (4, "red");
        this.colors.put (5, "yellow");
        this.colors.put (6, "turquoise");
        this.colors.put (7, "white");

        this.colorNames.put ("blue", 1);
        this.colorNames.put ("green", 2);
        this.colorNames.put ("purple", 3);
        this.colorNames.put ("red", 4);
        this.colorNames.put ("yellow", 5);
        this.colorNames.put ("turquoise", 6);
        this.colorNames.put ("white", 7);
    }

    public ParameterMap<Integer, String> getColors() {
        return colors;
    }

    public ParameterMap<String, Integer> getColorNames() {
        return colorNames;
    }
}
