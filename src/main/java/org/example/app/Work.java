package org.example.app;

import java.util.UUID;

public class Work {
    private UUID work_id;
    private String title;
    private Author author;
    private Genre genre;
    private Language language;

    public Work(String title, Author author, Genre genre, Language language) {
        this.work_id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.language = language;
    }
    public UUID get_work_id(){return work_id;}

    public String getTitle() {
        return title;
    }
    public Author getAuthor() {
        return author;
    }
    public Genre getGenre() {
        return genre;
    }
    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return title + " by " + author.getName() + ", Genre: " + genre.getGenreName() + ", Language: " + language.getLanguageName();
    }
}

