package com.springbootshiro.controller;

import com.springbootshiro.bean.User;
import com.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginAuth(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam(value = "rememberMe", required = false) Boolean rememberMe,
                            HttpSession httpSession,
                            Model model) {


        UsernamePasswordToken token = new UsernamePasswordToken(username, password,
                rememberMe != null, "localhost");
        Subject subject = SecurityUtils.getSubject();
        String error = null;

        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            httpSession.setAttribute("user", user);
            model.addAttribute("user", user);
        } catch (UnknownAccountException uae) {
            error = "UnknownAccountException";
        } catch (IncorrectCredentialsException ice) {
            error = "IncorrectCredentialsException";
        } catch (LockedAccountException lae) {
            error = "LockedAccountException";
        } catch (ExcessiveAttemptsException eae) {
            error = "ExcessiveAttemptsException";
        } catch (AuthenticationException ae) {
            error = "AuthenticationException";
        }

        if (error != null) {
            model.addAttribute("error", true);
            model.addAttribute("errorInfo", error);
            return "login";
        }

        return "index";
    }

}
