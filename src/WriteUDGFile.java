import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteUDGFile 
{
	public static void createUDGFile(String strTree, String strTreeFilename, String strPathToUDraw)
	{
		try 
		{
			String strCompleteFilenameUDG = strTreeFilename + ".udg";
			FileWriter fw = new FileWriter("./" + strCompleteFilenameUDG);
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(strTree);
		    bw.close();
		    
		    startUDG(strPathToUDraw, strCompleteFilenameUDG);
	
		} 
		catch (Exception e) 
		{
	
		}
		 	
	}
	
	private static void startUDG(String strPathToUDraw , String strTreeFilename)
	{
//		String test = "C:\\Program Files (x86)\\uDraw(Graph)\\bin\\uDrawGraph.exe ./" + strTreeFilename ;
		
		try 
		{
			Runtime.getRuntime().exec(strPathToUDraw + " " + strTreeFilename);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
