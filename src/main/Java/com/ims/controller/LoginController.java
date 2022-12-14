package com.ims.controller;


import com.ims.model.Account.Account;
import com.ims.service.AccountService;
import com.ims.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import static com.ims.utils.MD5Utils.convertMD5;

@Controller

public class LoginController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET,value="/login")
    public String login(ModelMap model, HttpSession session){
        return "login";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(HttpSession session, ModelMap model , @ModelAttribute("account") Account account)
    {

        String s = convertMD5(account.getPassword());
        String pss = MD5Utils.convertMD5(convertMD5(s));
        account.setPassword(pss);
        Account accountResult = accountService.findUsers(account.getUsername());
        if(accountResult != null && StringUtils.contains(account.getPassword(), accountResult.getPassword())){
            session.setAttribute("sessionKey", accountResult.getUsername());
            session.setAttribute("userType", accountResult.getUsertype());
            model.addAttribute("userType", accountResult.getUsertype());
            return "index";
        } else {

            return  "login";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value ="/exit")
    public String exit(HttpSession session, ModelMap modelMap) {
        session.setAttribute("sessionKey", "");
        session.setAttribute("userType","");
        modelMap.addAttribute("userType", "");
        return "redirect:/login";
    }
}
