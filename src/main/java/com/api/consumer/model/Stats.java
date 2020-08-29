package com.api.consumer.model;

import lombok.Data;

public class Stats {

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    private int total;
    private User author;

}
