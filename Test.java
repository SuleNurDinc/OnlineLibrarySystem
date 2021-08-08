//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		DatabaseProcess.connection();
		Scanner scan = new Scanner(System.in);
		System.out.println("E-K�t�phane Sistemine Ho�geldiniz.");
		System.out.println("L�tfen Sisteme Giri� yapmak i�in bilgilerinizi giriniz...");
		System.out.print("�sim: ");
		String Name = scan.nextLine();
		System.out.print("Soyisim: ");
		String Surname = scan.nextLine();
		System.out.print("E-Mail: ");
		String Email = scan.nextLine();
		System.out.print("�ifre: ");
		String Password = scan.nextLine();	
		User user1 = new User(Name,Surname,Email,Password);
		
		if(DatabaseProcess.KayitVarMi(user1)) { System.out.println("Sisteme hosgeldiniz..."); menu();}
		else {
			System.out.println("Sistemde kaydiniz bulunmamaktad�r... L�tfen Kay�t olunuz...");
			System.out.print("L�tfen isminizi giriniz: ");
			Name = scan.nextLine();
			System.out.print("L�tfen Soyisminizi giriniz: ");
			Surname = scan.nextLine();
			System.out.print("L�tfen mail adresinizi giriniz: ");
			Email = scan.nextLine();
			System.out.print("�ifre: L�tfen �ifrenizi giriniz: ");
			Password = scan.nextLine();	
			
			
		
		}
		scan.close();
		
		 
		
		 
	}
	
	static void menu() {
			
		DatabaseProcess.connection();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Yapmak istedi�iniz i�lemi giriniz...");
		System.out.println("T�m kitaplar� listelemek i�in 1'e \nYazara g�re arama yapmak i�in 2'ye\nT�re g�re arama yapmak i�in 3'e,\nOkumak istedi�iniz kitab� ad�n� aramak i�in 4'e bas�n�z\n��kmak i�in 5'e bas�n�z...");
		int process = scanner.nextInt();
		if(process==1) {DatabaseProcess.Listele(); menu();}
		if(process==2) {
			System.out.println("Arama yapmak istedi�iniz yazar�n ad�n� giriniz...");
			scanner.nextLine();
			String authorName = scanner.nextLine();
			
			DatabaseProcess.Filtre("Author",authorName); 
			menu();
		}
		if(process==3)
		{
			System.out.println("Arama yapmak istedi�iniz t�r�  giriniz...");
			scanner.nextLine();
			String type = scanner.nextLine();
			
			DatabaseProcess.Filtre("Type",type); 
			menu();
		}
		
		if(process==4)
		{
			System.out.println("Arad���n�z Kitab�n ad�n� giriniz");
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
			System.out.println("L�tfen ge�erli bir i�lem giriniz..."); menu();
		}
		
						
	}
	
	
}
