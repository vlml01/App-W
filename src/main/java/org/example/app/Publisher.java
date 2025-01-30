package org.example.app;

import java.util.UUID;

public class Publisher {
    private UUID publisher_id;
    private String publisherName;

    public Publisher(String name) {
        this.publisher_id = UUID.randomUUID();
        this.publisherName = name;
    }

    public UUID get_publisher_id() {
        return publisher_id;
    }

    public String getPublisherName() {
        return publisherName;
    }
    @Override
    public String toString()
    {
        return publisherName;
    }
}
