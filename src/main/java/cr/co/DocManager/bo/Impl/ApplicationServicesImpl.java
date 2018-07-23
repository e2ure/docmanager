/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.bo.Impl;

import cr.co.DocManager.bo.ApplicationService;
import cr.co.DocManager.db.ApplicationRepository;
import cr.co.DocManager.db.entities.Application;
import cr.co.DocManager.db.mongo.ApplicationRepositoryImpl;
import java.util.List;
import java.util.Optional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SOIN
 */
@Service("applicationService")
@Transactional
public class ApplicationServicesImpl implements ApplicationService{
    private static final Log log = LogFactory.getLog(ApplicationRepositoryImpl.class);
    @Autowired
    private ApplicationRepository  applicationRepository;

    @Autowired
    public ApplicationServicesImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    
    @Override
    public List<Application> findAll() {
        Optional<List<Application>> optionalApps = this.applicationRepository.findAll();
        return optionalApps.get();
    }

    @Override
    public Application saveApplication(Application application) {
        return this.applicationRepository.saveApplication(application);
    }

    @Override
    public void updateApplication(Application application) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteApplication(String appId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Application findById(int _id) {
        return this.applicationRepository.findById(_id);
    }

    @Override
    public Application findByObjectId(ObjectId _id) {
        return this.applicationRepository.findById(_id);
    }

    @Override
    public Application findByKey(String key, Object value) {
        return this.applicationRepository.findByKey(key, value);
    }

    @Override
    public Application findByObjectId(String _id) {
        return this.applicationRepository.findById(new ObjectId(_id));
    }
}
