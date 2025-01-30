package org.example.app;
import java.util.UUID;

public class Author {
    private UUID author_id;
    private String name;
    private Country country;

    public Author(String name, Country country) {
        this.author_id = UUID.randomUUID();
        this.name = name;
        this.country = country;
    }

    public UUID getId() {return author_id;}
    public String getName() {return name;}

    public Country getCountry() {return country;}

    @Override
    public String toString() {return name;}
}