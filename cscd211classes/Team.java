//Brandon Soncarty

package lab9.cscd211classes;

import java.util.*;
import lab9.cscd211interfaces.*;
import lab9.cscd211classes.players.*;

/**
 * The Team class that defines the information about a team.
 */
public class Team implements Taxable, Payroll, Comparable<Team>
{
   
   protected String city;
   protected String teamName;
   protected int payroll;
   protected ArrayList<Player> players;

   //EVC
   public Team(final String city, final String teamName, final Player[] players) throws CloneNotSupportedException{
      if(city == null || city.equals("") || teamName == null || teamName.equals("")){
         throw new IllegalArgumentException("The strings are null or empty.");
      }
      if(players == null || players.length <= 0){
         throw new IllegalArgumentException("The array is null or <= 0.");
      }
      this.city = city;
      this.teamName = teamName;
      this.players = new ArrayList<Player>(players.length);
      for(Player p : players){
         this.players.add(p.clone());
      }
      this.players.trimToSize();
      this.payroll = calculatePayroll();
   }

   public String getTeamName(){
      return this.teamName;
   }

   public ArrayList<Player> getPlayers() {
      return players;
   }

   public String getCity(){
      return this.city;
   }

   public int getPayroll() {
      return payroll;
   }

   //toString to print information
   @Override
   public String toString(){
      return getCity() + " - " + getTeamName() + "\n" +
              "Payroll: " + getPayroll() + "\n" +
              "Taxes: " +  this.calculateTaxes() + "\n" +
              "Player NAME \t SSN \t SALARY \t POSITION \t STATS \t NUMBER \n" +
              "_______________________________________________________________\n" +
              this.getPlayers();
   }

   //calculating taxes using the taxable interface
   public double calculateTaxes(){
      double tax = 0;
      for(int i = 0; i < players.size(); i++){
         if(players.get(i).getSalary() > 250000){
            tax += players.get(i).getSalary() * BASE_TAX_RATE;
         }else{
            tax += players.get(i).getSalary() *(BASE_TAX_RATE -.1);
         }
      }
      return tax;
   }

   //calculating payroll using the payroll interface
   public int calculatePayroll(){
      int sum = 0;
      for(int i = 0; i < players.size(); i++){
         sum += players.get(i).getSalary();
      }
      return sum + BASE_PAYROLL;
   }

   //comparing city and teamName
   @Override
   public int compareTo(Team pi){
      if(pi == null){
         throw new IllegalArgumentException("The obj is null.");
      }

      if(this.city.compareTo(pi.city) == 0){
         return this.teamName.compareTo(pi.teamName);
      }
      return this.city.compareTo(pi.city);

   }
}// end class