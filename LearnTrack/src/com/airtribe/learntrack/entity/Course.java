package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {
  
    private int id;
    private String courseName;
    private int durationInWeeks;
    private String description;    
    private CourseStatus status;

    public Course(int id, String courseName, int durationInWeeks, String description) 
    {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = CourseStatus.ACTIVE;
    }

    public CourseStatus activeStatus() 
    {
        return status;
    }

    public void deactivate() 
    {
        this.status = CourseStatus.INACTIVE;
    }

    public void activate() 
    {
        this.status = CourseStatus.ACTIVE;
    }

    public void toggleActive()
    {
        if(this.status == CourseStatus.ACTIVE)
            deactivate();
        else
            activate();
    }
    // All accessor or getter methods
    public int getId() {return id;}
    public String getName(){return courseName;}
    public int getDurationInWeeks(){return durationInWeeks;}
    public CourseStatus getStatus(){return status;}
    public String getDisplayName() {return (id + " " +courseName);}

    // All mutator or setter methods
    public void setId(int id_) {id = id_;}
    public void setCourseName(String course){courseName = course;}
    public void setDurationInWeeks(int duration){durationInWeeks = duration;}
    public void setStatus(CourseStatus status_){status = status_;}
    public void setDescription(String description_){description = description_;}
    
    public void showDetails()
    {
        System.out.println("\tCourse Details as follows: ");
        System.out.println("\tCourse ID: " + id);
        System.out.println("\tCourse Name: " + courseName);
        System.out.println("\tDuration in Week: " + durationInWeeks);
        System.out.println();
    }

    @Override
    public String toString() {
        return id + " - " + courseName + " (" + durationInWeeks + " weeks)" + "description: " + description;
    }    
}
