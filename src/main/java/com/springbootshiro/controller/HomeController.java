package com.springbootshiro.controller;

import com.springbootshiro.bean.User;
import com.springbootshiro.service.UserService;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    @RequiresPermissions("/")
    @GetMapping("/")
    public String index(HttpSession httpSession) {
        User user = userService.getCurrentUser();

        if (user == null) {
            return "login";
        }

        httpSession.setAttribute("user", user);
        return "index";
    }


    @RequiresPermissions("/manager")
    @GetMapping("/manager")
    public String mananger(HttpSession httpSession) {

        User user = userService.getCurrentUser();

        httpSession.setAttribute("user", user);
        return "index";
    }


    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @ExceptionHandler({AuthorizationException.class, UnknownAccountException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleException(AuthorizationException e, Model model) {

        return "unauthorized";
    }

}
