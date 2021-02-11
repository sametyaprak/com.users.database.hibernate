package project1;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String laptopId;
    private String laptopName;
    private int laptopPower;

    @ManyToMany
    private Collection<UserDetails> user;

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public int getLaptopPower() {
        return laptopPower;
    }

    public void setLaptopPower(int laptopPower) {
        this.laptopPower = laptopPower;
    }

    public Collection<UserDetails> getUser() {
        return user;
    }

    public void setUser(Collection<UserDetails> user) {
        this.user = user;
    }
}
