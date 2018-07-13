/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db.mongo;

import cr.co.DocManager.db.SequenceIdRepository;
import cr.co.DocManager.db.entities.SequenceId;
import cr.co.DocManager.db.entities.exceptions.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SOIN
 */
@Repository
public class SequenceIdRepositoryImpl implements SequenceIdRepository{
    @Autowired
    MongoOperations mongoOperations;

    @Autowired
    public SequenceIdRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
    
    
    
    @Override
    public int getNextValue(String collection) {
        //get sequence id
        Query query = new Query(Criteria.where("_id").is(collection));
        
        SequenceId seqId;
        seqId = mongoOperations.findOne(query, SequenceId.class);
        
        if(seqId == null ){
            seqId = new SequenceId(collection,0);
            this.saveSequence(seqId);
        }
        
        //increase sequence id by 1
        Update update = new Update();
        update.inc("seq", 1);

        //return new increased id
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        //this is the magic happened.
        seqId = mongoOperations.findAndModify(query, update, options, SequenceId.class);

        //if no id, throws SequenceException
        //optional, just a way to tell user when the sequence id is failed to generate.
        if (seqId == null) {
              throw new SequenceException("Unable to get sequence id for key : " + collection);
        }

        return seqId.getSeq();
    }

    @Override
    public void saveSequence(SequenceId sequenceId) {
        mongoOperations.save(sequenceId);
    }
    
}
