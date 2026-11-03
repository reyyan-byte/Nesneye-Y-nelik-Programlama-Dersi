package quiz4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args)throws Exception {
		
		File dosya = new File("src/envanter");
		ArrayList<YapiMalzemesi> yapiListe = YapiListeOlustur(dosya);
		ArrayList<InsaatMalzemesi> insaatListe = InsaatListeOlustur(dosya);
		YapiMalzemesi.YapiYazdir(yapiListe);
		InsaatMalzemesi.InsaatYazdir(insaatListe);
		
		YapiMalzemesi.EnPahaliStokGuncelle(yapiListe, 5);
		InsaatMalzemesi.EnPahaliSil(insaatListe);
		

	}
	
	public static ArrayList<YapiMalzemesi> YapiListeOlustur(File dosya)throws Exception{
		FileReader dosyaOkuyucu = new FileReader(dosya);
		BufferedReader buffered = new BufferedReader(dosyaOkuyucu);
		
		ArrayList<YapiMalzemesi> YapiMalzemesiListesi = new ArrayList<>();
		String line;
		while((line = buffered.readLine()) != null) {
			if(line.trim().isEmpty()) continue;
			String[] veriler = line.split(",");
			
			if(veriler.length >= 5) {
				int kategoriIndex = Integer.valueOf(veriler[1]);
				if(kategoriIndex == 2) {
					String Adi = veriler[0];
					double BirimAgirligi = Double.valueOf(veriler[2]);
					double BirimFiyati = Double.valueOf(veriler[3]);
					int StokMiktari = Integer.valueOf(veriler[4]);
					YapiMalzemesi yeniUrun = new YapiMalzemesi(Adi, kategoriIndex, BirimAgirligi, BirimFiyati, StokMiktari, Adi);
					YapiMalzemesiListesi.add(yeniUrun);
				}
			}
			
		}
		return YapiMalzemesiListesi;
	}
	
	public static ArrayList<InsaatMalzemesi> InsaatListeOlustur(File dosya)throws Exception{
		FileReader dosyaOkuyucu = new FileReader(dosya);
		BufferedReader buffered = new BufferedReader(dosyaOkuyucu);
		
		ArrayList<InsaatMalzemesi> InsaatMalzemesiListesi = new ArrayList<>();
		String line;
		while((line = buffered.readLine()) != null) {
			if(line.trim().isEmpty()) continue;
			String[] veriler = line.split(",");
			
			if(veriler.length >= 5) {
				int kategoriIndex = Integer.valueOf(veriler[1]);
				if(kategoriIndex == 3) {
					String Adi = veriler[0];
					double BirimAgirligi = Double.valueOf(veriler[2]);
					double BirimFiyati = Double.valueOf(veriler[3]);
					int StokMiktari = Integer.valueOf(veriler[4]);
					InsaatMalzemesi yeniUrun = new InsaatMalzemesi(Adi, kategoriIndex, BirimAgirligi, BirimFiyati, StokMiktari, Adi);
					InsaatMalzemesiListesi.add(yeniUrun);
				}
			}
			
		}
		return InsaatMalzemesiListesi;
	}
	

}
