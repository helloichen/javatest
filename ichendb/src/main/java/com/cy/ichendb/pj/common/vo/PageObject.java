package com.cy.ichendb.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageObject<T> implements Serializable{
	private static final long serialVersionUID = 1536631092048817285L;
	//当前页码值
	private Integer pageCurrent=1;
	//页面大小
	private Integer pageSize=3;
	//总行数(通过查询获得)
	private Integer rowCount=0;
	//总页数,通过计算获得
	private Integer pageCount=0;
	//当前页记录
	private List<T> records;
	
}
