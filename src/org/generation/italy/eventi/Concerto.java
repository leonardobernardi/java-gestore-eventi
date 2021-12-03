package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{

	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int postiTotale, LocalTime ora, BigDecimal prezzo)
			throws IllegalArgumentException, Exception {
		super(titolo, data, postiTotale);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String dataOraFormattata() {
		return getOra() + " " + dataFormattata();
	}
	
	public BigDecimal prezzoFormattato() {		
		return prezzo.setScale(2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return dataOraFormattata() + "-" + getTitolo() + "-" + prezzoFormattato() + "€";
	}
	
	

}
