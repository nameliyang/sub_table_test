package com.ly.crud.spring.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ly.crud.spring.dao.ILabelDAO;
import com.ly.crud.spring.model.Label;

public class LabelTest {
	
	static final ApplicationContext ctx = new ClassPathXmlApplicationContext("appliactionContext.xml");
	
	@Test
	public void testaddUser() {
		for (long i = 0; i < 100; i++) {
			try {
				Label user = new Label();
				user.setId(i);
				user.setLabelCode("test" + i);
				user.setOrgID(i/20);
				ILabelDAO dao = (ILabelDAO) ctx.getBean("labelDao");
				dao.addLabel(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void queryUser() {
		try{
			ILabelDAO dao = (ILabelDAO) ctx.getBean("labelDao");
			String sql = "select * from t_label where id > 12 order by id desc limit 1000";
			Object[] objs = new Object[]{};
			List<Label> lable = dao.getLable(sql, objs);
			System.out.println(lable.size()+" "+lable);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
