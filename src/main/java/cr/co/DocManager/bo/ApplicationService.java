/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.bo;

import cr.co.DocManager.db.entities.Application;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author SOIN
 */
public interface ApplicationService {
    List<Application> findAll();
 
    public Application saveApplication(Application application);

    public void updateApplication(Application application);

    public void deleteApplication(String appId);
    
    public Application findById(String _id);
    
    public Application findByObjectId(ObjectId _id);
    
    public Application findByObjectId(String _id);
    
    public Application findByKey(String key, Object value);
}
