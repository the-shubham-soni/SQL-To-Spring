package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.util.PathConstants;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all users
    public List<User> getAllUsers() {
        String sql = PathConstants.SELECT_ALL_USERS;
        RowMapper<User> rowMapper = (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }


    // Update user data
    public User updateUser(User user) {
        String sql = PathConstants.UPDATE_USER_QUERY;
        int result = jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
        if (result > 0) {
            return user; // Return the updated user
        }
        return null;
    }
    
    // Insert user data
    public User insertUser(User user) {
        String sql = PathConstants.INSERT_USER_QUERY;
        int result = jdbcTemplate.update(sql, user.getName(), user.getEmail());
        if (result > 0) {
            return user; // Return the inserted user
        }
        return null;
    }


}
