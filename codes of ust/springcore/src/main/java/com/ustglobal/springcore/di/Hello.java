package com.ustglobal.springcore.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hello {
private String msg;

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}
@PostConstruct
public void init() {
	System.out.println("Init method excuting from Hello");
}
@PreDestroy
public void destroy() {
	System.out.println("Destroy method excuting from Hello");
}
}
