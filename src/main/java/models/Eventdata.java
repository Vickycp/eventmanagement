package models;

import java.io.InputStream;

public class Eventdata {
  private String username;
  private String title;
  private String start;
  private String end;
  private String decription=null;
  private String file=null;
  private String status;
  private int id;
  private InputStream fileip;
public Eventdata(String username, String title, String start, String end, String decription, String file, String status,
		int id, InputStream fileip) {
	super();
	this.username = username;
	this.title = title;
	this.start = start;
	this.end = end;
	this.decription = decription;
	this.file = file;
	this.status = status;
	this.id = id;
	this.fileip = fileip;
}
public Eventdata(String username, String title, String start, String end, String status) {
	super();
	this.username = username;
	this.title = title;
	this.start = start;
	this.end = end;
	this.status = status;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Eventdata(String title, String start, String end, String decription, String file, String status, int id,
		InputStream fileip) {
	super();
	this.title = title;
	this.start = start;
	this.end = end;
	this.decription = decription;
	this.file = file;
	this.status = status;
	this.id = id;
	this.fileip = fileip;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}
public String getDecription() {
	return decription;
}
public void setDecription(String decription) {
	this.decription = decription;
}
public String getFile() {
	return file;
}
public void setFile(String file) {
	this.file = file;
}
public Eventdata(int id,String username, String title, String start, String end, String decription, String file,String status) {
	super();
	this.username = username;
	this.title = title;
	this.start = start;
	this.end = end;
	this.decription = decription;
	this.file = file;
	this.status=status;
	this.id=id;
}
public Eventdata() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public InputStream getFileip() {
	return fileip;
}
public void setFileip(InputStream fileip) {
	this.fileip = fileip;
}

  
}
