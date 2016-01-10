import java.io.File;

import javax.swing.JFileChooser;

public class start 
{

	
	public static void main(String[]args)
	{
		String strUDrawPath;

		final JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("UDraw Datei auswaehlen");
		/*
		 * Wenn der Pfad nicht gefunden wird, dann wird
		 * der Benutzerpfad angezeigt
		 */
		File fileStdUDGPath = new File("C:\\Program Files (x86)\\uDraw(Graph)\\bin\\");
		fc.setCurrentDirectory(fileStdUDGPath);
		
		fc.showOpenDialog(fc);
		/*
		 * Pfad in Variable für die weitere Übergabe
		 */
		strUDrawPath = fc.getSelectedFile().getAbsolutePath();
		
		ConsoleControl.welcome(strUDrawPath);
		
		
		PatriciaTreeChars test = new PatriciaTreeChars();
		
//		test.insert('S');
//		test.insert('H');
//		test.insert('X');
//		test.insert('P');
//		System.out.println();
		
		
		
	}

	

}