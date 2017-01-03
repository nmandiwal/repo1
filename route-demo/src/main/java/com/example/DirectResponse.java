package com.example;

import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonGetter;

@ResponseBody
public class DirectResponse {
private int depSid;
private int arrSid;
private boolean directBusRoute;

@JsonGetter("dep_sid")
public int getDepSid() {
	return depSid;
}
public void setDepSid(int depSid) {
	this.depSid = depSid;
}

@JsonGetter("arr_sid")
public int getArrSid() {
	return arrSid;
}
public void setArrSid(int arrSid) {
	this.arrSid = arrSid;
}

@JsonGetter("direct_bus_route")
public boolean getDirectBusRoute() {
	return directBusRoute;
}
public void setDirectBusRoute(boolean directBusRoute) {
	this.directBusRoute = directBusRoute;
}
}
