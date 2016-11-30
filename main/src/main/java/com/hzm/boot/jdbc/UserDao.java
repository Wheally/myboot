package com.hzm.boot.jdbc;

import com.hzm.boot.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 用户Dao操作类
 *
 * @author xiaoqian.wen
 * @create 2016-11-30 14:43
 **/
@Repository
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public User getUserById(int id){
        String sql = "select * from tbl_user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

}
