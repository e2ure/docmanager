/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.microservices.controllers;

import cr.co.DocManager.bo.ApplicationService;
import cr.co.DocManager.db.entities.Application;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SOIN
 */
@RestController
public class ApplicationsMicroController {
    private static final Log log = LogFactory.getLog(ApplicationsMicroController.class);
 
    
    private final ApplicationService applicationService;
    
    
    private Application application;
    
    @Autowired
    public ApplicationsMicroController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    
    @RequestMapping(value = {"/microServices/apps"},method = {RequestMethod.GET}, produces = "application/json")
    public @ResponseBody List<Application> getApplicationsList(){        
        List<Application> apps=applicationService.findAll();
        return apps;
    }
    
    @RequestMapping(value = {"/microServices/apps/{appId}"},method = {RequestMethod.GET})
    public @ResponseBody Application getApplicationById(@PathVariable(name="appId", required=false) int appId){        
        Application apps=applicationService.findById(appId);
        return apps;
    }
    
    @RequestMapping(value = {"/microServices/apps/{appId}/"},method = {RequestMethod.POST})
    public @ResponseBody Application addApplicationSchema(@PathVariable(name="appId", required=true) int appId,@RequestParam(name="schema", required=true) String schema){        
        Application app=applicationService.findById(appId);
        app.getApplicationSchema().setSchema(schema);
        app.getApplicationSchema().setAppId(appId);
        applicationService.saveApplication(app);
        return app;
    }
}
