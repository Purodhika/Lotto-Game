import java.security.SecureRandom;
import javax.swing.JOptionPane;

public class Lotto
{
	private int[] winNumbers;
	private int turns;
	private int sum;
	private boolean stillPlaying;
	
	//creating a constructor
	public Lotto()
	{
		winNumbers = generateWinNumbers();
		turns= 0;
		sum = winNumbers[0] + winNumbers[1] + winNumbers[2];
		stillPlaying= true;
	}
	
	public int[] getWinNumbers()
	{
		return winNumbers;
	}
	
	public void setWinNumbers(int[] winNumbers)
	{
		this.winNumbers=winNumbers;
	}
	
	public int getTurns()
	{
		return turns;
	}
	
	public void setTurns(int turns)
	{
		this.turns=turns;
	}
	
	public int getSum()
	{
		return sum;
	}
	
	public void setStillPlaying(boolean stillPlaying)
	{
		this.stillPlaying = stillPlaying;
		
	}


	public void guessSum()
	
	{
		while(turns<5 && stillPlaying)
		{
			setTurns(getTurns() + 1);
			
			String message = String.format("Guess a number between 3 and 27.", getTurns());
			String guess = JOptionPane.showInputDialog(null, message);
			verifyGuess(Integer.parseInt(guess));
		}
	}
	
	private void verifyGuess(int guess)
	
	{
		if (guess == getSum())
				{
			
			JOptionPane.showMessageDialog(null, "Congratulations! You Won.");
			setStillPlaying(false);
				}
		
		else 
		
			if(turns<5) 
			{
				String message = String.format("Wrong! You have %d guesses left", 5-turns);
				JOptionPane.showMessageDialog(null, message);
			}
			
		
		
		else
		{
			String message = String.format("Alas! You ran out of total guesses. The correct sum was %d", getSum());
			JOptionPane.showMessageDialog(null, message);
		}
		
	  }
	
	public String showWinNumbers()
	{
		//array instance variable to hold 3 random numbers
		int[] winNumbers = getWinNumbers();
		return String.format("%d, %d,%d", winNumbers[0], winNumbers[1], winNumbers[2]); 
		
	}
	
	private int[] generateWinNumbers()
	{
		int[] randomNumbers = new int[3];
		
		//creates an instance of SecureRandom class
		SecureRandom r1 = new SecureRandom();
		
		for (int i=0; i<3; i++)
		{
			//generates random integers
			int r2 = r1.nextInt(9)+1;
			randomNumbers[i]= r2;
		}
		
		return randomNumbers;
		
	}
	
}
