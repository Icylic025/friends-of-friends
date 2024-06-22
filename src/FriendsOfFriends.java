
import java.util.Scanner;
public class FriendsOfFriends {
	static int [][] friendships = new int[51][51];       // don't use 0
	static int [][] copyOfFriendships = new int[50][50];       // don't use 0
	static boolean isFirstTwoDigits = false;
	public static void main(String[] args) {
		
		   Scanner scan = new Scanner(System.in); 
		   String input = "";
		   int command1 = 0;
		   int command2 = 0;
		   
		   insert('i', 1, 6);
		   
		   insert('i', 2, 6);
		   
		   insert('i', 3, 4);
		   insert('i', 3, 5);
		   insert('i', 3, 6);
		   insert('i', 3, 15);

		   insert('i', 4, 5);
		   insert('i', 4, 6);
	
		   insert('i', 5, 6);
		   
		   insert('i', 6, 7);
		   
		   insert('i', 7, 8);
		   
		   insert('i', 8, 9);
		   
		   insert('i', 9, 10);
		   insert('i', 9, 12);
		   
		   insert('i', 10, 11);
		   
		   insert('i', 11, 12);
		   
		   insert('i', 12, 13);
		   
		   insert('i', 13, 14);
		   insert('i', 13, 15);
		   
		   insert('i', 16, 17);
		   insert('i', 16, 18);
		   
		   insert('i', 17, 18);
		   
		   // continues to ask user for command until q is pressed
		   do {
			   System.out.println("Please enter command: ");
			   input = scan.nextLine();
		      // scan.nextLine();  // clears hard return after name
		       
			   if(input.charAt(0) == 'q') {
		    	   System.exit(0);
		    	   
		       } // if
			 //  System.out.println("The first command is " + readCommand(input, 2));
			  // System.out.println("The second command is " + readSecondCommand(input));
		       command1 = readCommand(input, 2);
		       command2 = readSecondCommand(input);
		
		       if(input.charAt(0) == 'i') {
		    	   insert('i', command1, command2);
		       } //if
		       
		       else if(input.charAt(0) == 'd') {
		    	   delete('d', command1, command2);
		    	   
		       } //if
		       
		       else if(input.charAt(0) == 'n') {
		    	   numberOfFriends('n', command1);
		    	   
		       } //if
		       
		       else if(input.charAt(0) == 'f') {
		    	   friendsOfFriends('f', command1);
		    	   
		       } //if
		       
		       else if(input.charAt(0) == 's') {
		    	  seperation('s', command1, command2);
		    	   
		       } //if
		       
		       printArray();
		       floydWarshaw();
		       printArray();
		   } while (true);
		   
	} // main
	
	public static void printArray() {
		
		  // print array
	       for(int i = 0; i < friendships.length; i++) {
	    	   for(int j = 0; j < friendships.length; j++) {
	    		   System.out.print(friendships [i][j]);
		       } // for
	    	   System.out.print("\n");
	       } // for
	       
		
	}
	
	public static void printCopyArray() {
		
		//print copy array
	   
	       copyOfFriendships [0][0] = 5;
	       System.out.println("");
	       for(int i = 0; i < copyOfFriendships.length; i++) {
	    	   for(int j = 0; j < copyOfFriendships.length; j++) {
	    		   System.out.print(copyOfFriendships [i][j]);
		       } // for
	    	   System.out.print("\n");
	       } // for
		  
	       
		
	}
	public static int readCommand (String a, int index) {

		int firstDigit = 0;
		int secDigit = 0;
		int whatToReturn = 0;
		String first = "";
		String sec = "";
		String both = "";
		
		firstDigit = a.charAt(index) - 48;
			
			//see if there is multiple digits to what the user enters
			try {
				if(a.charAt(index + 1) == 32) {
					isFirstTwoDigits = false;
					return firstDigit;
				}else {
					isFirstTwoDigits = true;
				}
				
			}catch (Exception e){
				
				return firstDigit;
			}
			
			
	
			secDigit = a.charAt(index + 1) - 48;
			sec = Integer.toString(secDigit);
			first = Integer.toString(firstDigit);
			both = first + sec;
			whatToReturn = Integer.parseInt(both);
			
			return whatToReturn;
		
	} // readCommand
	
	public static int readSecondCommand (String a) {
		try {
			a.charAt(4);
		} catch (Exception e) {
			//System.out.println("There is no second command");
			return -1;
		} // catch
		
		if(isFirstTwoDigits == true) {
			return readCommand(a, 5);
		}else {
			return readCommand(a, 4);
		}
	} // readSecondCommand
	public static void insert(char i, int a, int b) {
		//System.out.println("The command was I");
		friendships[a][b] = 1;
		friendships[b][a] = 1;
		
	}
	
	public static void delete(char d, int a, int b) {
	//	System.out.println("The command was D");
		
		friendships[a][b] = 0;
		friendships[b][a] = 0;
		
		
	}
	 
	public static void numberOfFriends(char n, int a) {
		int friends = 0;
		for(int i = 0; i < friendships.length; i++) {
			if(friendships[a][i] == 1) { 
				
				friends++;
			} // if
			
		} // for
		System.out.println("n " + friends);
		
		
	}
	
	public static void friendsOfFriends(char f, int a) {
		//System.out.println("The command was F");
		floydWarshaw();
		int counter = 0;
		
		for(int i = 0; i < copyOfFriendships.length; i++) {

			System.out.println("I RAN");
			if(copyOfFriendships[a][i] == Integer.MAX_VALUE) {
				counter++;
				
			} // if
		}
		
		System.out.println("f " + counter);
	}
	
	public static void seperation(char s, int a, int b) {
		//System.out.println("The command was S");
		
	}
	
	public static void floydWarshaw() {
		System.out.println("");
	
		//copy friendships array
		int infinity = Integer.MAX_VALUE;
		for(int i = 0; i < copyOfFriendships.length; i++) {
			for(int j = 0; j < copyOfFriendships.length; j++) {
				if (friendships[i][j] == 1) {
				copyOfFriendships[i][j] = 1;
				} else {
					copyOfFriendships[i][j] = infinity;	
				} // else
				
				
			}//for
		}//for
		
		for(int k = 1; k < copyOfFriendships.length; k++) {
			for(int i = 1; i < copyOfFriendships.length; i++) {
				for(int j = 1; j < copyOfFriendships.length; j++) {
					copyOfFriendships[i][j] = Math.min(copyOfFriendships[i][j], copyOfFriendships[i][k] + copyOfFriendships[k][j]);
				} // for
			} // for
		} // for
	//	printCopyArray();
	}

	

} // FriendsOfFriends






/*****************
 * 
 * This Program is a loop that asks the user to enter a comment. The user enters a command, the program executes the 
 * command and loops back to enter the command. Until enters q
 * 
 * 
 * 
 * Start with a basic program that returns what the user enters
 * 
 * 
 * Parse command and read int, has to read int since there are 50(two digit) people so char will not work
 * Test i 3 5 return making 3 5 friends
 * 
 * a method for floyd since it will be called for 2 methods
 * 
 * a method for initializing the array 
 * 
 * your choice other methods
 * 
 ******************/
