package main.java.com.apress.pss.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @GetMapping("/")
    public String homePage(ModelMap model) {
        return "welcome";
    }

    @GetMapping("/welcome")
    public String welcomePage(ModelMap model) {
        return "welcome";
    }

    @GetMapping("/authenticated")
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "authenticated";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest req, HttpServletResponse resp) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            new SecurityContextLogoutHandler().logout(req,resp,auth);
        }
        return "welcome";
    }

    private String getPrincipal() {
        String username = null;
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if(principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}
