package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		int giorno = 0;
		int mese = 0;
		int anno = 0;
		
		System.out.println("Inserire nome evento: ");
		String nome = input.nextLine();
		System.out.println("Inserire giorno evento: ");
		giorno = input.nextInt();
		System.out.println("Inserire mese evento: ");
		mese = input.nextInt();
		System.out.println("Inserire anno evento: ");
		anno = input.nextInt();
		System.out.println("Inserire totale posti: ");
		int postiTotale = input.nextInt();
		
		
			try {
				Evento evento1 = new Evento(nome, LocalDate.of(anno, mese, giorno), postiTotale);
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
		
			
		
		
		
		//PROVE ALTRE CLASSI
		
		
//		ProgrammEventi prog = new ProgrammEventi("prova");
//		try {
//			prog.add(new Evento("prova6", LocalDate.of(2233, 11,12), 100));
//		} catch (IllegalArgumentException e) {
//			
//			e.printStackTrace();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		try {
//			prog.add(new Evento("prova1", LocalDate.of(2233, 11, 12), 100));
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			prog.add(new Evento("prova2", LocalDate.of(2233, 11, 12), 100));
//		} catch (IllegalArgumentException e) {
//			
//			e.printStackTrace();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//		try {
//			prog.add(new Evento("prova3", LocalDate.of(2233, 11, 11), 100));
//		} catch (IllegalArgumentException e) {
//			
//			e.printStackTrace();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//	System.out.println(prog.listOrdinata());
//		System.out.println(prog.eventsInDate);
		
//		try {
//			Concerto concerto = new Concerto("prova", LocalDate.of(2233, 11, 11), 100, LocalTime.of(10, 30), new BigDecimal(10.5));
//			System.out.println(concerto.toString());
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
		
			
	}
}
