package com.example.api_test_nellynd;

import Dao.AccessCardRepository;
import Dao.AdresseRepository;
import Dao.KontoRepository;
import Dao.UserRepository;
import entity.AccessCard;
import entity.Adresse;
import entity.Konto;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller", "entity", "Dao", "Service"})

@EnableJpaRepositories("Dao")
@EntityScan("entity")
public class ApiTestNellyNdApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ApiTestNellyNdApplication.class);

    @Autowired
    UserRepository repository;

    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    KontoRepository kontoRepository;

    @Autowired
    AccessCardRepository accessCardRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiTestNellyNdApplication.class, args);
        log.info("Go");

    }

    @Override
    public void run(String... args) throws Exception {

        if (false) {

            Adresse adresse1 = new Adresse(null, "breiter weg", 118);
            Adresse adresse2 = new Adresse(null, "breiter weg", 118);
            Adresse adresse3 = new Adresse(null, "breiter weg", 118);

            User user1 = new User(null, "nelly", "pascale", 21);
            User user2 = new User(null, "nel", "pascal", 22);

            Konto konto1 = new Konto(null, "Girokonto");
            Konto konto2 = new Konto(null, "Hauptkonto");

            AccessCard accessCard1 = new AccessCard();
            AccessCard accessCard2 = new AccessCard();
            AccessCard accessCard3 = new AccessCard();

            kontoRepository.save(konto1);
            kontoRepository.save(konto2);

            user1.setKonto(konto1);
            user2.setKonto(konto2);

            repository.save(user1);
            repository.save(user2);

            accessCard1.setUser(user1);
            accessCard2.setUser(user2);
            accessCard3.setUser(user2);

            accessCardRepository.save(accessCard1);
            accessCardRepository.save(accessCard2);
            accessCardRepository.save(accessCard3);

            adresse1.addUser(user2);
            adresse1.addUser(user1);
            adresse2.addUser(user2);
            adresse3.addUser(user2);
            adresse2.addUser(user1);

            adresseRepository.save(adresse1);
            adresseRepository.save(adresse2);
            adresseRepository.save(adresse3);

            System.out.println(" Ende");
        }

    }
}
