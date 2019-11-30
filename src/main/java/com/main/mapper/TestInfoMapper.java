package com.main.mapper;

import com.main.model.TestInfo;

public interface TestInfoMapper {
    int deleteByPrimaryKey(Short id);

    int insert(TestInfo record);

    int insertSelective(TestInfo record);

    TestInfo selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(TestInfo record);

    int updateByPrimaryKey(TestInfo record);
}