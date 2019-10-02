package com.cy.ichendb.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class SysUser implements Serializable {
	private static final long serialVersionUID = -7065444926526118305L;
	private Integer id;
	@NotBlank(message = "username can not be null")
	private String username;
	private String password;
	private String salt;// 盐值
	private String email;
	private String mobile;
	private Integer valid = 1;
	private Integer deptId;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;

}
