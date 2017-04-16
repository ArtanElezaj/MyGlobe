package com.artan.myglobe.models;



public class Countries {

    private String name;
    private String alpha3Code;
    private String region;
    private String subregion;
    private String capital;
    private String population;
    private String area;
    private String[] languages;
    private String[] currencies;
    private String[] timezones;
    private String[] callingCodes;
    private String[] borders;

    public String getName() {
        return name;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String[] getCurrencies() {
        return currencies;
    }

    public String[] getTimezones() {
        return timezones;
    }

    public String[] getCallingCodes() {
        return callingCodes;
    }

    public String[] getBorders() {
        return borders;
    }
}
