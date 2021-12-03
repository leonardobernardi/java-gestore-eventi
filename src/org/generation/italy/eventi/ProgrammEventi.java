package org.generation.italy.eventi;

import java.math.MathContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;


@SuppressWarnings("unused")
public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();
	}
	
	public void add(Evento e) {
		eventi.add(e);
	}
	

	public String eventsInDate(LocalDate d) {
		List<Evento> eventsInDateList = new ArrayList<Evento>();
		for(Evento e : eventi) {
			if(e.getData().isEqual(d)) {
				eventsInDateList.add(e);
			} 
		}
		return eventsInDateList.toString();
	}
	
	public int quantity() {
		return eventi.size();
	}
	
	public void clear() {
		eventi.clear();
	}


	public String listOrdinata() {
		String oList = this.titolo;
		Collections.sort(eventi);
		for (Evento e : eventi) {
			oList = oList + "\n" + e.getData() + "-" + e.getTitolo();
		}return oList;
	}
	
}
