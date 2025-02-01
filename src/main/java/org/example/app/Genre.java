package org.example.app;
import java.util.UUID;
public class Genre extends Description{
    private UUID genre_id;
    private String GenreName;

    public Genre(String name) {
        this.genre_id = UUID.randomUUID();
        this.GenreName = name;
    }

    public UUID get_genre_id() {
        return genre_id;
    }

    public String getGenreName() {
        return GenreName;
    }

    @Override
    public String descriptor() {
        return "Жанр: " + GenreName;
    }
    @Override
    public String toString(){return GenreName;}
}
