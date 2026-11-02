package calisma2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> dersler = new ArrayList<>();
	static ArrayList<Integer> notlar = new ArrayList<>();
	
	public static void main(String[] args) {
		ListeleriOlustur(dersler, notlar);
		OrtalamadanBuyukler(dersler, notlar);
		EnYuksekNot(dersler, notlar);
		EnDusukNot(dersler, notlar);

	}
	
	public static void ListeleriOlustur(ArrayList<String> dersler, ArrayList<Integer> notlar) {
		for(int i=0; i<5; i++) {
			String dersAdi;
			boolean ayni;
			
			do {
				ayni = false;
				System.out.print("\n" + (i+1) + ". Ders adını giriniz: ");
				dersAdi = scanner.nextLine();
				if(i==0) break;
				for(int j=0; j<dersler.size(); j++) {
					if(dersler.get(j).equalsIgnoreCase(dersAdi)){
						System.out.println("Farklı bir ders adı giriniz!");
						ayni = true;
						break;
					}
				}
			}while(ayni);
			
			System.out.print("Ders notu giriniz: ");
			int dersNotu = scanner.nextInt();
			scanner.nextLine();
			dersler.add(dersAdi);
			notlar.add(dersNotu);
		}
	}
	
	public static double Ortalama(ArrayList<Integer> notlar) {
		int toplam = 0;
		int dersSayisi = 0;
		double ortalama;
		for (Integer not : notlar) {
			toplam += not;
			dersSayisi++;
		}
		ortalama = toplam / dersSayisi;
		return ortalama;
	}

	public static void OrtalamadanBuyukler(ArrayList<String> dersler,ArrayList<Integer> notlar) {
		double ortalama = Ortalama(notlar);
		System.out.println("\nOrtalamadan Büyük Dersler:");
		for (int i = 0; i < dersler.size(); i++) {
			if(notlar.get(i) > ortalama) {
				System.out.println(dersler.get(i).toUpperCase());
			}
		}
	}

	public static void EnYuksekNot(ArrayList<String> dersler,ArrayList<Integer> notlar) {
		int enYuksekNot = notlar.get(0);
		int enYuksekNotIndex = 0;
		for(int i=1; i<dersler.size(); i++) {
			if(notlar.get(i) > enYuksekNot) {
				enYuksekNot = notlar.get(i);
				enYuksekNotIndex = i;
			}
		}
		
		System.out.println("\nEn yüksek not: " + enYuksekNot + " (" + dersler.get(enYuksekNotIndex) + ")");
	}

	public static void EnDusukNot(ArrayList<String> dersler,ArrayList<Integer> notlar) {
		int enDusukNot = notlar.get(0);
		int enDusukNotIndex = 0;
		for(int i=1; i<dersler.size(); i++) {
			if(notlar.get(i) < enDusukNot) {
				enDusukNot = notlar.get(i);
				enDusukNotIndex = i;
			}
		}
		
		System.out.println("En düşük not: " + enDusukNot + " (" + dersler.get(enDusukNotIndex) + ")");
	}
}
