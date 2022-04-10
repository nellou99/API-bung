package entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String strasse;
    private int nummer;
     @ManyToMany
     @JoinTable (name = "userAdresse",
         joinColumns = @JoinColumn (name= "adresseID"),
          inverseJoinColumns = @JoinColumn (name= "UserID") )

    private List <User> userList;

    public Adresse(){

    }
    public void addUser(User user){
        if (userList==null )
            userList= new ArrayList<>();
        userList.add(user);
    }

    public Adresse(Long id, String strasse, int nummer) {
        this.id = id;
        this.strasse = strasse;
        this.nummer = nummer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }
}
