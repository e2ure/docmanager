/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db.mongo;

import cr.co.DocManager.db.ApplicationRepository;
import cr.co.DocManager.db.SequenceIdRepository;
import cr.co.DocManager.db.entities.Application;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 *
 * @author SOIN
 */
@Repository
public class ApplicationRepositoryImpl implements ApplicationRepository{
    private static final String APPLICATION_SEQ_KEY = "applications";
    
    @Autowired
    private final MongoOperations mongoOperations;
    
    @Autowired
    private final SequenceIdRepository sequenceIdRepository;
    
    @Autowired
    public ApplicationRepositoryImpl(MongoOperations mongoOperations,SequenceIdRepository sqIdRepository) {
        Assert.notNull(mongoOperations);
        this.mongoOperations = mongoOperations;
        this.sequenceIdRepository=sqIdRepository;
    }
    
    @Override
    public Optional<List<Application>> findAll() {
        List<Application> applications = this.mongoOperations.findAll(Application.class,"applications");
        Optional<List<Application>> optionalApplications = Optional.ofNullable(applications);
        return optionalApplications;
    }

    @Override
    public Application saveApplication(Application application) {
        if(application.getAppId()==0){
            application.setAppId(this.sequenceIdRepository.getNextValue(APPLICATION_SEQ_KEY));
        }
        this.mongoOperations.save(application);
        return application;
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
        Query query = new Query();
        query.addCriteria(Criteria.where("appId").is(_id));
        return mongoOperations.findOne(query, Application.class);
    }

    @Override
    public Application findById(ObjectId _id) {
        return this.mongoOperations.findById(_id, Application.class);
    }

    @Override
    public Application findByKey(String key, Object value) {
        Query query = new Query();
        query.addCriteria(Criteria.where(key).is(value));
        return mongoOperations.findOne(query, Application.class);
    }
    
}
