/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

/**
 *
 * @author SOIN
 */
@Component
public class MongoAcces {
    @Autowired
    private MongoOperations mongoOperations;
    
    public MongoAcces(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    
    
}
