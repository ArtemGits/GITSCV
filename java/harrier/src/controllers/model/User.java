package controllers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import items.Items;

@Entity
@Table(name="USER_TABLE")
public class User {
	boolean valid;
//	@OneToOne
//	private Items item;
//	public Items getItem() {
//		return item;
//	}
//	public void setItem(Items item) {
//		this.item = item;
//	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(Boolean val) {
		valid = val;
	}
	private String name;
	@Id
	private String email;
	private String password;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}