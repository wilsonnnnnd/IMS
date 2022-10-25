package com.ims.controller;

import com.ims.model.Account.Account;
import com.ims.model.User.User;
import com.ims.service.AccountService;
import com.ims.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/user")
public class AccountController {
    @Autowired
    AccountService accountService;

    // Default home path '/' will return view index with message
    @RequestMapping(method = RequestMethod.GET,value="/")
    public String index1(ModelMap model,HttpSession session){
        String userType = (String)session.getAttribute("userType");
//        System.out.println("进入首页进行跳转了");
        model.addAttribute("userType", userType);

        return "index";
    }

    //  When the path is routed to '/Account/manageAccount' below method to be called and view returned is Accountmanage
    @RequestMapping(method = RequestMethod.GET, value = "/manageAccount")
    public ModelAndView home() {
        List<Account> listAccount = accountService.listAll();
//        for (Account Account : listAccount) {
//            System.out.println(Account.toString());
//        }
        ModelAndView mav = new ModelAndView("account/manageAccount");
        mav.addObject("listAccount", listAccount);
        return mav;
    }


    @RequestMapping(method = RequestMethod.GET, value ="/newAccount")
    public String newUserForm(Map<String, Object> model) {
        Account account = new Account();
        model.put("account", account);
        return "account/newAccount";
    }

    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/saveaccount")
    public String saveAccount(@ModelAttribute("account") Account account) {
        String Md5Pass = MD5Utils.string2MD5(account.getPassword());
        account.setPassword(Md5Pass);
        accountService.save(account);
        return "redirect:/manageAccount";
    }
    //  When the path is routed to '/edit' below method to be called and view returned is editAccount
    @RequestMapping(method = RequestMethod.GET, value = "/editAccount")
    public ModelAndView editAccountForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("account/editAccount");
        Account account = accountService.get(id);
        mav.addObject("account", account);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is Accountmanage
    @RequestMapping(method = RequestMethod.GET, value ="/deleteAccount")
    public String deleteAccountForm(@RequestParam long id) {
        accountService.delete(id);
        return "redirect:/manageAccount";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchAccount
    @RequestMapping(method = RequestMethod.GET, value ="/searchaccount")
    public ModelAndView search(@RequestParam String keyword) {
        List<Account> result = accountService.searchaccount(keyword);
        ModelAndView mav = new ModelAndView("account/searchAccount");
        mav.addObject("result", result);

        return mav;
    }
}
