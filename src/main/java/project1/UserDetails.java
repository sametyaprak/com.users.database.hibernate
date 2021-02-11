package project1;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity(name = "user_details")
public class UserDetails {
    //primary key ekledik ve bu primarykey otomatik olarak eklensin istedik
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    //username stununun ismini değistirdik ve data tipi hakkinda duzenleme yaptik.
    @Column(name = "user_names", nullable = false, length = 100)
    private String userName;

    private String userSirname;
    @Embedded
    private Adress adress;
    ///////////////////////////////////////////////////////////////////////////////////
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "workAdress")),
            @AttributeOverride(name = "city", column = @Column(name = "workCity")),
            @AttributeOverride(name = "country", column = @Column(name = "workCountry")),
    })
    private Adress workAdress;
    //Adress tipinde iki farklı veri var bunları birbirinden ayrı olmasına ragmen
    //tablo column isimleri aynı oldu.bunu degististirdik.
    //////////////////////////////////////////////////////////////////////////////////
    @ElementCollection
    @JoinTable(name = "books", joinColumns = @JoinColumn(name = "userId"))
    //elementlerden dolayi yeni bir tablo olusturduk
    //bu tabloya giden foreignKey ismini degistirdik
    //her olusturulan tablonun bir primary key.i olmalı.bunu @CollectionId ile urettik
    // ve onunla ilgili verileri doldurduk
    @GenericGenerator(name = "hilo-gen",strategy = "hilo")
    @CollectionId(columns = {@Column(name = "bookID")}, type = @Type(type = "long"), generator = "hilo-gen")
    private List<Book> userBooks = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "family")
    private Family family;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "childId"),
                inverseJoinColumns = @JoinColumn(name = "userId"))
    private Collection<Child> child = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<Laptop> laptops = new ArrayList<>();

    public Collection<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Collection<Laptop> laptops) {
        this.laptops = laptops;
    }

    public Collection<Child> getChild() {
        return child;
    }

    public void setChild(Collection<Child> child) {
        this.child = child;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Collection<Book> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<Book> userBooks) {
        this.userBooks = userBooks;
    }

    public Adress getWorkAdress() {
        return workAdress;
    }

    public void setWorkAdress(Adress workAdress) {
        this.workAdress = workAdress;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getUserSirname() {
        return userSirname;
    }

    public void setUserSirname(String userSirname) {
        this.userSirname = userSirname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
