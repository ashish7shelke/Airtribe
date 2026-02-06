package com.airtribe.learntrack.entity;

public class Trainer extends Person {

    private String expertise;
    private int experienceInYears;

    public Trainer(int id, String firstName, String lastName,
                   String email, String expertise, int experienceInYears) {
        super(id, firstName, lastName, email);
        this.expertise = expertise;
        this.experienceInYears = experienceInYears;
    }

    public int getExperienceInYears(){return experienceInYears;}

    @Override
    public String getDisplayName() {
        return "Trainer: " + firstName + " " + lastName +
               " (" + expertise + ")";
    }

}
