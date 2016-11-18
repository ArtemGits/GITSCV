package controllers.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=("teacher"))
public class Teacher {
	@Id
	@Column(name=("id"))
    private final int id;
	
	@Column(name=("sith_id"))
    private final int sith_id;
   
    
    public Teacher() {
        this.id = -1;
        this.sith_id = -1;
    }

    public Teacher(int id,int stage) {
        this.id = id;
       this.sith_id = stage;
       
    }

    public int getId() {
        return id;
    }
    
    public int getSith_id() {
        return sith_id;
    }


   

    
   


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher Teacher = (Teacher) o;

        if (id != Teacher.id) return false;
        if(sith_id != Teacher.sith_id) return false;
		return false;
        
    }

    @Override
    public int hashCode() {
        int result = id;
        result = result * 31 + sith_id;
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + "'" +
                "sith_id='" + sith_id + "'" +
                '}';
    }
}
