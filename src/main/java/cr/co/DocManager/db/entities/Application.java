package cr.co.DocManager.db.entities;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SOIN
 */
@Document(collection = "applications")
public class Application implements Serializable{
    @Id
    private String _id;
    private int appId;
    private String name;

    public Application() {
    }

    public String getObjId() {
        return _id;
    }

    public void setObjId(String objId) {
        this._id = objId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
