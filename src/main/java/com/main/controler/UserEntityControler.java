package com.main.controler;

import java.util.List;

import com.main.mapper.TestInfoMapper;
import com.main.model.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.mapper.UserMapper;
import com.main.model.UserEntity;

@RestController
@RequestMapping("/user")
public class UserEntityControler {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TestInfoMapper testInfoMapper;

	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	@RequestMapping("/getTestInfo")
	public TestInfo getTestInfo(@RequestParam Short id) {
        TestInfo testInfos=testInfoMapper.selectByPrimaryKey(id);
		testInfos.setContent("11");
		return testInfos;
	}

    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
}
