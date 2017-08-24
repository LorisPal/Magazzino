package GestioneMagazzino;

import java.util.Date;
import java.util.Scanner;
import GestioneMagazzino.Pezzo;
import java.sql.*;

public class AggiungiPezzo 
{
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
	public void writeDatabase() throws Exception
	{
		Pezzo prodotto = new Pezzo();
		Scanner in = new Scanner(System.in);	
				
		System.out.println("Inserisci in ordine ID, Prezzo, Quantità in Magazzino");
		prodotto.setIdPezzo(in.nextLine());
		prodotto.setPrezzoInEuro(in.nextInt());
		prodotto.setQuantitàMagazzino(in.nextInt());
		
		try {
            // Carico i driver di SQL
            Class.forName("com.mysql.jdbc.Driver");
            
            // Imposto la connessione col DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/magazzino","loris","password");

            // Statements permette di usare le query di SQL con il DB
            statement = connect.createStatement();
            
            // Preparo una stringa con la query pe il DBMS e la invia
            String queryString="INSERT INTO magazzino.Pezzi(ID,Prezzo,QuantitàMagazzino) VALUES (" 
            		+ "'" + prodotto.getIdPezzo() + "', " 
            		+ prodotto.getPrezzoInEuro() + ", " 
            		+ prodotto.getQuantitàMagazzino() + ");";
            preparedStatement = connect.prepareStatement(queryString);
            preparedStatement.executeUpdate();
			}
		
		catch (Exception e) 
		{
            throw e;
        } 
		finally 
		{
            close();
        }
	}
	
	public void readRecord() throws Exception
	{	
		String id;
		Scanner inID = new Scanner(System.in);
		System.out.println("Inserisci l'ID del pezzo che vuoi cercare: " + '\n');
		
		id = inID.nextLine();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/magazzino","loris","password");
			statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("SELECT * FROM magazzino.Pezzi WHERE ID = " + "'" + id + "';");
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet);											 
		}
		
		catch(Exception e)
		{
			throw e;
		}
		
		finally
		{
			close();
		}
	}
	public void readDatabase() throws Exception
	{
		try
		{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/magazzino","loris","password");
            statement = connect.createStatement();
			preparedStatement = connect.prepareStatement("SELECT ID, Prezzo, QuantitàMagazzino from magazzino.Pezzi");
			resultSet = preparedStatement.executeQuery();
			writeResultSet(resultSet);
		}
		
		catch (Exception e) 
		{
            throw e;
        } 
		finally 
		{
            close();
        }
		
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException 
	{
		// ResultSet è inizializzato prima del primo dataset
	    while (resultSet.next()) 
	    {
	    	String ID = resultSet.getString("ID");
	    	String prezzo = resultSet.getString("Prezzo");
	    	String qta = resultSet.getString("QuantitàMagazzino");
	            
	    	System.out.println("ID: " + ID);
	    	System.out.println("Prezzo: " + prezzo);
	    	System.out.println("Qtà: " + qta + '\n');        
	    }
	 }

	// devo chiudere il resultSet
	private void close() 
	{

		try 
		{
			if (resultSet != null) 
            	{
            		resultSet.close();
            	}

            if (statement != null)
            	{
                	statement.close();
            	}

            if (connect != null) 
            	{
            		connect.close();
            	}
        } 
		catch (Exception e) 
		{
			
        }
	}
}
