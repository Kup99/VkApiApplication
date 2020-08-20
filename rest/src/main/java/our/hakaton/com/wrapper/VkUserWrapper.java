package our.hakaton.com.wrapper;

/**
 * Created by 813632 on 04.07.2020.
 */
public class VkUserWrapper {

    private String id;
    private String firstName;
    private String lastName;
    private String sex;
    private String city;
    private String education;

    public VkUserWrapper(String id, String firstName, String lastName, String sex, String city, String education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.city = city;
        this.education = education;
    }

    public VkUserWrapper() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
