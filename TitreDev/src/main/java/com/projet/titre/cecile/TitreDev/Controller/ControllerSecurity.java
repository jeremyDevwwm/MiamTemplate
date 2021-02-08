package com.projet.titre.cecile.TitreDev.Controller;

import com.projet.titre.cecile.TitreDev.Entities.UserMiam;
import com.projet.titre.cecile.TitreDev.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerSecurity {
    @Autowired
    UserService userService;


    @PostMapping("/saveUser")
    public UserMiam saveUser(UserMiam user){
        return userService.saveUser(user);
    }

    @RequestMapping(value= "/UpdatePass", method = RequestMethod.POST)
    public void updateUser(@RequestBody String mdp){
        System.out.println(mdp);
        userService.updateUser(mdp);
    }
}
