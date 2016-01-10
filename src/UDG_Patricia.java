import java.util.ArrayList;

public class UDG_Patricia 
{
	public static String Patricia2UDraw(PatriciaTreeStrings pTree) 
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

}
