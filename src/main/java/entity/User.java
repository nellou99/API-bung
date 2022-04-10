package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data  @NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String vorname ;
    private int age;
    private String email;
    private String password;

    @OneToOne
    private Konto konto;
    @ManyToMany (mappedBy = "userList")
    private List<Adresse> adresseList;
    @OneToMany
    private List<AccessCard> accessCardList = new ArrayList<>();


    public void addAccessCard(AccessCard accessCard){
        accessCardList.add(accessCard);
    }

    public User(Long id, String name, String vorname, int age) {
        this.id = id;
        this.name = name;
        this.vorname = vorname;
        this.age = age;
    }

    public User(String name, String vorname, int age, String email, String password) {
        this.name = name;
        this.vorname = vorname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public void addAdresse(Adresse adresse){
        if (adresseList==null)
            adresseList= new ArrayList<>();
        adresseList.add(adresse);
    }
}
