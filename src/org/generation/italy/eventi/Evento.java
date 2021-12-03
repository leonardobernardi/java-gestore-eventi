package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
			
	private String titolo;
	private LocalDate data;
	private int postiTotale;
	private int postiPrenotati = 0;
	
	public Evento(String titolo, LocalDate data, int postiTotale) throws IllegalArgumentException, Exception{
		this.titolo = titolo;
		if(isValidDate(data)){
			this.data = data;
		}else {
			//errore
			throw new IllegalArgumentException("Data non valida");
		}
		if(isValidPosti(postiTotale)){
			this.postiTotale = postiTotale;
		}else {
			//errore
			throw new Exception("Posti inferiori a 1");
		}
	}
	
	
	//getters and setters
	public String getTitolo() {
		return titolo;
	}





	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}





	public LocalDate getData() {
		return data;
	}





	public void setData(LocalDate data) {
		this.data = data;
	}





	public int getPostiTotale() {
		return postiTotale;
	}





	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	//metodi public
	
	public String dataFormattata() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
		return data.format(formatter);
	}
	public void prenota() throws IllegalArgumentException, Exception{
		if(!isValidDate(this.data)) {
			throw new IllegalArgumentException("L'evento evento è già passato");
		}else if(!isValidPosti(this.postiTotale)) {
			throw new Exception("Posti esauriti");
		}
		this.postiPrenotati += 1;
	}

	public void disdici() throws IllegalArgumentException, Exception {
		if(!isValidDate(this.data)) {
			throw new IllegalArgumentException("L'evento evento è già passato");
		}else if(this.postiPrenotati < 1) {
			throw new Exception("Non ci sono posti prenotati");
		}		
		this.postiPrenotati -= 1;
	}

	@Override
	public String toString() {
		return dataFormattata() + "-" + titolo;
	}


	//metodi private
	private boolean isValidDate(LocalDate dataDaValidare){
		return dataDaValidare.isAfter(LocalDate.now());
	}
	private boolean isValidPosti (int postiDaValidare) {
		return postiDaValidare > 0;
	}
	
}
