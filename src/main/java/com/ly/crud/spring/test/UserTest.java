package com.ly.crud.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ly.crud.spring.dao.IUserDAO;
import com.ly.crud.spring.model.User;  
  
  
public class UserTest {  
      
	static final ApplicationContext ctx = new ClassPathXmlApplicationContext("appliactionContext.xml");  
	
    @Test  
    public void  testaddUser(){  
    	try{
    		 User user = new User();  
	        user.setUsername("liu");  
	        user.setPassword("6");  
	        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");  
	        dao.addUser(user);  
    	}catch(Exception e){
    		e.printStackTrace();
    	}
       
    }  
  
    @Test  
    public void testdeleteUser(){  
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");  
        dao.deleteUser(1);  
    };  
      
    @Test  
    public void testupdateUser(){  
        User user = new User();  
        user.setId(1);  
        user.setUsername("zhi");  
        user.setPassword("1234");  
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");  
        dao.updateUser(user);  
    };  
    
    @Test  
    public void testsearchUserName(){  
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");  
        String  username = dao.searchUserName(2);  
        System.out.println(username);  
    };  
    
    @Test  
    public void testsearchUser(){  
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");  
        User  u = dao.searchUser(2);  
        System.out.println(u.toString());  
    };  
    
    @Test  
    public void testfindAll(){  
        IUserDAO dao = (IUserDAO) ctx.getBean("userDao");  
        List<User>  u = dao.findAll();      
        for (User user : u) {  
            System.out.println(user.toString());  
        }  
          
    };  
}  