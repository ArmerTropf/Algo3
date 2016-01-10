import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import java_cup.runtime.Symbol;

public class start 
{
//	public static void welcome()
//	{
//		final int RB_TREE = 1;
//		final int P_TREE = 2;
//		final int ROBDD = 3;
//		
//		int intTree;
//		int intInput;
//		
//		int intInputCharacter;
//		int strInputCharacter;
//		
//		
//		boolean boolInputComplete = false;
//		boolean boolOutputComplete = false;
//		
//		boolean boolInput = false;
//		boolean boolDelete = false;
//		
//		
//		Scanner scanner = new Scanner(System.in);
//	    System.out.println("Bitte Struktur auswählen: ");
//	    System.out.print("Red-Black-Tree: 1 , Patricia-Tree: 2 , ROBDD: 3 :");
//	    
//	    intTree = Integer.parseInt(scanner.nextLine());
//	   
//	    if ( intTree == RB_TREE  )
//	    {
//	    	Vector<Integer> vecIntInput = new Vector<>(1, 1);
//	    	
//	    	RedBlackTree<Integer, Integer> RBTree = new RedBlackTree<>();
//	    	
//	    	while (!boolInputComplete)
//	    	{
//	    		 System.out.println("Einfügen: 1 , Löschen: 2 , Zufallszahlen(1-1000): 3  , Ausgabe: 0 : ");
//	    		 intInput = Integer.parseInt(scanner.nextLine());
//	    		 
//	    		 switch (intInput) 
//	    		 {
//	    		 	case 1: 
//	    		 		System.out.print("Zahl zum Einfügen:  ");
//	    		 		intInput = Integer.parseInt(scanner.nextLine());
//	    		 		RBTree.insert(intInput, intInput);
//	    		 		break;
//					
//	    		 	case 2: 
//						System.out.print("Zahl zum Löschen:  ");
//						intInput = Integer.parseInt(scanner.nextLine());
//						RBTree.remove(intInput);
//						break;
//	    		 	case 3: 
//	    		 		
//	    		 		System.out.print("Anzahl der Zahlen:  ");
//						intInput = Integer.parseInt(scanner.nextLine());
//						 
//						for (int i = 0 ; i < intInput ; i++ )
//						{
////							Integer intRandom = (int)(Math.random() * 1000) ;
////							vecIntInput.add(intRandom);
//							vecIntInput.add(i);
//							boolInputComplete = true;
//
//						}
//						vecIntInput.add(0);
//						vecIntInput.add(1);
//						vecIntInput.add(2);
//						vecIntInput.add(3);
//						vecIntInput.add(4);					
//						vecIntInput.add(5);
//						vecIntInput.add(6);
//						vecIntInput.add(7);
//						vecIntInput.add(8);
//						vecIntInput.add(9);
////						vecIntInput.add(5);
////						vecIntInput.add(13);
////						vecIntInput.add(-1);
////						vecIntInput.add(7);
////						vecIntInput.add(15);
////						vecIntInput.add(16);
////						vecIntInput.add(30);
////						vecIntInput.add(50);
//					
//					
//						
//						
//						break;
//	    		 	case 0: 
//	    		 		boolInputComplete = true;
//						break;
//				
//	    		 }
//	    	 
//	    		 
//	    	}
//	    	System.out.println("Folgende Zahlen sind eingefügt: ");
//	    	for (Integer integer : vecIntInput) 
//	    	{
//	    		RBTree.insert(integer, integer);
//				System.out.print(integer + " ");
//			}
////RBTree.remove(5);
//	    	
//	    	System.out.println();
//	    	
//	    	while (!boolOutputComplete)
//	    	{
//	    		System.out.println("Ansicht wählen: ");
//		    	System.out.print("Rot-Schwarz-Baum: 1 , TopDown 234: 2 , Baum modifizieren: 5 , Neustart: 0 : ");
//	   		 	intInput = Integer.parseInt(scanner.nextLine());
//	   		 	
//	   		 	switch (intInput) 
//	   		 	{
//				 	case 1: 
//				 		WriteUDGFile.createUDGFile(RedBlack2UDraw(RBTree), "RBTree", "Keine Ahnung");
//				 		System.out.println(RedBlack2UDraw(RBTree));
//				 		break;
//					
//				 	case 2: 
//				 		WriteUDGFile.createUDGFile(topDown234ToUDraw(RBTree), "TD234Tree", "Keine Ahnung");
//				 		System.out.println(topDown234ToUDraw(RBTree));
//						break;
//				 	case 5: 
//				 		boolInputComplete = true;
//						break;
//				 	case 0: 
//				 		welcome();
//						break;
//				 	case 9: 
//				 		boolOutputComplete = true;
//						break;
//	   		 	}    		
//	    	}
//	    	
//	    }
//	}
	
