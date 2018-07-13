/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.db;

import cr.co.DocManager.db.entities.SequenceId;

/**
 *
 * @author SOIN
 */
public interface SequenceIdRepository {
    public int getNextValue(String collection);
    
    public void saveSequence(SequenceId sequenceId);
}
