/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.co.DocManager.conf;

import com.mongodb.MongoClient;
import static java.lang.System.console;
import java.net.UnknownHostException;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author SOIN
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "cr.co.DocManager")
public class AppConfig {
    /*@Resource(name = "mongodb/MyMongoClient")
    MongoClient mongoClient;*/
    MongoClient db;
    Context initCtx;

    public AppConfig() throws NamingException {
        this.initCtx = new InitialContext();
         db = (MongoClient) initCtx.lookup("java:/comp/env/mongodb/MyMongoClient");
         System.out.println("cr.co.DocManager.conf.AppConfig.<init>()");
    }
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
 
        return viewResolver;
    }
    
    /*@Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException{
        return new SimpleMongoDbFactory(new MongoClient ("localhost", 27017), "test");
    }*/
  
    @Bean
    public MongoOperations mongoOperations() throws UnknownHostException{
        return new MongoTemplate(new SimpleMongoDbFactory(db,"DocManager"));
    }
}
