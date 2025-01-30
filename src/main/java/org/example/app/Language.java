package org.example.app;

import java.util.UUID;

public class Language {
    private UUID language_id;
    private String languageName;

    public Language(String name) {
        this.language_id = UUID.randomUUID();
        this.languageName = name;
    }

    public UUID get_language_id() {
        return language_id;
    }

    public String getLanguageName() {
        return languageName;
    }
    @Override
    public String toString(){return languageName;}
}
