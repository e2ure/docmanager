/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.view.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SOIN
 */
@Controller
public class GeneralViewController {
    private static final Log log = LogFactory.getLog(ApplicationsViewController.class);
    
    @RequestMapping(value = {"/","/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String getApplications(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        /*List<Application> apps=applicationService.findAll();
        model.addAttribute("applications",apps);*/
        /*log.info("Get allUsers");
        return ResponseEntity.ok(applicationService.findAll());*/
        return "index";
    }
}
