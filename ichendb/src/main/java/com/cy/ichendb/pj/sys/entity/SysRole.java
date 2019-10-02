package com.cy.ichendb.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class SysRole implements Serializable {
	private static final long serialVersionUID = 8094272493294939469L;
	private Integer id;
	private String name;
	private String note;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;

}
