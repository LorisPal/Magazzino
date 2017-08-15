package GestioneMagazzino;

public class Pezzo 
{
	private String idPezzo;
	private int prezzoInEuro;
	private int quantitàMagazzino;
	private int quantitàVenduta;
	
	public Pezzo (String idPezzo, int prezzoInEuro, int quantitàMagazzino)
	{
		this.idPezzo=idPezzo;
		this.prezzoInEuro=prezzoInEuro;
		this.quantitàMagazzino=quantitàMagazzino;
	}
	
	public Pezzo()
	{
		
	}
	
	public void setIdPezzo(String ID)
	{
		this.idPezzo=ID;
	}
	public void setPrezzoInEuro(int prezzo)
	{
		this.prezzoInEuro=prezzo;
	}
	public void setQuantitàMagazzino(int quantità)
	{
		this.quantitàMagazzino=quantità;
	}
	public String getIdPezzo()
	{
		return idPezzo;
	}
	public int getPrezzoInEuro()
	{
		return prezzoInEuro;
	}
	public int getQuantitàMagazzino()
	{
		return quantitàMagazzino;
	}
}
