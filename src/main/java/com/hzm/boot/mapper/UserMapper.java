package com.hzm.boot.mapper;

import com.hzm.boot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Insert("INSERT INTO tbl_user(name, password) VALUES(#{name},#{password})")
    public int insertUser(@Param("name") String name, @Param("password")  String password);

    /**
     * 插入用户，并将主键设置到user中
     * 注意：返回的是数据库影响条数，即1
     */
    public int insertUserWithBackId(User user);

    /**
     * 根据用户Id查找用户
     * @param userId
     * @return
     */
    @Select("select id, name,password from tbl_user where id = #{userId}")
    public User findUserById(@Param("userId") int userId);

}

