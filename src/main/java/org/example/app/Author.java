package org.example.app;
import java.util.UUID;

abstract class Author extends Description{
    private UUID author_id;
    private String name;
    protected Country country;

    public Author(String name, Country country) {
        this.author_id = UUID.randomUUID();
        this.name = name;
        this.country = country;
    }

    public UUID getId() {return author_id;}
    public String getName() {return name;}
    public abstract String getCountryName();

    @Override
    public String descriptor() {
        return "Автор: Имя автора"  + ", Страна: Страна автора" ;
    }
    public Country getCountry() {return country;}

    @Override
    public String toString() {return name;}
}