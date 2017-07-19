package com.jasondarrow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.List;

/**
 * Created by darrowj on 7/1/17.
 */
@Document(collection = "lookups")
public class Lookups {

    @Id
    String id;
    String title;
    List<String> names;

    public Lookups(String id, String title, List<String> names) {
        this.title = title;
        this.names = names;
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

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
