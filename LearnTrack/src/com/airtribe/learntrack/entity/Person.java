package src.com.airtribe.learntrack.entity;

public class Person {
    private int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    
    Person(int id_, String first, String last, String email_)
    {
        id = id_;
        firstName = first;
        lastName = last;
        email = email_;
    }

    // All accessor or getter methods
    public int getId() {return id;}
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmail(){return email;}
    public String getDisplayName() {return new String(firstName + " " +lastName);}

    // All mutator or setter methods
    public void setId(int id_) {id = id_;}
    public void setFirstName(String first){firstName = first;}
    public void setLastName(String last){lastName = last;}
    public void setEmail(String email_){email = email_;}
    
    public void showDetails()
    {
        System.out.println("Id: " + id);
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
    }
}
