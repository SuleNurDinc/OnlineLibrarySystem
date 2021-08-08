import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseProcess {
	static String url = "jdbc:postgresql://localhost:5432/LibrarySystem";
	static Connection conn=null;
	static void connection() {
		try {
		conn = DriverManager.getConnection(url,"postgres","12345");
		}
		catch( SQLException e ){
			e.printStackTrace();
		}
	}
	
	static boolean KayitVarMi(User user) {
		String sorgu="select * from users";
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			while(rs.next()) {
				if(rs.getString("Name").equals(user.getName()) &&  rs.getString("Surname").equals(user.getSurname()) && rs.getString("Email").equals(user.getEmail()) && rs.getString("Password").equals(user.getPassword()))
				return true;
			}
			return false;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
			
		}
		
		
	}
	
	static void Listele() {
		String sorgu="select * from books";
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			int i=1;
			while(rs.next()) {
				System.out.println(i+". Kitap: "+ rs.getString("Name") + " ");
				System.out.println("Yazar Adý: "+ rs.getString("Author")+ " ");
				System.out.println("Kitabýn Türü: " +rs.getString("Type"));
				System.out.println("Kitabýn Sayfa Sayýsý: " +rs.getInt("Page Number"));
				
				i++;
			}
					
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
	}
	
	
	static void Filtre(String filterType, String filter) {
		
		String sorgu="select * from books where " + "\""+filterType +"\""+ " = '" + filter + "'" ;
	
		
		try {
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sorgu);
			int i=1;
			while(rs.next()) {
				if(filterType=="Name") System.out.println("Kitabýn adý: "+ rs.getString("Name") + " ");
				else System.out.println(i+". Kitap: "+ rs.getString("Name") + " ");		
				System.out.println("Yazar Adý: "+ rs.getString("Author")+ " ");
				System.out.println("Kitabýn Türü: " +rs.getString("Type"));
				System.out.println("Kitabýn Sayfa Sayýsý " +rs.getInt("Page Number"));
				if(filterType=="Name") System.out.println(rs.getString("Pdf"));
				i++;
			}
			if(i==1) System.out.println(rs.getInt("Aradýðýnýz kritere ait kitap bulunamamýþtýr..."));
					
		}
		catch(SQLException e) {
			e.printStackTrace();
			
			
		}
		
		
	}
	
	
}
