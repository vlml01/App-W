package org.example.app;

class RussianAuthor extends Author {
    public RussianAuthor(String name, Country country) {
        super(name, country);
    }

    @Override
    public String getCountryName() {
        return this.country.getCountryName();
    }
    @Override
    public String descriptor() {
        return "Автор: " + getName() + ", Страна: Россия" ;
    }
}
