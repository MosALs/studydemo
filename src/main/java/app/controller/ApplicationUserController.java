package app.controller;


import app.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {


    @Autowired
    private ApplicationUserController applicationUserController;





    public void signUp(@RequestBody ApplicationUser applicationUser){
//        applicationUser.setPassword();

    }
}