	public static void main(String[]args)
	{
		
		ConsoleControl.welcome();
		
	}
	
//	
//	public static String roBDD2UDraw(ROBDD roBDD) 
//	{
//		ArrayList<ROBDD.Func> uniqueNodes = new ArrayList<>();
//		ROBDD.Func root = roBDD.m_Root;
//		String udrawText = "[";
//		if(root != null) {
//			if(root.isConstant())
//			{
//				udrawText += "l(\"" + root.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (root.isTrue()? "T" : "F") + "\"), a(\"_GO\", \"rectangle\")], [";
//			} else {
//				udrawText += "l(\"" + root.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (char) root.getVar() + "\"), a(\"_GO\", \"circle\")], [";
//			}
//		String children = "";
//		if(root.getThen(root.getVar()) != null)
//			children += goDownRoBDD(root.getThen(root.getVar()), root, uniqueNodes);
//		
//		if(root.getElse(root.getVar()) != null) {
//			children += "," + goDownRoBDD(root.getElse(root.getVar()), root, uniqueNodes);
//		}
//		
//		if(children.startsWith(","))
//			children = children.substring(1);
//		
//		udrawText += children;
//		
//		udrawText += "]))]";
//		
//		return udrawText;
//		}
//		return "[]";
//		
//	}
//	
//	public static String goDownRoBDD(ROBDD.Func go, ROBDD.Func parent, ArrayList<ROBDD.Func> uniqueNodes) {
//
//		String udrawText;
//		udrawText = "l(\"" + parent.hashCode() + "->" + go.hashCode() + "\", e(\"edge\", [a(\"OBJECT\", \"" + (go == parent.getThen(parent.getVar()) ? "1" : "0") + "\"), a(\"EDGECOLOR\", \"" + (go == parent.getThen(parent.getVar()) ? "#00FF00" : "#FF0000") + "\")],";
//		
//		if(uniqueNodes.contains(go)) {
//			// nur Referenz
//			udrawText += "r(\""+go.hashCode()+"\")))";
//		} else {		
//			// neuer Knoten mit Kindern
//			uniqueNodes.add(go);
//			
//			if(go.isConstant())
//			{
//				udrawText += "l(\"" + go.hashCode()+ "\", n(\"node\", [ a(\"OBJECT\", \""+ (go.isTrue()? "T" : "F") + "\"), a(\"_GO\", \"rectangle\")], [";
//			} else {
//				udrawText += "l(\"" + go.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (char) go.getVar() + "\"), a(\"_GO\", \"circle\")], [";
//			}
//			
//			String children = "";
//			
//			if(go.getThen(go.getVar()) != null)
//				children += goDownRoBDD(go.getThen(go.getVar()), go, uniqueNodes);
//			
//			if(go.getElse(go.getVar()) != null) {
//				children += "," + goDownRoBDD(go.getElse(go.getVar()), go, uniqueNodes);
//			}
//			if(children.startsWith(","))
//				children = children.substring(1);
//			
//			udrawText += children;
//			
//			udrawText += "]))))";
//		}
//		
//		return udrawText;
//
//	}
//	
//	
//
//	public static String RedBlack2UDraw(RedBlackTree RB)
//	{
//		String udrawText = "[";
//		if(RB.m_Root != null) {
//		udrawText += "l(\"" + RB.m_Root.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ RB.m_Root.m_Data + "\")], [";
////		
//		
//		if(RB.m_Root.m_Left != null)
//			udrawText += goDownTree(RB.m_Root.m_Left, RB.m_Root);
//		
//		if(RB.m_Root.m_Right != null) {
//			if(RB.m_Root.m_Left != null)
//				udrawText += ",";
//			udrawText += goDownTree(RB.m_Root.m_Right, RB.m_Root);
//		}
//		udrawText += "]))]";
//		
//		return udrawText;
//		}
//		return "[]";
//	}
//	
//	
//	private static String goDownTree(RedBlackTree.Node go, RedBlackTree.Node parent)
//	{
//		String udrawText;
//		udrawText = "l(\"" + parent.m_Key + "->" + go.m_Key + "\", e(\"edge\", [a(\"OBJECT\", \"\"), a(\"EDGECOLOR\", \""+(go.m_bIsRed ? "#FF0000" : "#000000" )+"\")],";
//		
//		udrawText += "l(\"" + go.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ go.m_Data + "\")], [";
//
//		if(go.m_Left != null)
//			udrawText += goDownTree(go.m_Left, go);
//		
//		if(go.m_Right != null) {
//			if(go.m_Left != null)
//				udrawText += ",";
//			udrawText += goDownTree(go.m_Right, go);
//		}
//		udrawText += "]))))";
//		
//		return udrawText;
//	}
//	
//	public static String topDown234ToUDraw(RedBlackTree RB)
//	{
//		String udrawText = "[";
//		
//		if(RB.m_Root != null) {
//			
//			String name = RB.m_Root.m_Data.toString();
//			
//			//Wenn linkes Kind Kante Rot , dann zusammenziehen
//			if(RB.m_Root.m_Left != null && RB.m_Root.m_Left.m_bIsRed)
//				name = RB.m_Root.m_Left.m_Data + " " + name;
//
//			//Wenn rechtes Kind Kante Rot , dann zusammenziehen
//			if(RB.m_Root.m_Right != null && RB.m_Root.m_Right.m_bIsRed)
//				name+= " " + RB.m_Root.m_Right.m_Data;
//
//			//Knoten erstellen
//			udrawText += "l(\"" + RB.m_Root.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ name + "\")], [";
//			
//			String children = "";
//			//Links absteigen
//			if(RB.m_Root.m_Left != null)
//				children += goDownTree2(RB.m_Root.m_Left, RB.m_Root);
//			
//			// rechts absteigen
//			if(RB.m_Root.m_Right != null) 
//			{
//				children += "," + goDownTree2(RB.m_Root.m_Right, RB.m_Root);
//			}
//			
//			if(children.startsWith(","))
//				children = children.substring(1);
//			
//			udrawText += children;
//			
//			//Abschluss der Klammern
//			udrawText += "]))]";
//			
//			return udrawText;
//		}
//		return "[]";
//	}
//	
//	private static String goDownTree2(RedBlackTree.Node go, RedBlackTree.Node parent)
//	{
//		String udrawText = "";
//		
//		if(!go.m_bIsRed) {
//			
//			String name = go.m_Data.toString();
//			
//			if(go.m_Left != null && go.m_Left.m_bIsRed)
//				name = go.m_Left.m_Data + " " + name;
//
//			if(go.m_Right != null && go.m_Right.m_bIsRed)
//				name+= " " + go.m_Right.m_Data;
//			
//			udrawText += "l(\"" + parent.m_Key + "->" + go.m_Key + "\", e(\"edge\", [a(\"OBJECT\", \"\")],";
//			udrawText += "l(\"" + go.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ name + "\")], [";
//		}
//		String children = "";
//		
//		if(go.m_Left != null)
//			children += goDownTree2(go.m_Left, go);
//		
//		if(go.m_Right != null) {
//			children += "," + goDownTree2(go.m_Right, go);
//		}
//		if(children.startsWith(","))
//			children = children.substring(1);
//		udrawText += children;
//		if(!go.m_bIsRed)
//			udrawText += "]))))";
//		
//		return udrawText;
//	}
//	
//	private static String Patricia2UDraw(PatriciaTreeStrings pTree) 
//	{
//		
//		ArrayList<PatriciaTreeStrings.Node> uniqueNodes = new ArrayList();
//		
//		String udrawText = "[";
//		if(pTree.getRoot() != null) 
//		{
//			uniqueNodes.add(pTree.getRoot());
//			
//			udrawText += "l(\"" + pTree.getRoot().m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ pTree.getRoot().m_Key + " " + pTree.getRoot().m_BitPos + "\")], [";
//	
//			if(pTree.getRoot().m_Left != null)
//				udrawText += goDownPatricia(pTree.getRoot().m_Left, pTree.getRoot(), uniqueNodes);
//			
//			if(pTree.getRoot().m_Right != null) {
//				if(pTree.getRoot().m_Left != null)
//					udrawText += ",";
//				udrawText += goDownPatricia(pTree.getRoot().m_Right, pTree.getRoot(), uniqueNodes);
//		}
//		udrawText += "]))]";
//		
//		return udrawText;
//		}
//		return "[]";
//		
//	}
//	
//	private static String goDownPatricia(PatriciaTreeStrings.Node go, PatriciaTreeStrings.Node parent, ArrayList uniqueNodes) 
//	{
//		String udrawText;
//		udrawText = "l(\"" + parent.m_Key + "->" + go.m_Key + "\", e(\"edge\", [a(\"OBJECT\", \"" + (go.bIsLeft ? "0" : "1") + "\")],";
//		
//		if(uniqueNodes.contains(go)) {
//			// nur Referenz
//			udrawText += "r(\""+go.m_Key+"\")))";
//		} else {		
//			// neuer Knoten mit Kindern
//			uniqueNodes.add(go);
//			
//			udrawText += "l(\"" + go.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ go.m_Key + " " + go.m_BitPos + "\")], [";
//	
//			if(go.m_Left != null)
//				udrawText += goDownPatricia(go.m_Left, go, uniqueNodes);
//			
//			if(go.m_Right != null) {
//				if(go.m_Left != null)
//					udrawText += ",";
//				udrawText += goDownPatricia(go.m_Right, go, uniqueNodes);
//			}
//			udrawText += "]))))";
//		}
//		
//		return udrawText;
//	}



	

}