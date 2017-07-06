package com.ly.crud.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ly.crud.spring.dao.ILabelDAO;
import com.ly.crud.spring.model.Label;

public class LabelDAOImpl extends JdbcDaoSupport implements ILabelDAO {

	@Override
	public void addLabel(Label label) {
		String sql = "INSERT INTO t_label (id, labelCode,org_Id) VALUES (?, ?,?)";
		this.getJdbcTemplate().update(sql, new Object[] { label.getId(), label.getLabelCode() ,label.getOrgID()});
	}

	@Override
	public List<Label> getLable(String sql, Object[] objs) {
		List<Label> query = this.getJdbcTemplate().query(sql, objs, new RowMapper<Label>() {
			@Override
			public Label mapRow(ResultSet rs, int rowNum) throws SQLException {
				Label label = new Label();
				label.setId(rs.getLong("id"));
				label.setLabelCode(rs.getString("labelCode"));
				return label;
			}
		});
		return query;
	}

}
