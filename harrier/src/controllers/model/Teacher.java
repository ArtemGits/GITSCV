package controllers.model;



public class Teacher {
    private final int id;
    private  String old_name;
    private  String new_name;
    private  String home;
    private  int age;
    
    public Teacher() {
        this.id = -1;
        this.old_name = "";
        this.new_name = "";
        this.home="";
        this.age=0;
    }

    public Teacher(int id, String old_name, String new_name, String home) {
        this.id = id;
        this.old_name = old_name;
        this.new_name = new_name;
        this.home = home;
       
    }

    public int getId() {
        return id;
    }


    public String getNew_name() {
        return new_name;
    }

    public String getOld_name() {
        return old_name;
    }

    public String getHome() {
        return home;
    }

    
    public void setOld_name(String old_name) {
        this.old_name = old_name;
    }
    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }

    public void setHome(String home) {
        this.home = home;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher Teacher = (Teacher) o;

        if (id != Teacher.id) return false;
        if (new_name != Teacher.new_name) return false;
        if (old_name != Teacher.old_name) return false;
        if (home != Teacher.home) return false;
		return false;
        
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (new_name != null ? new_name.hashCode() : 0);
        result = 31 * result + (old_name != null ? old_name.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", new_name=" + new_name +
                ", old_name='" + old_name + '\'' +
                ", home='" + home + '\'' + "\n"+
                '}';
    }
}
