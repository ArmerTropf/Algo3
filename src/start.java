import java.util.ArrayList;

public class start 
{
	public static void main(String[]args)
	{
		
		RedBlackTree<Integer, Integer> RB = new RedBlackTree<>();
		
		RB.insert(20, 20);
		RB.insert(25, 25);
		RB.insert(5, 5);
		RB.insert(24, 24);
		RB.insert(29, 29);
		RB.insert(7, 7);
		RB.insert(3, 3);
		RB.insert(30, 30);

		System.out.println(RedBlack2UDraw(RB));
		System.out.println(tD234ToUDraw(RB));

		PatriciaTreeStrings pTree = new PatriciaTreeStrings();
		
		pTree.insert("romane");
		pTree.insert("romanus");
		pTree.insert("romulus");
		pTree.insert("ruben");
		
		System.out.println(Patricia2UDraw(pTree));
		
	}
	
	
	private static String Patricia2UDraw(PatriciaTreeStrings pTree) 
	{
		
		ArrayList<PatriciaTreeStrings.Node> uniqueNodes = new ArrayList();
		
		String udrawText = "[";
		if(pTree.getRoot() != null) 
		{
			uniqueNodes.add(pTree.getRoot());
			
			udrawText += "l(\"" + pTree.getRoot().m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ pTree.getRoot().m_Key + " " + pTree.getRoot().m_BitPos + "\")], [";
	
			if(pTree.getRoot().m_Left != null)
				udrawText += goDownPatricia(pTree.getRoot().m_Left, pTree.getRoot(), uniqueNodes);
			
			if(pTree.getRoot().m_Right != null) {
				if(pTree.getRoot().m_Left != null)
					udrawText += ",";
				udrawText += goDownPatricia(pTree.getRoot().m_Right, pTree.getRoot(), uniqueNodes);
		}
		udrawText += "]))]";
		
		return udrawText;
		}
		return "[]";
		
	}


	private static String goDownPatricia(PatriciaTreeStrings.Node go, PatriciaTreeStrings.Node parent, ArrayList uniqueNodes) 
	{
		String udrawText;
		udrawText = "l(\"" + parent.m_Key + "->" + go.m_Key + "\", e(\"edge\", [a(\"OBJECT\", \"" + (go.bIsLeft ? "0" : "1") + "\")],";
		
		if(uniqueNodes.contains(go)) {
			// nur Referenz
			udrawText += "r(\""+go.m_Key+"\")))";
		} else {		
			// neuer Knoten mit Kindern
			uniqueNodes.add(go);
			
			udrawText += "l(\"" + go.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ go.m_Key + " " + go.m_BitPos + "\")], [";
	
			if(go.m_Left != null)
				udrawText += goDownPatricia(go.m_Left, go, uniqueNodes);
			
			if(go.m_Right != null) {
				if(go.m_Left != null)
					udrawText += ",";
				udrawText += goDownPatricia(go.m_Right, go, uniqueNodes);
			}
			udrawText += "]))))";
		}
		
		return udrawText;
	}


	private static String RedBlack2UDraw(RedBlackTree RB)
	{
		String udrawText = "[";
		if(RB.m_Root != null) {
		udrawText += "l(\"" + RB.m_Root.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ RB.m_Root.m_Data + "\")], [";
//		
		
		if(RB.m_Root.m_Left != null)
			udrawText += goDownTree(RB.m_Root.m_Left, RB.m_Root);
		
		if(RB.m_Root.m_Right != null) {
			if(RB.m_Root.m_Left != null)
				udrawText += ",";
			udrawText += goDownTree(RB.m_Root.m_Right, RB.m_Root);
		}
		udrawText += "]))]";
		
		return udrawText;
		}
		return "[]";
	}
	
	
	private static String goDownTree(RedBlackTree.Node go, RedBlackTree.Node parent)
	{
		String udrawText;
		udrawText = "l(\"" + parent.m_Key + "->" + go.m_Key + "\", e(\"edge\", [a(\"OBJECT\", \"\"), a(\"EDGECOLOR\", \""+(go.m_bIsRed ? "#FF0000" : "#000000" )+"\")],";
		
		udrawText += "l(\"" + go.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ go.m_Data + "\")], [";

		if(go.m_Left != null)
			udrawText += goDownTree(go.m_Left, go);
		
		if(go.m_Right != null) {
			if(go.m_Left != null)
				udrawText += ",";
			udrawText += goDownTree(go.m_Right, go);
		}
		udrawText += "]))))";
		
		return udrawText;
	}
	
	public static String tD234ToUDraw(RedBlackTree RB)
	{
		String udrawText = "[";
		
		if(RB.m_Root != null) {
			
			String name = RB.m_Root.m_Data.toString();
			
			//Wenn linkes Kind Kante Rot , dann zusammenziehen
			if(RB.m_Root.m_Left != null && RB.m_Root.m_Left.m_bIsRed)
				name = RB.m_Root.m_Left.m_Data + " " + name;

			//Wenn rechtes Kind Kante Rot , dann zusammenziehen
			if(RB.m_Root.m_Right != null && RB.m_Root.m_Right.m_bIsRed)
				name+= " " + RB.m_Root.m_Right.m_Data;

			//Knoten erstellen
			udrawText += "l(\"" + RB.m_Root.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ name + "\")], [";
			
			//Links absteigen
			if(RB.m_Root.m_Left != null)
				udrawText += goDownTree2(RB.m_Root.m_Left, RB.m_Root);
			
			// rechts absteigen
			if(RB.m_Root.m_Right != null) 
			{
				if(RB.m_Root.m_Left != null && !RB.m_Root.m_Left.m_bIsRed)
					udrawText += ",";
				udrawText += goDownTree2(RB.m_Root.m_Right, RB.m_Root);
			}
			//Abschluss der Klammern
			udrawText += "]))]";
			
			return udrawText;
		}
		return "[]";
	}
	
	private static String goDownTree2(RedBlackTree.Node go, RedBlackTree.Node parent)
	{
		String udrawText = "";
		
		if(!go.m_bIsRed) {
			
			String name = go.m_Data.toString();
			
			if(go.m_Left != null && go.m_Left.m_bIsRed)
				name = go.m_Left.m_Data + " " + name;

			if(go.m_Right != null && go.m_Right.m_bIsRed)
				name+= " " + go.m_Right.m_Data;
			
			udrawText += "l(\"" + parent.m_Key + "->" + go.m_Key + "\", e(\"edge\", [a(\"OBJECT\", \"\")],";
			udrawText += "l(\"" + go.m_Key+ "\", n(\"node\", [ a(\"OBJECT\", \""+ name + "\")], [";
		}
		if(go.m_Left != null)
			udrawText += goDownTree2(go.m_Left, go);
		
		if(go.m_Right != null) {
			if(go.m_Left != null && !go.m_Left.m_bIsRed)
				udrawText += ",";
			udrawText += goDownTree2(go.m_Right, go);
		}
			
		if(!go.m_bIsRed)
		udrawText += "]))))";
		
		return udrawText;
	}
	

}
