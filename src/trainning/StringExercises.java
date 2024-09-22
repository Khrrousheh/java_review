package trainning;

public class  StringExercises 
{
    public static boolean isPalindrome(String word)
    {
        /*
         * TODO: palindrome
         * Palindrome is the words that you can read from right to left and left to right
         * if the word is not a Palindrome print the index
         */
        int len = word.length() ;  //Get the length of the word
        for (int i = 0 ; i < len / 2 ; i++)  //Loop through the first half of the word
        {
            if (word.charAt(i) != word.charAt(len - i - 1))  //Compare the character at position 'i' (from the beginning of the word) with the character at the mirrored position 'len - i - 1' (from the end of the word)
            {
                return false ;  //If characters don't match, it's not a palindrome, return false
            }
        }
        return true ;  //If all the characters match, return true(the word is a palindrome)
    }

    public static boolean isAnagrams(String wordOne, String wordTwo)
    {
        /*
         * TODO: anagrams
         * anagrams is a word or phrase formed by rearranging the letters of a different word or phrase
         *
        */
    	//convert both words to lowercase to ignore case differences
    	wordOne = wordOne.toLowerCase() ;
    	wordTwo = wordTwo.toLowerCase() ;
    	
        if (wordOne.length() != wordTwo.length())  //Check if both words have the same length 
        {
            return false ;  //if not, they can't be anagrams
        }
        
        /*first way*/
        //char[] firstWord = wordOne.toCharArray() ;  //Convert the first word to a character array
        //char[] secondWord = wordTwo.toCharArray() ;  //Convert the second word to a character array
        //Arrays.sort(firstWord) ;  //Sort the character array of the first word alphabetically
        //Arrays.sort(secondWord) ;  //Sort the character array of the second word alphabetically
        //return Arrays.equals(firstWord , secondWord) ;  //Compare the two sorted character arrays; if they are equal, the words are anagrams
        
        //Create an array of size 26 (for each letter of the alphabet) to count occurrences
        int[] charCount = new int[26] ;  //This array will track how many times each letter appears in the words
        
        for (int i = 0 ; i < wordOne.length() ; i++)  //Loop through each character in both words
        {
            //Increment the count for the character in wordOne in the charCount array
            charCount[wordOne.charAt(i) - 'a']++ ;

            //Decrement the count for the character in wordTwo in the charCount array
            charCount[wordTwo.charAt(i) - 'a']-- ;
        }
        /*
         * 'a' has an ASCII value of 97 so Subtracting 'a' from the character gives an index between 0 and 25, which corresponds to letters 'a' to 'z'
        */
        //If all counts are 0, then both words have the same character frequencies
        for (int count : charCount) 
        {
            if (count != 0) 
            {
                return false ;  //If there's a mismatch, the words are not anagrams
            }
        }

        return true ;  //If all counts are 0, the words are anagrams
    }

    public static boolean isVariableName(String str)
    {
        /*
         *  TODO: Variable name
         * all the programming languages have a rules
         * in this task you will take a string
         * return a boolean indicate if that string is can be a variable name
         *
         */
        /*A valid variable name cannot be null or empty, must start with a letter (A-Z or a-z) or an underscore (_) and All characters after the first must be letters, digits, or underscores.*/
    	
    	//Check if the string is empty or null
        if (str == null || str.isEmpty()) 
        {
            return false ;
        }

        /*first way*/
        //Check if the first character is a letter or underscore
        //if (!Character.isLetter(str.charAt(0)) && str.charAt(0) != '_')
        //{
            //return false ;
        //}
        //Check the rest of the string for validity
        //for (int i = 1 ; i < str.length() ; i++) 
        //{
            //char c = str.charAt(i) ;
            //if (!Character.isLetterOrDigit(c) && c != '_') 
            //{
                //return false ;  //If the character is not a letter, digit, or underscore, return false
            //}
        //}
        
        //checks if a character can be the start of a valid Java identifier which includes letters and underscores using isJavaIdentifierStart function
        if (!Character.isJavaIdentifierStart(str.charAt(0))) 
        {
        	return false ;
        }

        //Check the rest of the string for validity in the middle and the end 
        for (int i = 1 ; i < str.length() ; i++) 
        {
            if (!Character.isJavaIdentifierPart(str.charAt(i))) 
            {
                return false ;  //If any character is not valid for a Java identifier part, return false
            }
        }
        //isJavaIdentifierPart function checks if the character is valid for any part of a Java variable name including:Letters,Digits,Underscores and Other valid characters that can be used in identifiers but not as the first character

        //If all checks pass, return true
        return true ;
    }

