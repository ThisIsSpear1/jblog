package com.javaex.vo;

public class CategoryVo {
private int cateNo;
private String id;
private String description;
private String cateName;
private String regDate;
private int count;


public CategoryVo() {
}

public CategoryVo(int cateNo, String id, String description, String cateName, String regDate, int count) {
	this.cateNo = cateNo;
	this.id = id;
	this.description = description;
	this.cateName = cateName;
	this.regDate = regDate;
	this.count = count;
}

public CategoryVo(int cateNo, String id, String description, String cateName, String regDate) {
	this.cateNo = cateNo;
	this.id = id;
	this.description = description;
	this.cateName = cateName;
	this.regDate = regDate;
}

public int getCateNo() {
	return cateNo;
}
public void setCateNo(int cateNo) {
	this.cateNo = cateNo;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCateName() {
	return cateName;
}
public void setCateName(String cateName) {
	this.cateName = cateName;
}
public String getRegDate() {
	return regDate;
}
public void setRegDate(String regDate) {
	this.regDate = regDate;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
@Override
public String toString() {
	return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", description=" + description + ", cateName=" + cateName
			+ ", regDate=" + regDate + ", count=" + count + "]";
} 


}
