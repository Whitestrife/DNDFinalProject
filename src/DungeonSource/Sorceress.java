package DungeonSource;

import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);


    }//end constructor

//-----------------------------------------------------------------
	public void increaseHitPoints()
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		adjustHitPoints(-hPoints);
		System.out.println(name + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent, Scanner scan)
	{
		super.battleChoices(opponent, scan);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Increase Hit Points");
		    if(super.getItemBag().itemBag.isEmpty()) {
		    	
		    }else {
		    	System.out.println("3. Use an Item");
		    }
		    System.out.print("Choose an option: ");
		    switch (scan.nextInt())
		    {
			    case 1: attack(opponent);
			    	setTurns(-1);
			        break;
			    case 2: increaseHitPoints();
			    	setTurns(-1);
			        break;
			    case 3: useItem(this, opponent);
			    	System.out.println("Using an item is a free action!\n");
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch
		    
			if (getTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getTurns());

		} while(getTurns() > 0  && hitPoints > 0 && opponent.getHitPoints() > 0);

    }//end overridden method

}//end class