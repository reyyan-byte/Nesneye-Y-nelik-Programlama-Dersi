package quiz4;

import java.util.ArrayList;

public class YapiMalzemesi extends Malzeme{

	String KullanimAlani;
	
	public YapiMalzemesi(String Adi, int KategoriIndex, double BirimAgirligi,
			double BirimFiyati, int StokMiktari, String KullanimAlani) {
		super(Adi, 2, BirimAgirligi, BirimFiyati, StokMiktari);
		this.KullanimAlani = KullanimAlani;
	}
	
	 public static void EnPahaliStokGuncelle(ArrayList<YapiMalzemesi> liste, 
			 int yeniStok) {
		 double enPahali = liste.get(0).BirimFiyati;
		 int enPahaliIndex = 0;
		 for (int i=1; i<liste.size();i++) {
			if(liste.get(i).BirimFiyati > enPahali) {
				enPahali = liste.get(i).BirimFiyati;
				enPahaliIndex = i;
			}
		}
		 
		 liste.get(enPahaliIndex).StokMiktari += yeniStok;
		 System.out.println("\n" +liste.get(enPahaliIndex).Adi + " ürününün stok miktarı arttırıldı..."
		 		+ "\nYeni stok miktarı: " + liste.get(enPahaliIndex).StokMiktari);
		 
	 }
	 
	 public static void YapiYazdir(ArrayList<YapiMalzemesi> liste) {
		 System.out.println("\nYapı Malzemesi Listesi: ");
			for (YapiMalzemesi malzeme : liste) {
				System.out.println(malzeme.Adi + " "+ malzeme.KategoriIndex + " " + malzeme.BirimAgirligi + " " + malzeme.BirimFiyati + " " + malzeme.StokMiktari);
			}
	}

}
