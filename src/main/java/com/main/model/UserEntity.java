package com.main.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private String userSex;
	private String nickName;
}
