package ders217_sirketCalisanlariProjesi_veriTabaniHazirlamaUygulamaSabitleriVeriTabaniBaglantisi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class calisanislemleri {
	
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
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
