/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.view.controllers;

import cr.co.DocManager.bo.ApplicationService;
import cr.co.DocManager.bo.Impl.ApplicationServicesImpl;
import cr.co.DocManager.db.entities.Application;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author SOIN
 */
@Controller
public class ApplicationsViewController{
    private static final Log log = LogFactory.getLog(ApplicationsViewController.class);
 
    
    private final ApplicationService applicationService;
    
    
    private Application application;
    
    @Autowired
    public ApplicationsViewController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    
    @GetMapping("/Applications/apps")
    public String getApplications(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        List<Application> apps=applicationService.findAll();
        model.addAttribute("applications",apps);
        /*log.info("Get allUsers");
        return ResponseEntity.ok(applicationService.findAll());*/
        return "applications";
    }
}
