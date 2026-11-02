package quiz3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception{
		File dosya = new File("src/urunler.txt");
		ArrayList<Urun> liste = ListeOlustur(dosya);
		Yazdir(liste);
		System.out.println("\n Swap Sonrası: ");
		Swap(liste);

	}
	
	public static ArrayList<Urun> ListeOlustur(File dosya) throws Exception{
		ArrayList<Urun> UrunlerListesi = new ArrayList<>();
		FileReader dosyaOkuyucu = new FileReader(dosya);
		BufferedReader buffered = new BufferedReader(dosyaOkuyucu);
		
		String line;
		while((line = buffered.readLine()) != null) {
			if(line.trim().isEmpty()) continue;
			String[] veriler = line.split(" ");
			if(veriler.length >=5) {
				int no = Integer.valueOf(veriler[0]);
				String urunAdi = veriler[1];
				double fiyat = Double.valueOf(veriler[2]);
				int stok = Integer.valueOf(veriler[3]);
				String MenseiUlke = veriler[4];
				double ToplamDeger = fiyat * stok;
				
				Urun yeniUrun = new Urun(no, urunAdi, fiyat, stok, MenseiUlke, ToplamDeger);
				UrunlerListesi.add(yeniUrun);
			}
		}
		buffered.close();
		return UrunlerListesi;
	}

	public static void Yazdir(ArrayList<Urun> liste) {
		System.out.println("| No | AletAdi | Fiyat | Stok | MenseiUlke | ToplamDeger |");
		for (Urun urun : liste) {
			System.out.println("| " + urun.No + " | " + urun.AletAdi + " | " + urun.Fiyat + " | " + urun.Stok + " | " + urun.MenseiUlke + " | " + urun.ToplamDeger+ "|");
		}
	}
	
	public static ArrayList<Urun> Swap(ArrayList<Urun> liste) {
		double enYuksek = liste.get(0).ToplamDeger;
		int enYuksekIndex = 0;
		
		double enDusuk = liste.get(0).ToplamDeger;
		int enDusukIndex = 0;
		
		for (int i = 1; i < liste.size(); i++) {
			if(enDusuk < liste.get(i).ToplamDeger) {
				enDusuk = liste.get(i).ToplamDeger;
				enDusukIndex = i;
			}
			
			if(enYuksek > liste.get(i).ToplamDeger) {
				enYuksek = liste.get(i).ToplamDeger;
				enYuksekIndex = i;
			}
		}
		
		Urun yedek = liste.get(enDusukIndex);
		liste.set(enDusukIndex, liste.get(enYuksekIndex));
		liste.set(enYuksekIndex, yedek);
		
		Yazdir(liste);
		return liste;
	}
}
