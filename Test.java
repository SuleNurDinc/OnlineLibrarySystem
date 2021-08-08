//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		DatabaseProcess.connection();
		Scanner scan = new Scanner(System.in);
		System.out.println("E-Kütüphane Sistemine Hoþgeldiniz.");
		System.out.println("Lütfen Sisteme Giriþ yapmak için bilgilerinizi giriniz...");
		System.out.print("Ýsim: ");
		String Name = scan.nextLine();
		System.out.print("Soyisim: ");
		String Surname = scan.nextLine();
		System.out.print("E-Mail: ");
		String Email = scan.nextLine();
		System.out.print("Þifre: ");
		String Password = scan.nextLine();	
		User user1 = new User(Name,Surname,Email,Password);
		
		if(DatabaseProcess.KayitVarMi(user1)) { System.out.println("Sisteme hosgeldiniz..."); menu();}
		else {
			System.out.println("Sistemde kaydiniz bulunmamaktadýr... Lütfen Kayýt olunuz...");
			System.out.print("Lütfen isminizi giriniz: ");
			Name = scan.nextLine();
			System.out.print("Lütfen Soyisminizi giriniz: ");
			Surname = scan.nextLine();
			System.out.print("Lütfen mail adresinizi giriniz: ");
			Email = scan.nextLine();
			System.out.print("Þifre: Lütfen Þifrenizi giriniz: ");
			Password = scan.nextLine();	
			
			
		
		}
		scan.close();
		
		 
		
		 
	}
	
	static void menu() {
			
		DatabaseProcess.connection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Yapmak istediðiniz iþlemi giriniz...");
		System.out.println("Tüm kitaplarý listelemek için 1'e \nYazara göre arama yapmak için 2'ye\nTüre göre arama yapmak için 3'e,\nOkumak istediðiniz kitabý adýný aramak için 4'e basýnýz\nÇýkmak için 5'e basýnýz...");
		int process = scanner.nextInt();
		if(process==1) {DatabaseProcess.Listele(); menu();}
		if(process==2) {
			System.out.println("Arama yapmak istediðiniz yazarýn adýný giriniz...");
			scanner.nextLine();
			String authorName = scanner.nextLine();
			
			DatabaseProcess.Filtre("Author",authorName); 
			menu();
		}
		if(process==3)
		{
			System.out.println("Arama yapmak istediðiniz türü  giriniz...");
			scanner.nextLine();
			String type = scanner.nextLine();
			
			DatabaseProcess.Filtre("Type",type); 
			menu();
		}
		
		if(process==4)
		{
			System.out.println("Aradýðýnýz Kitabýn adýný giriniz");
			scanner.nextLine();
			String bookName = scanner.nextLine();
			
			DatabaseProcess.Filtre("Name",bookName); 
			menu();
		}
		else if(process==5) {
			scanner.close();
			System.exit(0);

		}
		else {
			System.out.println("Lütfen geçerli bir iþlem giriniz..."); menu();
		}
		
						
	}
	
	
}
