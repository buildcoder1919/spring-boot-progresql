package com.main.controler;

import java.util.List;

import com.main.config.InUrlConfig;
import com.main.mapper.TestInfoMapper;
import com.main.model.TestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.mapper.UserMapper;
import com.main.model.UserEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserEntityControler {
	private Logger log = LoggerFactory.getLogger(UserEntityControler.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private TestInfoMapper testInfoMapper;
	@Resource
	private RestTemplate restTemplate;
	@Autowired
	private RedisTemplate<String,String> cache;

	@RequestMapping("/cache/push/{start}")
	public void push(@PathVariable int start) {
		  for (int i = start; i < start+10; i++) {
            cache.opsForList().rightPush("testlist",i+"");
			  log.info("push.{}",i);
		  }
	}

//	@Scheduled(cron = "*/2 * * * * *")
	public void retry() {
		List<String> strList = cache.opsForList().range("testlist",0,-1);
		log.info("range.{}",strList.size());
		cache.opsForList().trim("testlist",strList.size(),-1);
	}
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		InUrlConfig urlconfig = new InUrlConfig();
		List<UserEntity> users=userMapper.getAll();
		return users;
	}

	/**
	 * @Decription:
	 * @Paramater:
	 * @return:
	 * @Author:liyan
	 * @Date: 2019/12/1 0:06
	 */
	@RequestMapping("/getTestInfo/{id}")
	public TestInfo getTestInfo(@PathVariable Short id) {
        TestInfo testInfos=testInfoMapper.selectByPrimaryKey(id);
		testInfos.setContent("11");
		ResponseEntity<UserEntity> userEntity = restTemplate.getForEntity("",UserEntity.class);
		log.info("userEntity={}",userEntity.getBody());
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
