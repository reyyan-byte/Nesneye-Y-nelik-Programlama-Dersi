package quiz4;

import java.util.ArrayList;

public class InsaatMalzemesi extends Malzeme{

	String KullanimYeri;
	public InsaatMalzemesi(String Adi, int KategoriIndex, double BirimAgirligi,
			double BirimFiyati, int StokMiktari, String KullanimYeri) {
		super(Adi, 3, BirimAgirligi, BirimFiyati, StokMiktari);
		this.KullanimYeri = KullanimYeri;
	}
	
	public static void InsaatYazdir(ArrayList<InsaatMalzemesi> liste) {
		 System.out.println("\nInsaat Malzemesi Listesi: ");
		for (InsaatMalzemesi malzeme : liste) {
			System.out.println(malzeme.Adi + " "+ malzeme.KategoriIndex + " " + malzeme.BirimAgirligi + " " + malzeme.BirimFiyati + " " + malzeme.StokMiktari);
		}
	}
		public static void EnPahaliSil(ArrayList<InsaatMalzemesi> liste) {
			 double enPahali = liste.get(0).BirimFiyati;
			 int enPahaliIndex = 0;
			 for (int i=1; i<liste.size();i++) {
				if(liste.get(i).BirimFiyati > enPahali) {
					enPahali = liste.get(i).BirimFiyati;
					enPahaliIndex = i;
				}
			}
			 System.out.println("\n" + liste.get(enPahaliIndex).Adi +" ürünü silindi...");
			 liste.remove(liste.get(enPahaliIndex)); 
			 
		 }
}

