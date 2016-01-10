
public class UDG_TD234 
{
	public static String topDown234ToUDraw(RedBlackTree RB)
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
			
			String children = "";
			//Links absteigen
			if(RB.m_Root.m_Left != null)
				children += goDownTree2(RB.m_Root.m_Left, RB.m_Root);
			
			// rechts absteigen
			if(RB.m_Root.m_Right != null) 
			{
				children += "," + goDownTree2(RB.m_Root.m_Right, RB.m_Root);
			}
			
			if(children.startsWith(","))
				children = children.substring(1);
			
			udrawText += children;
			
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
		String children = "";
		
		if(go.m_Left != null)
			children += goDownTree2(go.m_Left, go);
		
		if(go.m_Right != null) {
			children += "," + goDownTree2(go.m_Right, go);
		}
		if(children.startsWith(","))
			children = children.substring(1);
		udrawText += children;
		if(!go.m_bIsRed)
			udrawText += "]))))";
		
		return udrawText;
	}

}
