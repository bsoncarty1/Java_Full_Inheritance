//Brandon Soncarty

package lab9.cscd211methods;

import java.util.*;
import lab9.cscd211classes.*;
import lab9.cscd211classes.players.*;

public class CSCD211Lab9Methods
{	

   public static void fillArrayList(final Scanner fin, final ArrayList<Team>myTeam)throws CloneNotSupportedException
   {
      if(fin == null || myTeam == null){
         throw new IllegalArgumentException("The scanner or ArrayList are null.");
      }

      String teamCity, teamName, playerName, ssn, position, stats, type;
      String[] array;
      int numPlayers, salary, numTeams;
      Player[] playerArray;

      while(fin.hasNext()){
         teamCity = fin.nextLine().trim();
         numTeams = Integer.parseInt((fin.nextLine()).trim());
         for(int x = 0; x < numTeams; x++){
            array = (fin.nextLine()).trim().split(",");
            type = array[0].trim().toLowerCase();
            teamName = array[1].trim();
            numPlayers = Integer.parseInt((fin.nextLine()).trim());

            playerArray = new Player[numPlayers];
            for(int y = 0; y < playerArray.length; y++){
               array = fin.nextLine().trim().split(",");
               playerName = array[0].trim();
               ssn = array[1].trim();
               salary = Integer.parseInt(array[2].trim());
               position = array[3].trim();
               stats = array[4].trim();

               if(type.equals("baseball")){
                  playerArray[y] = new BaseballPlayer(playerName, ssn, salary, position, Double.parseDouble(stats));
               }else if(type.equals("football")){
                  playerArray[y] = new FootballPlayer(playerName,ssn,salary,position, Integer.parseInt(stats), Integer.parseInt(array[5].trim()));
               }else{
                  playerArray[y] = new HockeyPlayer(playerName,ssn,salary,position,Integer.parseInt(stats));
               }
            }
            myTeam.add(new Team(teamCity,teamName,playerArray));
         }
      }
      myTeam.trimToSize();
   }// end createAndFill
   

   public static int menu(final Scanner kb)
   {
      if (kb == null)
         throw new IllegalArgumentException("Error Precond: Scanner cannot be null - menu");
         
      int choice;
      
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print all Teams");
         System.out.println("2) Sort all Teams by city and team name");
         System.out.println("3) Sort all Teams by Payroll");
         System.out.println("4) Exit program");
         System.out.print("Choice --> ");
         choice = kb.nextInt();
         kb.nextLine();
      } while (choice < 1 || choice > 4);
      
      return choice;  
   }// end menu
   
}// end class