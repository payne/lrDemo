package me.roessing.lrdemo.model;

import java.util.UUID;

/**
 * @author Rolf Roessing
 * @version $Revision: $:
 * @since 09.07.13
 */
public class UserData {
    private String id = UUID.randomUUID().toString()   ;
    private String middleInitial;
    private String name;
    private String surname;
    private String age;

    public UserData() {
    }

    public UserData(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(final String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(final String age) {
        this.age = age;
    }
}
