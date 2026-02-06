package src.com.airtribe.learntrack.entity;

public class Student extends Person{

    private int batch;
    private boolean active;


    public Student(int id_, String first, String last)
    {
        super(id_, first, last, null);
        this.active = true;
    }

    public Student(int id_, String first, String last, String email_, int batch_)
    {
        super(id_, first, last, email_);
        batch = batch_;
        this.active = true;
    }

    public int getBatch(){return batch;}
    public void setBatch(int bat){batch = bat;}

    public void showDetails()
    {
        super.showDetails();
    }
    @Override
    public String getDisplayName()
    {
        return "Student: " + super.getDisplayName();
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }    
}
