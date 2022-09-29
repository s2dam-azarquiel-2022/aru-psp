
import java.io.*;
public class Fichero{
	private static final String FICHERO="contador.txt";
	public static int leovalor(){
		FileReader fr;
		BufferedReader br;
		String linea=null;
		try{
		  fr=new FileReader(FICHERO);
		  br=new BufferedReader(fr);
		  linea=br.readLine();
		  fr.close();
		} catch (Exception e) {};
	 	return Integer.parseInt(linea);
	}
	public	static void escribovalor(int contador){
		FileWriter fw;
		PrintWriter pw;
		String linea=null;
		try{
		  fw=new FileWriter(FICHERO);
		  pw=new PrintWriter(fw);
		  pw.println(contador);
		  fw.close();
		} catch (Exception e) {};
	     
	}
}
