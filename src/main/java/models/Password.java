package models;

public class Password {
	private String username;
	private String newpassword;
	  private String confirmpassword;

  public Password(String username, String newpassword, String confirmpassword) {
		super();
		this.username = username;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getNewpassword() {
	return newpassword;
}

public void setNewpassword(String newpassword) {
	this.newpassword = newpassword;
}

public String getConfirmpassword() {
	return confirmpassword;
}

public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}

public Password() {
	super();
	
}
  

  
}
