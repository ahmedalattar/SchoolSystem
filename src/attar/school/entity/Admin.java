package attar.school.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Admin {
	@NotNull(message = "AdminName is required")
	@Pattern(regexp = "(admin)", message = "wrong username")
	private String username;
	@NotNull(message = "Password is required")
	@Pattern(regexp = "(admin)", message = "wrong password")
	private String password;

	public Admin() {

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

}
