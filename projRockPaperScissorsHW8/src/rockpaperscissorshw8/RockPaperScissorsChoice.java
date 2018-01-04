//Assignment: projRockPaperScissorsHW8
//Program: RockPaperScissorsChoice
//Created: Jul 13, 2016
//Author: Trevor Dick
/**
 * 
 */
package rockpaperscissorshw8;

import javax.swing.ImageIcon;


/**
 * @author Trevor Dick
 *rock, paper scissors enum 
 * created two enums, one with rock, paper and scissors; the other for the results : when tie and lose
 * declare Image icon
 */
public enum RockPaperScissorsChoice {
	//images thanks to Kyle Przelenski @ Master Crafted Gaming: http://rerollones.blogspot.com/2016/04/the-rock-paper-scissors-of-kings-of-war.html
    ROCK(new ImageIcon(RockPaperScissorsChoice.class.getResource("rock.png"))), 
    PAPER(new ImageIcon(RockPaperScissorsChoice.class.getResource("paper.png"))), 
    SCISSORS(new ImageIcon(RockPaperScissorsChoice.class.getResource("scissors.png")));

	public enum Result {WIN, LOSE, TIE};
	
	private ImageIcon imgChoice;
	
	/**
	 * getter for ImageIcon
	 * @return the image choice
	 */
	public ImageIcon getImageIcon() {
    	return imgChoice;
    }
	
	/**
	 * parameterized method
	 * @param imgChoice the image choice of type ImageIcon
	 */
    private RockPaperScissorsChoice(ImageIcon imgChoice) {
    	this.imgChoice = imgChoice;
    }
    
    /**
     * non-parameterized method of RockPaperScissorsChoice type
     * @return returns integers one, two, or three for use of randomly selecting an image
     */
    public static RockPaperScissorsChoice randChoice() {
        return values()[ (int) (Math.random() * values().length) ];
    } 
    
    /**
     * non-parameterized method
     * @return results of the enum: win, lose, tie
     */
    //this implementation should have the correct logic but it fails a lot of the time to decide if the player wins.  
    public static Result evaluate() {
    	if ( ( (ROCK != RockPaperScissorsChoice.randChoice()) & (PAPER != RockPaperScissorsChoice.randChoice()) & (RockPaperScissorsChoice.randChoice() == SCISSORS)  ) |
        	 ( (PAPER != RockPaperScissorsChoice.randChoice()) & (SCISSORS != RockPaperScissorsChoice.randChoice()) & (RockPaperScissorsChoice.randChoice() == ROCK) ) |
        	 ( (SCISSORS != RockPaperScissorsChoice.randChoice()) & (ROCK != RockPaperScissorsChoice.randChoice()) & (RockPaperScissorsChoice.randChoice() == PAPER) ) ) {
        	return Result.WIN;
        } else {
        	if ( ROCK == RockPaperScissorsChoice.randChoice() | 
        			PAPER == RockPaperScissorsChoice.randChoice() |
        			SCISSORS == RockPaperScissorsChoice.randChoice() ) {
        		return Result.TIE;
        	} else {
            	return Result.LOSE;
            }
        } 
		
    	
    }

    
}