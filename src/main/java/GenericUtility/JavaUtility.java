package GenericUtility;

import java.util.Random;

public class JavaUtility {

	public int getRandomNo()
	{
	Random ram=new Random();
	int random=ram.nextInt(4000);
	return random;
	
	}
}
