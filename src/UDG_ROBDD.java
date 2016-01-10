import java.util.ArrayList;

public class UDG_ROBDD 
{
	public static String roBDD2UDraw(ROBDD roBDD) 
	{
		ArrayList<ROBDD.Func> uniqueNodes = new ArrayList<>();
		ROBDD.Func root = roBDD.m_Root;
		String udrawText = "[";
		if(root != null) {
			if(root.isConstant())
			{
				udrawText += "l(\"" + root.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (root.isTrue()? "T" : "F") + "\"), a(\"_GO\", \"rectangle\")], [";
			} else {
				udrawText += "l(\"" + root.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (char) root.getVar() + "\"), a(\"_GO\", \"circle\")], [";
			}
		String children = "";
		if(root.getThen(root.getVar()) != null)
			children += goDownRoBDD(root.getThen(root.getVar()), root, uniqueNodes);
		
		if(root.getElse(root.getVar()) != null) {
			children += "," + goDownRoBDD(root.getElse(root.getVar()), root, uniqueNodes);
		}
		
		if(children.startsWith(","))
			children = children.substring(1);
		
		udrawText += children;
		
		udrawText += "]))]";
		
		return udrawText;
		}
		return "[]";
		
	}
	
	public static String goDownRoBDD(ROBDD.Func go, ROBDD.Func parent, ArrayList<ROBDD.Func> uniqueNodes) {

		String udrawText;
		udrawText = "l(\"" + parent.hashCode() + "->" + go.hashCode() + "\", e(\"edge\", [a(\"OBJECT\", \"" + (go == parent.getThen(parent.getVar()) ? "1" : "0") + "\"), a(\"EDGECOLOR\", \"" + (go == parent.getThen(parent.getVar()) ? "#00FF00" : "#FF0000") + "\")],";
		
		if(uniqueNodes.contains(go)) {
			// nur Referenz
			udrawText += "r(\""+go.hashCode()+"\")))";
		} else {		
			// neuer Knoten mit Kindern
			uniqueNodes.add(go);
			
			if(go.isConstant())
			{
				udrawText += "l(\"" + go.hashCode()+ "\", n(\"node\", [ a(\"OBJECT\", \""+ (go.isTrue()? "T" : "F") + "\"), a(\"_GO\", \"rectangle\")], [";
			} else {
				udrawText += "l(\"" + go.hashCode() + "\", n(\"node\", [ a(\"OBJECT\", \""+ (char) go.getVar() + "\"), a(\"_GO\", \"circle\")], [";
			}
			
			String children = "";
			
			if(go.getThen(go.getVar()) != null)
				children += goDownRoBDD(go.getThen(go.getVar()), go, uniqueNodes);
			
			if(go.getElse(go.getVar()) != null) {
				children += "," + goDownRoBDD(go.getElse(go.getVar()), go, uniqueNodes);
			}
			if(children.startsWith(","))
				children = children.substring(1);
			
			udrawText += children;
			
			udrawText += "]))))";
		}
		
		return udrawText;

	}
}
