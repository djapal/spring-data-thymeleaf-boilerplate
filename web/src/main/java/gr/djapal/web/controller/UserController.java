package gr.djapal.web.controller;

import gr.djapal.core.persistence.model.User;
import gr.djapal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/admin/users" }, method = RequestMethod.GET)
    public ModelAndView userList(final ModelMap model) {
        List lst = userService.findAll();
        model.addAttribute("users", lst);
        model.addAttribute("title", "User List");
        return AbstractViewController.getModelAndView("users", model);
    }

    @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
    public ModelAndView welcomeUser(final ModelMap model) {
        List lst = userService.findAll();
        model.addAttribute("title", "Welcome");
        return AbstractViewController.getModelAndView("welcome", model);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return new ResponseEntity<User>(userService.findOne(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/users", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/admin/users";
    }
}
