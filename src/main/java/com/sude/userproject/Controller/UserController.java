package com.sude.userproject.Controller;

import com.sude.userproject.Entity.User;
import com.sude.userproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sude.userproject.Service.MailService;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping("/contact")
    public String contact(@RequestBody User user) {
        return  userService.contactAdd(user);
   }
}
