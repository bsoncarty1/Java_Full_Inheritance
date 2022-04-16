//Brandon Soncarty

package lab9.cscd211comparators;

import lab9.cscd211classes.Team;

import java.util.Comparator;

public class TeamPayrollComparator implements Comparator<Team> {

    public TeamPayrollComparator(){}

    //compare teams based on payroll
    public int compare(Team t1, Team t2){
        if(t1 == null || t2 == null){
            throw new IllegalArgumentException("One or both of the teams are null.");
        }

        return Double.compare(t1.getPayroll(), t2.getPayroll());
    }
}
