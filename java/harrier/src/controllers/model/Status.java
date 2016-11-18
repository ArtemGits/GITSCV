package controllers.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name=("status"))
public class Status {
	@Id
	@Column(name=("id"))
    private final int id;
	@Column(name=("status"))
    private final String status;

    public Status() {
        this.id = -1;
        this.status = "";
    }

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
        
    }

    public int getId() {
        return id;
    }


   

    public String getStatus() {
        return status;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status Status = (Status) o;

        if (id != Status.id) return false;
        return (status != null ? !status.equals(Status.status) : Status.status != null) ;
        

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id='" + id +
                "', status='" + status + '\'' + "\n"+
                '}';
    }
}
