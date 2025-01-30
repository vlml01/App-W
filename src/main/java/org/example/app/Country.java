package org.example.app;

import java.util.UUID;

public class Country {
    private UUID country_id;
    private String countryName;

    public Country(String name) {
        this.country_id = UUID.randomUUID();
        this.countryName = name;
    }

    public UUID get_country_id() {
        return country_id;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString(){return countryName;}
}

