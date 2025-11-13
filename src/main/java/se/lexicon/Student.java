package se.lexicon;

public class Student {

    private int id;
    private String name;
    private String email;
    private String address;


    //Constructor
    public Student(int id, String name, String email, String address) {
        setid(id);
        setName(name);
        setEmail(email);
        setAddress(address);
    }




    //Getter and Setter
    //id
    public int getid() {
        return id;
    }

    public void setid(int id) {
        if(id != 0) {
            this.id = id;
        }
    }


    //Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }


    //email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null) {
            this.email = email;
        }
    }


    //address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address != null) {
            this.address = address;
        }
    }
}
