package com.ims.controller;



import com.ims.model.PolicyHoldRecord.PolicyHolderRecord;
import com.ims.model.PolicyHoldRecord.PolicyHolderRecords;
import com.ims.service.PolicyHolderRecordService;
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
public class PolicyHoldRecordController {

    @Autowired
    private PolicyHolderRecordService policyHolderRecordService;
    @Autowired
    private UserService userService;

//    private String userType = user_role;



    //  When the path is routed to '/managepolicy' below method to be called and view returned is managepolicy
    @RequestMapping(method = RequestMethod.GET, value = "/managePolicyHolderRecord")
    public ModelAndView home() {
        //List<PolicyHolderRecord> listPolicyHolderRecord = policyHolderRecordService.listAll();
        List<PolicyHolderRecord> listPolicyHolderRecord = policyHolderRecordService.listAll();
//        List<PolicyHolderRecords> list = new ArrayList<>();
//        for (Object record:listPolicyHolderRecord){
//            Object[] records = (Object[]) record;
//            PolicyHolderRecords phr = new PolicyHolderRecords();
//            PolicyHolderRecord record1 =  (PolicyHolderRecord)records[2];
//            phr.setCustomer(records[0].toString()+records[1].toString());
//            phr.setAgent(record1.getAgent());
//            phr.setId(record1.getId());
//            phr.setAppliedDate(record1.getAppliedDate());
//            phr.setEndDate(record1.getEndDate());
//            phr.setOtherDetails(record1.getOtherDetails());
//            phr.setPolicyNumber(record1.getPolicyNumber());
//            phr.setPremium(record1.getPremium());
//            phr.setStartDate(record1.getStartDate());
//            phr.setStatus(record1.getStatus());
//            list.add(phr);
//        }

        ModelAndView mav = new ModelAndView("phr/managePolicyHolderRecord");
        mav.addObject("listPolicyHolderRecord", listPolicyHolderRecord);
        return mav;
    }
    //  When the path is routed to '/new' below method to be called and view returned is newPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/newpolicyHolderRecord")
    public String newPolicyHolderRecordForm(Map<String, Object> model) {
        PolicyHolderRecord PolicyHolderRecord = new PolicyHolderRecord();
        List<Object> ids = userService.queryAllIds();
        List<String> data = new ArrayList<>();
        for (Object name: ids) {
            Object[] records = (Object[]) name;
            data.add(records[0].toString()+ " " +records[1].toString());
        }
        List<Object> agentsIds = userService.queryAllIAgentsIds();
        List<String> data1 = new ArrayList<>();
        for (Object name: agentsIds) {
            Object[] records = (Object[]) name;
            data1.add(records[0].toString()+ " " +records[1].toString());
        }
//        System.out.println("Test");
        model.put("policyHolderRecord", PolicyHolderRecord);
        model.put("ids",data);
        model.put("agentsIds",data1);
        return "phr/newPolicyHolderRecord";
    }


    //  When a form is submitted in POST and action method as 'save' below method to be called returned to home '/' i.e. index
    @RequestMapping(method = RequestMethod.POST, value = "/savePolicyHolderRecord")
    public String savePolicy(@ModelAttribute("policyHolderRecord") PolicyHolderRecord policyHolderRecord) {
        policyHolderRecordService.save(policyHolderRecord);
        return "redirect:/";
    }
    //  When the path is routed to '/edit' below method to be called and view returned is editPokemon
    @RequestMapping(method = RequestMethod.GET, value = "/editPolicyHolderRecord")
    public ModelAndView editPolicyHolderRecordForm(@RequestParam long id) {
        ModelAndView mav = new ModelAndView("phr/editPolicyHolderRecord");
        PolicyHolderRecord policyHolderRecord = policyHolderRecordService.get(id);
        List<Object> ids = userService.queryAllIds();
        List<String> data = new ArrayList<>();
        for (Object name: ids) {
            Object[] records = (Object[]) name;
            data.add(records[0].toString() + " " + records[1].toString());
        }
        List<Object> agentsIds = userService.queryAllIAgentsIds();
        List<String> data1 = new ArrayList<>();
        for (Object name: agentsIds) {
            Object[] records = (Object[]) name;
            data1.add(records[0].toString()+ " " +records[1].toString());
        }
        mav.addObject("ids",data);
        mav.addObject("agentsIds",data1);
        mav.addObject("policyHolderRecord", policyHolderRecord);
        return mav;
    }
    //  When the path is routed to '/delete' below method to be called and view returned is pokemanage
    @RequestMapping(method = RequestMethod.GET, value ="/deletePolicyHolderRecord")
    public String deletePolicyHolderRecordForm(@RequestParam long id) {
        policyHolderRecordService.delete(id);
        return "redirect:managePolicyHolderRecord";
    }
    //  When the path is routed to '/search' below method to be called and view returned is searchPokemon
    @RequestMapping(method = RequestMethod.GET, value ="/searchPolicyHolderRecord")
    public ModelAndView search(@RequestParam String keyword) {
        List<PolicyHolderRecord> result = policyHolderRecordService.searchPolicyHolderRecord(keyword);
        ModelAndView mav = new ModelAndView("phr/searchPolicyHolderRecord");
        mav.addObject("result", result);

        return mav;
    }
}
