package lv.xedbe.xedbe.controller;


import lv.xedbe.xedbe.repository.UserRepo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

}
