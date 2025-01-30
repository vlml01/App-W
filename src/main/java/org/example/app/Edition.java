package org.example.app;

import java.util.UUID;

public class Edition {
    private UUID edition_id;
    private Work work;
    private Publisher publisher;
    private int printingQuantity;

    public Edition(Work work, Publisher publisher, int printingQuantity) {
        this.edition_id = UUID.randomUUID();
        this.work = work;
        this.publisher = publisher;
        this.printingQuantity = printingQuantity;
    }

    public UUID get_edition_id() {
        return edition_id;
    }

    public Work getWork() {
        return work;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public String toString()
    {
        return "Edition info: " + work.getTitle() + ", Publisher: "+ publisher.getPublisherName()+ ", Printing Quantity "+ printingQuantity;
    }
}

