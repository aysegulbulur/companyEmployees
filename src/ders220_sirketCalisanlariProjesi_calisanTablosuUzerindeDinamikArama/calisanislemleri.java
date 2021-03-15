package ders220_sirketCalisanlariProjesi_calisanTablosuUzerindeDinamikArama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class calisanislemleri {
	
	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	public ArrayList<calisan> calisanlariGetir(){
		ArrayList<calisan> cikti = new ArrayList<calisan>();
		
		try {
			statement = con.createStatement();
			
			String sorgu = "Select * From calisanlar";
			
			ResultSet rs = statement.executeQuery(sorgu);
			
			while(rs.next()){
				int id = rs.getInt("id");
				String ad = rs.getString("ad");
				String soyad = rs.getString("soyad");
				String departman = rs.getString("departman");
				String maas = rs.getString("maas");
				
				cikti.add(new calisan(id, ad, soyad, departman, maas));
			}
			return cikti;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean girisYap(String kullaniciAdi, String parola){
		String sorgu = "Select * From adminler where username = ? and password = ?";
		
		try {
			preparedStatement = con.prepareStatement(sorgu);
			
			preparedStatement.setString(1, kullaniciAdi);
			preparedStatement.setString(2, parola);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			/*if(rs.next() == false){
				//kullanýcý adý ve parola yoksa
				return false;	//o deðer yok.
			}
			else{
				return true;	//kullanýcý adý ve parola var.
			}*/ 
			
			return rs.next();	//if-else bloðunun alternatifi.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;	//herhangi bir exception olma durumunda false deðer döndürecek.
		}
	}
	
	public calisanislemleri(){
		String url = "jdbc:mysql://" + database.host + ":" + database.port + "/" + database.db;
		//jdbc:mysql://localhost:3306/deneme
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
				//baðlantý için gerekli olan Driver baþlatýlmalý yoksa hata verebilir.
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver Bulunamadý...");
				//veri tabaný eklenmemiþ olursa bu hatayý verir.
		}
		
		try {
			con = DriverManager.getConnection(url, database.kullaniciAdi, database.parola);
			System.out.println("Baðlantý Baþarýlý...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("Baðlantý Baþarýsýz...");
			e.printStackTrace();
		}
	}

}
