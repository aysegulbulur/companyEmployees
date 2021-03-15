package ders218_sirketCalisanlariProjesi_adminGirisTasarimiveGirisiniKontrolEtme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class calisanislemleri {
	
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public boolean girisYap(String kullaniciAdi, String parola){
		String sorgu = "Select * From adminler where username = ? and password = ?";
		
		try {
			preparedStatement = con.prepareStatement(sorgu);
			
			preparedStatement.setString(1, kullaniciAdi);
			preparedStatement.setString(2, parola);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			/*if(rs.next() == false){
				//kullan�c� ad� ve parola yoksa
				return false;	//o de�er yok.
			}
			else{
				return true;	//kullan�c� ad� ve parola var.
			}*/ 
			
			return rs.next();	//if-else blo�unun alternatifi.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	//herhangi bir exception olma durumunda false de�er d�nd�recek.
		}
	}
	
	public calisanislemleri(){
		String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db;
		//jdbc:mysql://localhost:3306/deneme
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
				//ba�lant� i�in gerekli olan Driver ba�lat�lmal� yoksa hata verebilir.
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver Bulunamad�...");
				//veri taban� eklenmemi� olursa bu hatay� verir.
		}
		
		try {
			con = DriverManager.getConnection(url, database.kullaniciAdi, database.parola);
			System.out.println("Ba�lant� Ba�ar�l�...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Ba�lant� Ba�ar�s�z...");
			e.printStackTrace();
		}
	}

}
