package com.ly.crud.spring.dao;

import java.util.List;

import com.ly.crud.spring.model.Label;

public interface ILabelDAO {
	
	public void addLabel(Label user);
	
	public List<Label> getLable(String sql,Object[] objs);
	
}