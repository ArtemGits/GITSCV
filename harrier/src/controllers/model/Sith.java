package controllers.model;


 

public class Sith {
    private final int id;
   
    private final String rang;
    private final int id_status;
    private final String old_name;
    private final String new_name;
    private final int age;
    private final String home;
    private final boolean canon;
    private final boolean history;

    public Sith() {
        this.id = -1;
        this.id_status = -1;
        this.rang = null;
        this.old_name = null;
        this.new_name = null;
        this.age = 0;
        this.home = null;
        this.canon = false;
        this.history = false;
    }

    public Sith(int id, String rang, int id_status, String old_name, String new_name, int age, String home, boolean canon, boolean history) {
    	 this.id = id;
         this.id_status = id_status;
         this.rang = rang;
         this.old_name = old_name;
         this.new_name = new_name;
         this.age = age;
         this.home = home;
         this.canon = canon;
         this.history = history;
    }

    public int getId() {
        return id;
    }

    public String getOld_name() {
        return old_name;
    }

    public String getNew_name() {
        return new_name;
    }

    public String getRang() {
        return rang;
    }

    public String getHome() {
        return home;
    }

    public int getAge() {
        return age;
    }
    public boolean getCanon() {
        return canon;
    }
    public boolean getHistory() {
        return history;
    }
    
    public int getId_status() {
        return id_status;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sith sith= (Sith) o;

        if (id != sith.id) return false;
        if (id_status != sith.id_status) return false;
        if (age != sith.age) return false;
        if (canon != sith.canon) return false;
        if (history != sith.history) return false;
        if (old_name != null ? !old_name.equals(sith.old_name) : sith.old_name != null) return false;
        if (new_name != null ? !new_name.equals(sith.new_name) : sith.new_name != null) return false;
        if (home != null ? !home.equals(sith.home) : sith.home != null) return false;
        return rang != null ? rang.equals(sith.rang) : sith.rang == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rang != null ? rang.hashCode() : 0);
        result = 31 * result + (old_name != null ? old_name.hashCode() : 0);
        result = 31 * result + (new_name != null ? new_name.hashCode() : 0);
        result = 31 * result + (home != null ? home.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + id_status;
        return result;
    }

    @Override
    public String toString() {
        return "sith{" +
                "id=" + id +
                "id_status=" + id_status +'\'' +
                ", old_name='" + old_name+ '\'' +
                ", new_name='" + new_name + '\'' +
                ", rang='" + rang + '\'' +
                ", home='" + home + '\'' +
                ", canon='" + canon + '\'' +
                ", history='" + history + '\'' +
                ", age=" + age +
                '}';
    }
}
