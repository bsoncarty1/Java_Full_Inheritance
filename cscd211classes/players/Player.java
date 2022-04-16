//Brandon Soncarty

package lab9.cscd211classes.players;

public abstract class Player implements Cloneable{
    //protected variables
    protected String name;
    protected String position;
    protected int salary;
    protected String ssn;

    //EVC
    protected Player(String name, String ssn, int salary, String position){
        if(name == null || name.equals("") || ssn == null || ssn.equals("") || position == null || position.equals("")){
            throw new IllegalArgumentException("One or more of the strings are null or empty.");
        }

        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public String getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    //basic toString
    @Override
    public String toString(){
        return this.name + " " + this.ssn + " " + this.salary + " " + this.position;
    }

    //cast as player and call super clone
    @Override
    public Player clone() throws CloneNotSupportedException{
        return (Player) super.clone();
    }
}
