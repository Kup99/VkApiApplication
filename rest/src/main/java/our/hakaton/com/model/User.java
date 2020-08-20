package our.hakaton.com.model;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    public User(String firstName, String lastName, String sex, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.city = city;
    }

    public User() {
    }

    private String firstName;
    private String lastName;
    private String sex;
    private String city;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
