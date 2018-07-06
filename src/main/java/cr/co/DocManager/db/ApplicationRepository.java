/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db;

import cr.co.DocManager.db.entities.Application;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author SOIN
 */
public interface ApplicationRepository {
    Optional<List<Application>> findAll();
 
    public Application saveApplication(Application application);

    public void updateApplication(Application application);

    public void deleteApplication(String appId);
}
