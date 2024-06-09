package org.example.customerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.example.customerService.entity.User;
import org.example.customerService.service.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/customer/api")
public class RestController {

    private final UserService userService;

    public RestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/hello")
    public String hello() {

        return "Hello";
    }

    @PostMapping("/getUserToken")
    public String getToken(@RequestBody String username) {

        String token = userService.getUserTokenByUsername(username);
        if(token.equals("none"))
        {
            return "none";
        }
        return token;
    }

    @PostMapping("/getPassword")
    public String getPassword(@RequestBody String username) {

        User user = userService.getUser(username);
        if (user == null)
        {
            return "";
        }
        return user.getPassword();
    }

    @PostMapping("/getSum")
    public String getSum(@RequestBody String username) {

        User user = userService.getUser(username);
        if (user == null)
        {
            return "";
        }
        return user.getBankAccount().getSum().toString();
    }

    @PostMapping("/setSum")
    public String setSum(@RequestBody String body) {
        String[] userData = body.split(":");
        User user = userService.getUser(userData[0]);
        if (user == null)
        {
            return "";
        }
        Long sum = Long.parseLong(userData[1]) + user.getBankAccount().getSum();
        user.getBankAccount().setSum(sum);
        userService.SaveUser(user);
        return user.getBankAccount().getSum().toString();
    }

    @PostMapping("/getHistory")
    public String getHistory(@RequestBody String username) throws JsonProcessingException {
        User user = userService.getUser(username);
        if (user == null)
        {
            return "";
        }
        return  userService.userHistoryListToJson(user.getBankAccount().getOperations());
    }

    @PostMapping("/setHistory")
    public String setHistory(@RequestBody String body) throws JsonProcessingException {
        User user = userService.getUser(body);
        if (user == null)
        {
            return "";
        }
        return  userService.userHistoryListToJson(user.getBankAccount().getOperations());
    }
}
