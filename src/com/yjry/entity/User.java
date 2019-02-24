package com.yjry.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @Description: Person数据表实体类，继承基础实体类
 * @author YJRY
 * @date 2018年12月8日 上午11:55:28
 */

public class User extends BaseEntity {
	private String name;
	private  String pwd;
	private String sex;
	private String email;
	private Integer level;
	private Integer exp;
	private String image;
	@JSONField(format = "yyyy-MM-dd")
	private Date rtime;
	public User(){
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getSex() {
		return sex;
	}

	public String getEmail() {
		return email;
	}

	public Integer getLevel() {
		return level;
	}

	public Integer getExp() {
		return exp;
	}

	public String getImage() {
		return image;
	}

	public String getRtime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(rtime);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}

}
