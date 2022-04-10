package Dao;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query ("select u from User u")
    public  List<User> findalluser() ;

    @Query ("select u from User u where u.name = :name")
    public List <User> findusebyname (@Param(value= "name") String name);

    @Query ("select u from User u where u.age = :age")
    public List <User> findusebyage (@Param(value= "age") int age);

    @Query ("select u from User u where u.vorname = :vname")
    public List <User> findusebyvorname (@Param(value= "vname") String vorname);
}

