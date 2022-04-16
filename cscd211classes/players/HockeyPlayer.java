//Brandon Soncarty

package lab9.cscd211classes.players;

public class HockeyPlayer extends Player implements Cloneable{

    protected int jerseyNumber;

    //EVC
    public HockeyPlayer(String name, String ssn, int salary, String position, int jerseyNumber){
        super(name, ssn, salary, position);

        if(jerseyNumber < 0){
            throw new IllegalArgumentException("The jersey number can't be less than 0.");
        }

        this.jerseyNumber = jerseyNumber;
    }

    //add jerseyNumber
    @Override
    public String toString(){
        return super.toString() + " " + jerseyNumber + "\n";
    }

    //cast as HockeyPlayer and call super clone
    public HockeyPlayer clone() throws CloneNotSupportedException{
        return (HockeyPlayer) super.clone();
    }
}
