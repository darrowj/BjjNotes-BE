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
    String posture;
    String startingPosition;  //Primary Position
    String offensivePosition;
    String submission;
    String guard;
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

    public String getPosture() {
        return posture;
    }

    public void setPosture(String posture) {
        this.posture = posture;
    }

    public String getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(String startingPosition) {
        this.startingPosition = startingPosition;
    }

    public String getOffensivePosition() {
        return offensivePosition;
    }

    public void setOffensivePosition(String offensivePosition) {
        this.offensivePosition = offensivePosition;
    }

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    public String getSubmission() {
        return submission;
    }

    public void setSubmission(String submission) {
        this.submission = submission;
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
                ", posture='" + posture + '\'' +
                ", startingPosition='" + startingPosition + '\'' +
                ", offensivePosition='" + offensivePosition + '\'' +
                ", submission='" + submission + '\'' +
                ", guard='" + guard + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
