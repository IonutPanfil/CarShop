package reprezentanta;

public class Conturi {
	private int idCont;
	private String username;
	private String password;
	private String email;
	private String tip;
	
	@Override
	public String toString() {
		return "idCont: " + idCont + "\t" +
				"username: " + username + "\t" +
				"password: " + password + "\t" +
				"email: " + email + "\t" +
				"tip: " + tip + "\n";
	}

	public int getIdCont() {
		return idCont;
	}

	public void setIdCont(int idCont) {
		this.idCont = idCont;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
