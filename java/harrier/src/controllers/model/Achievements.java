package controllers.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name=("achievements"))
public class Achievements {
	@Id
	@Column(name=("id"))
    private final int id;
	@Column(name=("kills"))
    private final int kills;
	@Column(name=("duels"))
    private final int duels;
	@Column(name=("loses"))
    private final int loses;
	@Column(name=("wins"))
    private final int wins;




    public Achievements() {
        this.id = -1;
        this.kills = -1;
        this.duels = -1;
        this.loses = -1;
        this.wins = -1;
    }

    public Achievements(int id, int kills, int duels, int loses, int wins) {
    	this.id = id;
        this.kills = kills;
        this.duels = duels;
        this.loses = loses;
        this.wins = wins;
        
    }

    public int getId() {
        return id;
    }


   

    public int getKills() {
        return kills;
    }
    public int getDuels() {
        return duels;
    }
    public int getloses() {
        return loses;
    }
    public int getWins() {
        return wins;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Achievements achieve = (Achievements) o;

        if (id != achieve.id) return false;
        if (kills != achieve.kills) return false;
        if (duels != achieve.duels) return false;
        if (loses!= achieve.loses) return false;
        
        return (wins != achieve.wins) ;
        

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + kills;
        result = 31 * result + duels;
        result = 31 * result + loses;
        result = 31 * result + wins;
        return result;
    }

    @Override
    public String toString() {
        return "Achieve{" +
                "id='" + id + '\'' + 
                ", kills='" + kills + '\'' +
                ", duels='" + duels + '\'' +
                ", loses='" + loses + '\'' +
                ", wins='" + wins + '\'' + "\n"+
                '}';
    }
}
