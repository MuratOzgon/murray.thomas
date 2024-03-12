package com.challenge.murray.thomas.mapper;

import com.challenge.murray.thomas.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findUserById(Long id);
    User findByUsername(String username);
    User findUserByEmail(String email);
}
