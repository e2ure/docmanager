/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db.mongo;

import cr.co.DocManager.db.ApplicationRepository;
import cr.co.DocManager.db.entities.Application;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 *
 * @author SOIN
 */
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository{
    @Autowired
    private final MongoOperations mongoOperations;
    
    @Autowired
    public ApplicationRepositoryImpl(MongoOperations mongoOperations) {
        Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
    }
    
    @Override
    public Optional<List<Application>> findAll() {
        List<Application> applications = this.mongoOperations.findAll(Application.class,"applications");
        Optional<List<Application>> optionalApplications = Optional.ofNullable(applications);
        return optionalApplications;
    }

    @Override
    public Application saveApplication(Application application) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateApplication(Application application) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteApplication(String appId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