    public static String getCamelCaseConventions(String str)
    {
        /*
         * TODO: camel case
         * in java we follow the camel name variable convention
         * so in this exercise you will get a string and convert it into camel case then check if it can be a variable name
         *
         */
        //Trim leading and trailing spaces
        str = str.trim() ;
        
        //If the string is empty, return an empty string
        if (str.isEmpty()) 
        {
            return "" ;
        }

        //Split the string into words using spaces as delimiters
        String[] words = str.split("\\s+");
        
        //Convert the first word to lowercase and initialize the StringBuilder with it
        StringBuilder camelCaseStr = new StringBuilder(words[0].toLowerCase());

        //Loop through the rest of the words and capitalize the first letter of each
        for (int i = 1 ; i < words.length ; i++) 
        {
            String word = words[i] ;
            camelCaseStr.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()); //Capitalize first letter and Add the rest of the word in lowercase
        }

        String camelCaseResult = camelCaseStr.toString() ;  //Convert the StringBuilder to a string
        System.out.println(str + " becoms " + camelCaseResult) ;  //Print the original string and its camel case result

        //Check if the camelCase string is a valid variable name
        if (isVariableName(camelCaseResult)) 
        {
            return camelCaseResult + " is a valid variable name." ;
        } 
        else 
        {
            return camelCaseResult + " is NOT a valid variable name." ;
        }
    }

    public static String namingConventions(String str)
    {
        /*
         *
         * every programming languages have a name conventions
         * convert the string from camel case convention to snake case convention
         */
        StringBuilder snakeCaseStr = new StringBuilder() ;  //Initialize a StringBuilder to build the snake case string

        //Loop through each character in the input string
        for (int i = 0 ; i < str.length() ; i++) 
        {
            char currentChar = str.charAt(i) ;

            //If the character is uppercase, we append an underscore and convert it to lowercase
            if (Character.isUpperCase(currentChar)) 
            {
                if (i != 0)  //Avoid starting with an underscore
                {  
                    snakeCaseStr.append("_") ;  
                }
                
                snakeCaseStr.append(Character.toLowerCase(currentChar)) ;  //Convert the uppercase character to lowercase and append it
            } 
            else 
            {
                snakeCaseStr.append(currentChar) ;  //Otherwise, just append the character as it is
            }
        }

        return snakeCaseStr.toString() ;  //Return the final snake case string
    }

    public static String[] getNames(String[] arr, int n)
    {
        /*
         *  TODO: Random name
         *  Write a function generated a random names
         *  arr: array of string contains names
         *  n: the length of returned lest
         *
         *  condition:
         *      1. result name is constructed of two parts
         *      2. result name parts is unique
         *      3. create a custom exception if n is more than what you can generate
         *
         *  example:
         *      arr = ["Rami", "Ahmad", "Sameh"] n = 3
         *   result:
         *      ["Rami Ahmad", "Rami Sameh", "Ahmad Sameh"]
         */
        int totalCombinations = arr.length * (arr.length - 1) ;  //Calculate the total possible combinations of unique names

        //Check if n exceeds the number of possible combinations
        if (n > totalCombinations) 
        {
            throw new IllegalArgumentException("n exceeds the number of unique combinations possible") ;  //Throw an exception if n is too large
        }

        String[] result = new String[n] ;  //Create an array to store the results
        int index = 0 ;

        //Nested loop to generate combinations
        for (int i = 0 ; i < arr.length ; i++) 
        {
            for (int j = 0 ; j < arr.length ; j++) 
            {
                //Ensure the names are not the same
                if (i != j) 
                {
                    //Add the combination to the result
                    result[index] = arr[i] + " " + arr[j] ;
                    index++ ;

                    //Stop once we have enough combinations
                    if (index == n) 
                    {
                        return result ;
                    }
                }
            }
        }
        
        return result ;
    }
}
