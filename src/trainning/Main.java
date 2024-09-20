package trainning;


public class Main 
{

    public static void main(String[] args) 
    {
        //Palindrome word or not
	String word = "madam" ;
        boolean isPalindrome = Manipulation.isPalindrome(word) ;
        if(isPalindrome == true)
        {
        	System.out.println(word + " is a Palindrome word.") ;
        }
        else
        {
        	System.out.println(word + " isn't a Palindrome word.") ;
        }

        //Anagrams or not
        String wordOne = "listen" ;
        String wordTwo = "silent" ;
        boolean isAnagram = Manipulation.isAnagrams(wordOne, wordTwo) ;
        if(isAnagram == true)
        {
        	System.out.println(wordOne + " and " + wordTwo + " are Anagram words.") ;
        }
        else
        {
        	System.out.println(wordOne + " and " + wordTwo + " aren't Anagram words.") ;
        }
        
        //Variable Name or not 
        String varName = "myVariable" ;
        boolean isVariable = Manipulation.isVariableName(varName) ;
        if(isVariable == true )
        {
        	System.out.println(varName + " is a possible variable name.") ;
        }
        else
        {
        	System.out.println(varName + " isn't a possible variable name.") ;
        }
        
        //convert to Camel case then Variable Name or not 
        String S = "my variable name" ;
        System.out.println(Manipulation.getCamelCaseConventions(S)) ;
        
        //convert to Snake case
        String Camel_S = "myVariableName" ;
        System.out.println(Camel_S + " becomes " + Manipulation.namingConventions(Camel_S)) ;
        
        //generate random names
    	String[] names = {"Rami", "Ahmad", "Sameh"} ;  //names
    	int n = 3 ;  //number of names
    	
    	System.out.println("names: ") ;
    	for(int i = 0 ; i < n ; i++)
    	{
    		System.out.println(names[i]) ;
    	}
    	
    	//Call getNames 
        try 
        {
            String[] generatedNames = Manipulation.getNames(names , n) ;

            //Print the generated names
            System.out.println("the generated namse:") ;
            for (String name : generatedNames) 
            {
                System.out.println(name) ;
            }
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println(e.getMessage()) ;
        }
    }
}
