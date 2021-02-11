package project1;

import javax.persistence.*;


@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int childId;
    private String childName;
    private int childAge;

    @ManyToOne
    private UserDetails user;

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public int getChildId() {

        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public UserDetails getUserDetails() {
        return user;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.user = userDetails;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public int getChildAge() {
        return childAge;
    }

    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }
}
