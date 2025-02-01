package org.example.app;

class ForeignAuthor extends Author {
    public ForeignAuthor(String name, Country country) {
        super(name, country);
    }

    @Override
    public String getCountryName() {
        return this.country.getCountryName();
    }
    @Override
    public String descriptor() {
        return "Автор: " + getName() + ", Страна: " + getCountryName();
    }
}
