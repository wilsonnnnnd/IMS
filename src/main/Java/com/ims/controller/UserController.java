package com.ims.controller;

import com.ims.model.User.User;
import com.ims.service.UserService;
import com.sun.jndi.cosnaming.ExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.Instant;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //  When the path is routed to '/User/manageUser' below method to be called and view returned is Usermanage
    @RequestMapping(method = RequestMethod.GET, value = "/manageUser")
    public ModelAndView home() {
        List<User> listUser = userService.listAll();
//        for (User User : listUser) {
//            System.out.println(User.toString());
//        }
        ModelAndView mav = new ModelAndView("user/manageUser");
        mav.addObject("listUser", listUser);
        return mav;
    }
    //  When the path is routed to '/new' below method to be called and view returned is newUser
    @RequestMapping(method = RequestMethod.GET, value ="/newuser")
    public String newUserForm(Map<String, Object> model) {
        User User = new User();
        model.put("user", User);
        return "user/newUser";
    }
    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/saveuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
    //  When the path is routed to '/edit' below method to be called and view returned is editUser
    @RequestMapping(method = RequestMethod.GET, value = "/edituser")
    public ModelAndView editUserForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("user/editUser");
        User user = userService.get(id);
        mav.addObject("user", user);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is Usermanage
    @RequestMapping(method = RequestMethod.GET, value ="/deleteuser")
    public String deleteUserForm(@RequestParam long id) {
        userService.delete(id);
        return "redirect:/manageUser";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchUser
    @RequestMapping(method = RequestMethod.GET, value ="/searchuser")
    public ModelAndView search(@RequestParam String keyword) {
        List<User> result = userService.search(keyword);
        ModelAndView mav = new ModelAndView("user/searchUser");
        mav.addObject("result", result);

        return mav;
    }
}
