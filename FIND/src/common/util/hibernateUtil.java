package common.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class hibernateUtil {
	
	private static SessionFactory factory;  
    
	   static{  
	           try{  
	            
	            Configuration cfg=new Configuration().configure();  
	           
	            factory=cfg.buildSessionFactory();  
	          
	           }catch(Exception e){  
	              e.printStackTrace();   
	           }  
	   }    
	     
	   public static Session getSession(){  
		  
	       return factory.openSession();  
	   }  
	     
	   public static void closeSession(Session session){  
	       if(session!=null){  
	           if(session.isOpen()){  
	               session.close();  
	           }  
	       }  
	   }  
	   public static SessionFactory getSessionFactory(){  
	       return factory;  
	   }  
}
