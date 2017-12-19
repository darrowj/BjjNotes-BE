package com.jasondarrow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by darrowj on 6/23/17.
 */
@Document(collection = "profiles")
public class Profile {

    @Id
    String id;
    String uid;
    String firstName;
    String lastName;
    String yearborn;
    String belt;
    String weight;
    String schoolLocation;
    String schoolname;
    String created;
    String updated;

    public Profile() {
    }

    public Profile(String id, String uid, String firstname, String lastname, String yearBorn, String belt, String weight, String schoolLocation, String schoolname) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.yearborn = yearBorn;
        this.belt = belt;
        this.weight = weight;
        this.schoolLocation = schoolLocation;
        this.schoolname = schoolname;
    }

    public Profile(String uid, String firstname, String lastname, String yearBorn, String belt, String weight, String schoolLocation, String schoolname) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.yearborn = yearBorn;
        this.belt = belt;
        this.weight = weight;
        this.schoolLocation = schoolLocation;
        this.schoolname = schoolname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYearborn() {
        return yearborn;
    }

    public void setYearborn(String yearborn) {
        this.yearborn = yearborn;
    }

    public String getBelt() {
        return belt;
    }

    public void setBelt(String belt) {
        this.belt = belt;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearBorn='" + yearborn + '\'' +
                ", belt='" + belt + '\'' +
                ", weight='" + weight + '\'' +
                ", schoolLocation='" + schoolLocation + '\'' +
                ", schoolname='" + schoolname + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
