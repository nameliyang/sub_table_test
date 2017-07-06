package com.ly.crud.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ly.crud.spring.dao.IUserDAO;
import com.ly.crud.spring.model.User;  
  
public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO {  
  
    @Override  
    public void addUser(User user) {  
        // TODO Auto-generated method stub  
        String sql = "insert into temp values(?,?,?)";  
        this.getJdbcTemplate().update(sql, null,user.getUsername(),user.getPassword());  
    }  
  
    @Override  
    public void deleteUser(int id) {  
        // TODO Auto-generated method stub  
        String sql = "delete from temp where id = ?";  
        this.getJdbcTemplate().update(sql, id);  
    }  
  
    @Override  
    public void updateUser(User user) {  
        // TODO Auto-generated method stub  
        String sql = "update temp set username =?,password=? where id = ?";  
        this.getJdbcTemplate().update(sql, user.getUsername(),user.getPassword(),user.getId());  
    }  
  
    @Override  
    public String searchUserName(int id) {  
        // TODO Auto-generated method stub    
        String sql = "select username from temp where id = ?";  
        return  this.getJdbcTemplate().queryForObject(sql, String.class, id);  
    }  
  
    @Override  
    public User searchUser(int id) {  
        // TODO Auto-generated method stub  
        String sql="select * from temp where id=?";  
        return this.getJdbcTemplate().queryForObject(sql, new UserRowMapper(), id);  
    }  
  
    @Override  
    public List<User> findAll() {  
        // TODO Auto-generated method stub  
        String sql = "select * from temp";  
        return this.getJdbcTemplate().query(sql, new UserRowMapper());  
    }  
  
     class UserRowMapper implements RowMapper<User> {  
        //rs为返回结果集，以每行为单位封装着  
        @Override  
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {  
            // TODO Auto-generated method stub  
            User user = new User();  
            user.setId(rs.getInt("id"));  
            user.setUsername(rs.getString("username"));  
            user.setPassword(rs.getString("password"));  
            return user;  
        }  
     }  
}  