package controllers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name = ("id"))
    private final int id;
	@Column(name=("id_student"))
    private final int id_student;
	@Column(name=("id_teacher"))
    private final int id_teacher;

    public Student() {
        this.id = -1;
        this.id_student = -1;
        this.id_teacher = -1;
    }

    public Student(int id, int id_student, int id_teacher) {
        this.id = id;
        this.id_student = id_student;
        this.id_teacher = id_teacher;
        
    }

    public int getId() {
        return id;
    }

    
   

    public int getId_student() {
        return id_student;
    }
    public int getId_teacher() {
        return id_teacher;
    }


   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student stud = (Student) o;

        if (id != stud.id) return false;
        if (id_student != stud.id_student) return false;
        return (id_teacher != stud.id_teacher) ;
        

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_student;
        result = 31 * result + id_teacher;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + "',"
             +  "id_student='" + id_student + '\'' + "\n"
             + " id_teacher='" + id_teacher + '\'' + "\n"+
                '}';
    }
}
