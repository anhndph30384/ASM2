package anhnd.ph30384.asm2.controller;

import anhnd.ph30384.asm2.model.User;
import anhnd.ph30384.asm2.repository.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserCtrl {
    @Autowired
    UserRepo repo;

    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        repo.save(user);
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String showUserList(Model model) {
        model.addAttribute("users", repo.findAll());
        return "user";
    }

    @GetMapping("/edituser/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/updateuser/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        repo.save(user);
        return "redirect:/user";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID:" + id));
        repo.delete(user);
        return "redirect:/user";
    }

}
