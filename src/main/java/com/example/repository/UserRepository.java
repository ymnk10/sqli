package com.example.repository;

import com.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findByUsernameAndPassword(String username, String password) {
        String sql = String.format("SELECT * FROM users WHERE name = '%s' AND password = '%s'",username, password);
        return jdbcTemplate.queryForList(sql);
    }
}
