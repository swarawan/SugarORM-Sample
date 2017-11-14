package com.swarawan.sugarorm_sample.database;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by rioswarawan on 11/14/17.
 */

public class Book extends SugarRecord {

    @Unique
    public int id;
    public String title;
    public String author;
    public String genre;

    public Book() {
    }

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}
