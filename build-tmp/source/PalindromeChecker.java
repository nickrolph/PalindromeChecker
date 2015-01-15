import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String palCheck = noCapitals(noSpaces(word)); 
  String checkPal = backWard(palCheck);
    if (palCheck.equals(checkPal))    
    {
      return true;
    }
    
   return false;
  
  
 }
public String noSpaces(String word)
{
 String spaceless = new String();
  for(int i = 0; i < word.length(); i++)
  {
   if(Character.isLetter(word.charAt(i))== true)
   {
    spaceless = spaceless + word.charAt(i);
   }
  }
  return spaceless;
}
public String noCapitals(String word)
{
 String capless = new String(word.toLowerCase());
 
 return capless;

}
public String backWard(String word)
{
  String back = new String();
  for (int l = word.length()-1; l >= 0; l--) 
   {
    back = back + word.charAt(l);
   }
   return back;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
