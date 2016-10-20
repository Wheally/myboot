package com.hzm.boot.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
public class User {

    @Id
    private int id;
    private String name;
    @JSONField(serialize=false)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
