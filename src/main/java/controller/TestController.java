package controller;

import Dao.AdresseRepository;
import Dao.UserRepository;
import Rest.Error.ErrorMessage;
import Rest.restRequest.AdresseBasicInfoBodyRestRequest;
import Rest.restRequest.UserBasicInfoBodyRestRequest;
import Rest.restRequest.UserMitAdresseBodyRestRequest;
import Rest.restResponse.BasicBodyRestResponse;
import Rest.restResponse.UserBodyRestResponse;
import Service.UserService;
import com.example.api_test_nellynd.ApiTestNellyNdApplication;
import entity.Adresse;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/url")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdresseRepository adresseRepository;

    @GetMapping(path = "/user/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUserName(@PathVariable(value = "name") String nom) {
        return userService.findbynom(nom);
    }

    @GetMapping(path = "/user/{vorname}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUserVorname(@PathVariable(value = "vorname") String vorname) {
        return userService.findbyvornom(vorname);
    }

    @GetMapping(path = "/user/{age}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUserage(@PathVariable(value = "age") int age) {
        return userService.findbyages(age);
    }

    @GetMapping(path = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserBodyRestResponse getUser() {
        UserBodyRestResponse response = new UserBodyRestResponse();
        try {
            response.setUserList(userRepository.findAll());
            return response;
        } catch (Exception e) {
            log.error("Cannot read user daten");
            response.addErrorMessage(ErrorMessage.technical_error);
            return response;
        }
    }


    @PostMapping(path = "/saveUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public BasicBodyRestResponse saveUser(@RequestBody UserBasicInfoBodyRestRequest user) {
        BasicBodyRestResponse response = new BasicBodyRestResponse();
        try {
            userRepository.save(new User(user.getName(), user.getVorname(), user.getAge(), user.getEmail(), user.getPassword()));
            log.info(user.toString()+" was save successfully");
            return response;
        } catch (Exception e) {
            log.error(user.toString()+" was save unsuccessfully");
            response.addErrorMessage(ErrorMessage.technical_error);
            return response;
        }
    }

    @PostMapping(path = "/saveAdresse", produces = {MediaType.APPLICATION_JSON_VALUE})
    public BasicBodyRestResponse saveAdresse(@RequestBody AdresseBasicInfoBodyRestRequest adresse){
        BasicBodyRestResponse response = new BasicBodyRestResponse();
        try {
            adresseRepository.save(new Adresse(null,adresse.getStrasse(), adresse.getNummer()));
            log.info(adresse.toString()+" was save successfully");
            return response;
        } catch (Exception e){
            log.error(adresse.toString()+" was save unsuccessfully");
            response.addErrorMessage(ErrorMessage.technical_error);
            return response;
        }
    }

    @PostMapping(path = "/addAddressToUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    public BasicBodyRestResponse addUserToAdresse(@RequestBody UserMitAdresseBodyRestRequest userMitAdresseBodyRestRequest){
        BasicBodyRestResponse response = new BasicBodyRestResponse();
        try {
            Optional<Adresse> adresseOptional = adresseRepository.findById(userMitAdresseBodyRestRequest.getIdAdresse());
            Optional<User> userOptional = userRepository.findById(userMitAdresseBodyRestRequest.getIdUser());
            if (!adresseOptional.isPresent() || !userOptional.isPresent()) {
                response.addErrorMessage(ErrorMessage.id_indvalid);
                log.error("ids are invalid");
                return response;
            }
            User user = userOptional.get();
            Adresse adresse = adresseOptional.get();

            adresse.addUser(user);
            log.error("Address  was successfully add to User");
            adresseRepository.save(adresse);
            return  response;

        } catch (Exception e){
            log.error("cannot add Address to User");
            response.addErrorMessage(ErrorMessage.technical_error);
            return response;
        }
    }

}
