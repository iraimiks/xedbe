package lv.xedbe.xedbe.controller;


import lv.xedbe.xedbe.exeption.UserNotFoundExeption;
import lv.xedbe.xedbe.model.User;
import lv.xedbe.xedbe.repository.UserRepo;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @GetMapping("/userList")
    public List<User> all(){
        return userRepo.findAll();
    }
    @PostMapping("/userList")
    public User newUser(@RequestBody User userNew){
        return userRepo.save(userNew);
    }
    //get singel user by id
    @GetMapping("/userList/{id}")
    Resource<User> one(@PathVariable Long id){
        User user = userRepo.findById(id)
                .orElseThrow(()->new UserNotFoundExeption(id));
        return new Resource<User>(user,
                linkTo(methodOn(UserController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UserController.class).all()).withRel("employees"));

    }
    @PutMapping("/userList/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepo.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getEmail());
                    user.setNickname(newUser.getNickname());
                    user.setPassword(newUser.getPassword());
                    user.setUserRole(newUser.getUserRole());
                    return userRepo.save(user);
                })
                .orElseGet(()->{
                    newUser.setId(id);
                    return userRepo.save(newUser);
                });
    }
    @DeleteMapping("/userList/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);
    }

}
