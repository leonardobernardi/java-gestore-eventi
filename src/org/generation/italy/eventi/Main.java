package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
		System.out.println("Inserire nome evento: ");
		String nome = input.nextLine();
		System.out.println("Inserire giorno evento: ");
		String giorno = input.nextLine();
		System.out.println("Inserire mese evento: ");
		String mese = input.nextLine();
		System.out.println("Inserire anno evento: ");
		String anno = input.nextLine();
		String data = giorno + "/" + mese + "/" + anno;
		System.out.println("Inserire totale posti: ");
		int postiTotale = input.nextInt();
		
		
			try {
				Evento evento1 = new Evento(nome, LocalDate.parse(data, formatter), postiTotale);
				System.out.println("Inserire il numero delle prenotazioni desiderate (0 per nessuna): ");
				int counter = input.nextInt();
				while(counter > 0) {
					try {
						evento1.prenota();
						counter--;
					} catch (IllegalArgumentException e) {
						System.out.println("Errore: " + e.getMessage());
					} catch (Exception eA) {
						System.out.println("Errore: " + eA.getMessage());
					} 
				}
				System.out.println("Posti prenotati: " + evento1.getPostiPrenotati());
				System.out.println("Posti disponibili: " + (postiTotale - evento1.getPostiPrenotati()));
				System.out.println("Inserire il numero delle prenotazioni da disdire (0 per nessuna): ");
				counter = input.nextInt();
				while(counter > 0) {
					try {
						evento1.disdici();
						counter--;
					} catch (IllegalArgumentException e) {
						System.out.println("Errore: " + e.getMessage());
					} catch (Exception eA) {
						System.out.println("Errore: " + eA.getMessage());
					} 
					System.out.println("Posti prenotati: " + evento1.getPostiPrenotati());
					System.out.println("Posti disponibili: " + (postiTotale - evento1.getPostiPrenotati()));
				}
			}catch (IllegalArgumentException e) {
					System.out.println("Si e' verificato un errore: " + e.getMessage());
			}catch (Exception eA) {
					System.out.println("Si e' verificato un errore: " + eA.getMessage()); 
					}
		
			
		
			input.close();
	}
}
