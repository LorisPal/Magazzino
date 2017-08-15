package GestioneMagazzino;
import java.util.Scanner;
import GestioneMagazzino.Pezzo;

public class AggiungiPezzo 
{
	public AggiungiPezzo()
	{
		do {
			Pezzo prodotto=new Pezzo();
			Scanner in=new Scanner(System.in);
		
			System.out.println("Inserisci in ordine ID, Prezzo, Quantità in Magazzino");
		
			prodotto.setIdPezzo(in.nextLine());
			prodotto.setPrezzoInEuro(in.nextInt());
			prodotto.setQuantitàMagazzino(in.nextInt());
			System.out.println("ID pezzo: "+prodotto.getIdPezzo() +'\n'+
								"Prezzo: "+prodotto.getPrezzoInEuro() +'\n'+
								"Quantità in Magazzino: "+prodotto.getQuantitàMagazzino());
			}
			while(true);
	}
}
