import java.util.Scanner;
import java.util.Vector;
import java.io.StringReader;

import java_cup.runtime.Symbol;

public class ConsoleControl
{
	
	final static int RB_TREE = 1;
	final static int P_TREE = 2;
	final static int ROBDD = 3;
	
	static int intTree;
	static int intInput;
	
	int intInputCharacter;
	int strInputCharacter;
	
	
	static boolean boolInputComplete = false;
	static boolean boolOutputComplete = false;
	
	boolean boolInput = false;
	boolean boolDelete = false;
	
	static Scanner scanner = new Scanner(System.in);
	
	static RedBlackTree<Integer, Integer> RBTree;
	static PatriciaTreeStrings PTree;
	static ROBDD robdd;
	
	static Vector<Integer> vecIntInput = new Vector<>(1, 1);
	
	
	
	
	public static void welcome()
	{
		 System.out.println("Bitte Struktur auswählen: ");
		    System.out.print("Red-Black-Tree: 1 , Patricia-Tree: 2 , ROBDD: 3 :");
		    
		    intTree = Integer.parseInt(scanner.nextLine());
		    
		    switch (intTree) 
		    {
			case RB_TREE:
				RBTree = new RedBlackTree<>();
				RBTreeIn();
				break;
			case P_TREE:
				PTree = new PatriciaTreeStrings();
				PTreeIn();
				break;
			case ROBDD:
				robdd = new ROBDD();
				ROBDDIn();
				break;
			default:
				break;
			}
		    
		    
	}
	
	
	
	private static void RBTreeIn()
	{
		boolOutputComplete = false;
		while (!boolInputComplete)
    	{
    		 System.out.println("Rot-Schwarz:\nEinfügen: 1\n"
    		 		+ "Löschen: 2 \n"
    		 		+ "Zufallszahlen(1-1000): 3\n"
    		 		+ "Ausgabe: 5 : ");
    		 intInput = Integer.parseInt(scanner.nextLine());
    		 
    		 switch (intInput) 
    		 {
    		 	case 1: 
    		 		System.out.print("Zahl zum Einfügen:  ");
    		 		intInput = Integer.parseInt(scanner.nextLine());
    		 		RBTree.insert(intInput, intInput);
    		 		break;
				
    		 	case 2: 
					System.out.print("Zahl zum Löschen:  ");
					intInput = Integer.parseInt(scanner.nextLine());
					RBTree.remove(intInput);
					break;
    		 	case 3: 
    		 		
    		 		System.out.print("Anzahl der Zahlen:  ");
					intInput = Integer.parseInt(scanner.nextLine());
					 
					for (int i = 0 ; i < intInput ; i++ )
					{
						Integer intRandom = (int)(Math.random() * 1000) ;
						RBTree.insert(intRandom, intRandom);
						//vecIntInput.add(intRandom);
						vecIntInput.add(i);
					}
    		 							
					break;
    		 	case 5: 
    		 		outputRB_T234();
					break;
    		 	case 0: 
					break;
				
			
    		 }
    		 
    	}

			
	}
	
	private static void PTreeIn()
	{
		
		String strInputWord;	
		while (!boolInputComplete)
    	{
    		 System.out.println("Patricia Tree:\nWort Einfügen: 1\n"
    		 		+ "Löschen: 2\n"
    		 		+ "Ausgabe: 5 : ");
    		 intInput = Integer.parseInt(scanner.nextLine());
    		 
    		 switch (intInput) 
    		 {
    		 	case 1: 
    		 		System.out.print("Wort zum Einfügen:  ");
    		 		strInputWord = scanner.nextLine();
    		 		PTree.insert(strInputWord);
    		 		break;
				
    		 	case 2: 
					System.out.print("Wort zum Löschen:  ");
					strInputWord = scanner.nextLine();
					PTree.remove(strInputWord);
					break;
    		 	    	
    		 	case 5: 
    		 		outputPTree();
					break;
    		 	case 0: 
					break;
				
			
    		 }
    	 	 
    	}
		
			
	}
	
