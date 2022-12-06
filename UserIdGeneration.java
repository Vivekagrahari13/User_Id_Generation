package technicaltrain;
import java.util.*;

public class UserIdGeneration 
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		
		String firstname=sc.nextLine();   
		String lastname=sc.nextLine();
		
		int pin_code=sc.nextInt();
		int n=sc.nextInt();
		
		String User_Id=Generate_UserId(firstname,lastname,pin_code,n);
		System.out.println("Generated Id: "+User_Id);
	}
	// Method to just create user id using their name, pin(int range) and any number (0 to length of pin)
	static String Generate_UserId(String f_name,String l_name,int pin, int n)
	{
		int l1=f_name.length();
		int l2=l_name.length();
		
		// Getting the string as which is smaller and which one is longer in length first name and last name 
		String smaller=null;
		String longer=null;
		
		if(l1<l2)
		{
			smaller=f_name;
			longer=l_name;
		}
		else if(l1>l2)
		{
			smaller=l_name;
			longer=f_name;
		}
		else 
		{
			if(f_name.compareTo(l_name)<1)
			{
				smaller=f_name;
				longer=l_name;
				}
			else 
			{
				smaller=l_name;
				longer=f_name;
			}
		}
	
	StringBuilder userId=new StringBuilder();  // String to store the Generated Id
	// Both appends line:- 
	// First: Appending last character of smaller string 
	// Second: Appending entire longer in first
	userId.append(smaller.charAt(smaller.length()-1));   
	userId.append(longer);
	
	//After that Append the pin as per the instruction
	for(int i=0;i<userId.length();i++)
	{
		if(Character.isUpperCase(userId.charAt(i)))
			userId.setCharAt(i,Character.toLowerCase(userId.charAt(i)));
		else
			userId.setCharAt(i,Character.toUpperCase(userId.charAt(i)));
	}
	userId.append(String.valueOf(pin).charAt(n-1));
	userId.append(String.valueOf(pin).charAt(String.valueOf(pin).length()-n));
	// Return the generated key i.e. user id
	return userId.toString();
	}
}
