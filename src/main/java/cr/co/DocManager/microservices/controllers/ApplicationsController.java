/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.microservices.controllers;

import cr.co.DocManager.bo.ApplicationService;
import cr.co.DocManager.db.entities.Application;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SOIN
 */
@RestController
@RequestMapping("applications")
public class ApplicationsController {
    private static final Log log = LogFactory.getLog(ApplicationsController.class);
 
    private final ApplicationService applicationService;
    
    
    private Application application;
    
    @Autowired
    public ApplicationsController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Application>> userById(){
        log.info("Get allUsers");
        return ResponseEntity.ok(applicationService.findAll());
    }
}