	private static void ROBDDIn()
	{
		
		String strInputWord;	
		while (!boolInputComplete)
    	{
    		 System.out.println("\nROBDD:\nAusdruck einfügen: 1\n"
    		 		+ "Ausgabe: 5 : ");
    		 intInput = Integer.parseInt(scanner.nextLine());
    		 
    		 switch (intInput) 
    		 {
    		 	case 1: 
    		 		System.out.print("Ausdruck Einfügen:  ");
    		 		strInputWord = scanner.nextLine();
    		 
    		 		BoolExprParser boolExprParser = new BoolExprParser(new BoolExprScanner(new StringReader(strInputWord)));
			
					try 
					{
						Symbol s;
						s = boolExprParser.parse();
			 			Node root = (Node) s.value;
			 			robdd.ConvertFromBool(root);
		 			
			 			
					} catch (Exception e) 
					{
						e.printStackTrace();
					}
    		 		break;    		 	    	
    		 	case 5: 
    		 		outputROBDD();
					break;
    		 	case 0: 
					break;
				
			
    		 }
    	 	 
    	}
		
			
	}

	
	
	private static void outputRB_T234()
	{
		boolOutputComplete = false;
		while (!boolOutputComplete)
    	{
    		System.out.println("Ansicht wählen: \n");
	    	System.out.print("Rot-Schwarz-Baum: 1\n"
	    			+ "TopDown 234: 2\n"
	    			+ "Baum modifizieren: 5\n"
	    			+ "Programm beenden: 9\n"
	    			+ "Neustart: 0\n\n"
	    			+ "Eingabe: ");
   		 	intInput = Integer.parseInt(scanner.nextLine());
   		 	
   		 	switch (intInput) 
   		 	{
			 	case 1: 
			 		WriteUDGFile.createUDGFile(UDG_RedBlack.RedBlack2UDraw(RBTree), "RBTree", "Keine Ahnung");
			 		//System.out.println(UDG_RedBlack.RedBlack2UDraw(RBTree));
			 		break;
				
			 	case 2: 
			 		WriteUDGFile.createUDGFile(UDG_TD234.topDown234ToUDraw(RBTree), "TD234Tree", "Keine Ahnung");
			 		//System.out.println(UDG_TD234.topDown234ToUDraw(RBTree));
					break;
			 	case 5: 
			 		RBTreeIn();
					break;
			 	case 0: 
			 		welcome();
					break;
			 	case 9: 
			 		System.out.println("Programm beendet");
			 		System.exit(0);
					break;
   		 	}   
   		 	
    	}
	}
	
	private static void outputPTree()
	{
		boolOutputComplete = false;
		while (!boolOutputComplete)
    	{
    		System.out.println("Optionen: \n");
	    	System.out.print("\nPatricia Tree: 1\n"
	    			+ "Baum modifizieren: 5\n"
	    			+ "Programm beenden: 9\n"
	    			+ "Neustart: 0\n\n"
	    			+ "Eingabe: ");
   		 	intInput = Integer.parseInt(scanner.nextLine());
   		 	
   		 	switch (intInput) 
   		 	{
			 	case 1: 
			 		WriteUDGFile.createUDGFile(UDG_Patricia.Patricia2UDraw(PTree), "PTree", "Keine Ahnung");
			 		//System.out.println(UDG_RedBlack.RedBlack2UDraw(RBTree));
			 		break;
			 	case 5: 
			 		PTreeIn();
					break;
			 	case 0: 
			 		welcome();
					break;
			 	case 9: 
			 		System.out.println("Programm beendet");
			 		System.exit(0);
   		 	}    		
    	}

	}
	
	private static void outputROBDD()
	{
		boolOutputComplete = false;
		while (!boolOutputComplete)
    	{
    		System.out.println("\nOptionen: \n");
	    	System.out.print("ROBDD ausgeben: 1\n"
	    			+ "Programm beenden: 9\n"
	    			+ "Neustart: 0\n\n"
	    			+ "Eingabe: ");
   		 	intInput = Integer.parseInt(scanner.nextLine());
   		 	
   		 	switch (intInput) 
   		 	{
			 	case 1: 
			 		WriteUDGFile.createUDGFile(UDG_ROBDD.roBDD2UDraw(robdd), "ROBDD", "Keine Ahnung");
			 		//System.out.println(UDG_RedBlack.RedBlack2UDraw(RBTree));
			 		break;
			 	case 0: 
			 		welcome();
					break;
			 	case 9: 
			 		System.out.println("Programm beendet");
			 		System.exit(0);
   		 	}    		
    	}

	}
	

}
