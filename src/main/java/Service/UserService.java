package Service;

import Dao.UserRepository;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;


    public List<User> findbynom(String nom ){
           return repository.findusebyname(nom);
    }


    public List<User> findbyvornom(String vornom ){
        return repository.findusebyvorname(vornom);
    }


    public List<User> findbyages(int age ){
        return repository.findusebyage(age);
    }

}
