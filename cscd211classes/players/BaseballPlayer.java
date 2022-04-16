//Brandon Soncarty

package lab9.cscd211classes.players;

public class BaseballPlayer extends Player implements Cloneable{

    protected double batAvg;

    //EVC
    public BaseballPlayer(String name, String ssn, int salary, String position, double batAvg){

        super(name, ssn, salary, position);

        if(batAvg < 0){
            throw new IllegalArgumentException("The batting average is less than 0.");
        }
        this.batAvg = batAvg;
    }

    //add batAvg
    @Override
    public String toString(){
        return super.toString() + " Batting Avg: " + batAvg + "\n";
    }

    //cloning using casting and super clone
    public BaseballPlayer clone() throws CloneNotSupportedException{
        return (BaseballPlayer) super.clone();
    }
}
