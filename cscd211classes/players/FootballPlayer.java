//Brandon Soncarty

package lab9.cscd211classes.players;

public class FootballPlayer extends Player implements Cloneable{

    protected int jerseyNumber;
    protected int td;

    //EVC
    public FootballPlayer(String name, String ssn, int salary, String position, int td, int jerseyNumber){
        super(name, ssn, salary, position);

        if(td < 0){
            throw new IllegalArgumentException("Touchdowns can't be less than 0.");
        }
        if(jerseyNumber < 0){
            throw new IllegalArgumentException("The jersey number can't be less than 0.");
        }

        this.td = td;
        this.jerseyNumber = jerseyNumber;
    }

    //add td and jerseyNumber
    @Override
    public String toString(){
        return super.toString() + "\t" + "Touchdowns: " + td + "\t" + jerseyNumber + "\n";
    }

    //cast as football player and call super clone
    @Override
    public FootballPlayer clone() throws CloneNotSupportedException{
        return (FootballPlayer) super.clone();
    }
}
