package com.jasondarrow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

/**
 * Created by darrowj on 6/23/17.
 */
@Document(collection = "notes")
public class Note {

    @Id
    String id;
    String title;
    String description;

    public Note() { }

    public Note(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;

    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
