package Run;

import java.util.Scanner;
import GestioneMagazzino.AggiungiPezzo;
import GestioneMagazzino.MySqlAcces;

public class mainRun 
{
	static String opzione;
	public static void main(String[] args) throws Exception 
	{	
		AggiungiPezzo aggiungi = new AggiungiPezzo();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digita il comando di cosa vuoi fare: " + '\n' 
						   + "1.--> add:    Aggiungi un pezzo;" + '\n'
						   + "2.--> show:   Visualizza il Database;" + '\n'
						   + "3.--> search: Cerca uno specifico articolo;" + '\n');
		
		opzione = in.nextLine();		
		if (opzione.equals("add"))
			{
				aggiungi.writeDatabase();
			}
		
		else if (opzione.equals("show"))
			{
				aggiungi.readDatabase();
			}
		else if (opzione.equals("search"))
			{
				aggiungi.readRecord();
			}
	}
		
		
}


