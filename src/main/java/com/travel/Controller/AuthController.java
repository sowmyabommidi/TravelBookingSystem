package com.travel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travel.entity.User;
import com.travel.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user, Model model) {

        User savedUser = userService.register(user);

        if (savedUser != null) {
            model.addAttribute("msg", "Registration successful. Please login.");
            return "login";
        }

        model.addAttribute("error", "Registration failed");
        return "register";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        User user = userService.authenticate(email, password);

        if (user != null) {
            session.setAttribute("loggedUser", user);
            return "redirect:/home";
        }

        model.addAttribute("error", "Invalid Email or Password");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // ✅ ABOUT PAGE
    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // corresponds to about.html in templates
    }

    // ✅ CONTACT PAGE
    @GetMapping("/contact")
    public String contactPage() {
        return "contact"; // corresponds to contact.html in templates
    }
}
