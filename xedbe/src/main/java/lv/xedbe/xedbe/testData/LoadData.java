package lv.xedbe.xedbe.testData;


import lombok.extern.slf4j.Slf4j;
import lv.xedbe.xedbe.model.User;
import lv.xedbe.xedbe.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadData {
    Logger logger = LoggerFactory.getLogger(LoadData.class);
    @Bean
    CommandLineRunner initDatabase(UserRepo repo){
        return args -> {
            logger.info("Preoloding data "+repo.save(new User("bilbo@begs.lv","raims","1234")));
        };
    }
}
