import java.util.ArrayList;

public class UDG_ROBDD 
{
	public static String roBDD2UDraw(ROBDD roBDD) 
	{
		/*
		 * Liste für eingefügte Knoten
		 * Wird genutzt, um bei schon vorhandenen Knoten 
		 * Referenzen im UDRAW zu erzeugen 
		 */
		ArrayList<ROBDD.Func> uniqueNodes = new ArrayList<>();
		ROBDD.Func root = roBDD.m_Root;
		
		String udrawText = "[";
		/*
		 * root nicht null
		 */
		if(root != null) 
		{
			/*
			 * Wenn Funktion
			 */
			if(root.isConstant())
			{
				udrawText += "l(\"" + root.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (root.isTrue()? "T" : "F") + "\"), a(\"_GO\", \"rectangle\")], [";
			} 
			else 
			{
				udrawText += "l(\"" + root.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (char) root.getVar() + "\"), a(\"_GO\", \"circle\")], [";
			}
			String child = "";
			/*
			 * Rechts absteigen
			 */
			if(root.getThen(root.getVar()) != null)
				child += goDownRoBDD(root.getThen(root.getVar()), root, uniqueNodes);
			
			/*
			 * Links absteigen
			 */
			if(root.getElse(root.getVar()) != null) {
				child += "," + goDownRoBDD(root.getElse(root.getVar()), root, uniqueNodes);
			}
			
			/*
			 * Führendes , löschen
			 */
			if(child.startsWith(","))
				child = child.substring(1);
			
			udrawText += child;
			
			udrawText += "]))]";
			
			return udrawText;
		}
		return "[]";
		
	}
	
	public static String goDownRoBDD(ROBDD.Func go, ROBDD.Func root, ArrayList<ROBDD.Func> uniqueNodes) {

		String udrawText;
		udrawText = "l(\"" + root.hashCode() + "->" + go.hashCode() + "\", e(\"edge\", [a(\"OBJECT\", \"" + (go == root.getThen(root.getVar()) ? "1" : "0") + "\"), a(\"EDGECOLOR\", \"" + (go == root.getThen(root.getVar()) ? "#0009FF" : "#FF0000") + "\")],";
		
		if(uniqueNodes.contains(go)) {
			/*
			 *  nur Referenz
			 */
			udrawText += "r(\""+go.hashCode()+"\")))";
		} else {		
			/*
			 *  neuer Knoten mit Kindern
			 */
			uniqueNodes.add(go);
			
			if(go.isConstant())
			{
				udrawText += "l(\"" + go.hashCode()+ "\", n(\"node\", [ a(\"OBJECT\", \""+ (go.isTrue()? "T" : "F") + "\"), a(\"_GO\", \"rectangle\")], [";
			} else {
				udrawText += "l(\"" + go.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (char) go.getVar() + "\"), a(\"_GO\", \"circle\")], [";
			}
			
			String child = "";
			
			if(go.getThen(go.getVar()) != null)
				child += goDownRoBDD(go.getThen(go.getVar()), go, uniqueNodes);
			
			if(go.getElse(go.getVar()) != null) {
				child += "," + goDownRoBDD(go.getElse(go.getVar()), go, uniqueNodes);
			}
			if(child.startsWith(","))
				child = child.substring(1);
			
			udrawText += child;
			
			udrawText += "]))))";
		}
		
		return udrawText;

	}
}
