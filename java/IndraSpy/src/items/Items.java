package items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import controller.User;

@Entity (name="ITEM_TABLE")
public class Items {
	@GeneratedValue
	@Id
	private int id;

	private String car,bike,cell,dob;

	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	private String choice,net,os;
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getCar() {

		    return car;
    }
    public void setCar(String car) {
        this.car = car;
    }
    public String getBike() {
        return bike;
    }
    public void setBike(String bike) {
        this.bike = bike;
    }
    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }
    public String getNet() {
        return net;
    }
    public void setNet(String net) {
        this.net = net;
    }
    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }

}
