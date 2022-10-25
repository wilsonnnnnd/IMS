package com.ims.controller;


import com.ims.model.Policy.Policy;
import com.ims.service.PolicyService;
import com.ims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




@Controller
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private UserService userService;



    //  When the path is routed to '/managepolicy' below method to be called and view returned is managepolicy
    @RequestMapping(method = RequestMethod.GET, value = "/managePolicy")
    public ModelAndView home() {
        List<Policy> listPolicy = policyService.listAll();

        ModelAndView mav = new ModelAndView("policy/managePolicy");
        mav.addObject("listPolicy", listPolicy);
//        mav.addObject("userType", user_role);
        return mav;
    }


    //  When the path is routed to '/new' below method to be called and view returned is newPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/newpolicy")
    public String newPolicyForm(Map<String, Object> model) {
        Policy Policy = new Policy();
        List<Object> agentsIds = userService.queryAllIAgentsIds();
        List<String> data1 = new ArrayList<>();
        for (Object name: agentsIds) {
            Object[] records = (Object[]) name;
            data1.add(records[0].toString()+ " " +records[1].toString());
        }
        model.put("policy", Policy);
        model.put("ids",data1);
        return "policy/newPolicy";
    }
    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/savepolicy")
    public String savePolicy(@ModelAttribute("policy") Policy policy) {
        policyService.save(policy);
        return "redirect:/managePolicy";
    }
    //  When the path is routed to '/edit' below method to be called and view returned is editPokemon
    @RequestMapping(method = RequestMethod.GET, value = "/editpolicy")
    public ModelAndView editPolicyForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("policy/editPolicy");
        Policy policy = policyService.get(id);
        mav.addObject("policy", policy);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value ="/deletepolicy")
    public String deletePolicyForm(@RequestParam long id) {
        policyService.delete(id);
        return "redirect:/managePolicy";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/searchpolicy")
    public ModelAndView search(@RequestParam String keyword) {
        List<Policy> result = policyService.searchPolicy(keyword);
        ModelAndView mav = new ModelAndView("policy/searchPolicy");
        mav.addObject("result", result);

        return mav;
    }
}
