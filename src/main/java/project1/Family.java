package project1;

import javax.persistence.*;

@Entity

public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int famiyId;
    @OneToOne
    private UserDetails userDetails;
    private String motherName;
    private String fatherName;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public int getFamiyId() {
        return famiyId;
    }

    public void setFamiyId(int famiyId) {
        this.famiyId = famiyId;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
