package com.springboot.mybatis.mult.dao.test2;

import com.springboot.mybatis.mult.po.test2.UserTest;
import com.springboot.mybatis.mult.po.test2.UserTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTestMapper {
    long countByExample(UserTestExample example);

    int deleteByExample(UserTestExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTest record);

    int insertSelective(UserTest record);

    List<UserTest> selectByExample(UserTestExample example);

    UserTest selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTest record, @Param("example") UserTestExample example);

    int updateByExample(@Param("record") UserTest record, @Param("example") UserTestExample example);

    int updateByPrimaryKeySelective(UserTest record);

    int updateByPrimaryKey(UserTest record);
}