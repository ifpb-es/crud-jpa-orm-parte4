package br.edu.ifpb.es.daw.util;

import org.hibernate.collection.spi.PersistentBag;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {

	public static Date getDate(int ano, int mes, int dia) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.MONTH, mes);
		cal.set(Calendar.DAY_OF_MONTH, dia);
		
		return cal.getTime();
	}

	/*
	 * Explicação para a necessidade deste método auxiliar para comparar as listas:
	 * https://forum.hibernate.org/viewtopic.php?f=9&t=971056
	 * https://hibernate.atlassian.net/browse/HHH-5409
	 */
	public static <E> boolean equals(List<E> l1, List<E> l2) {
		l1 = getNotPersistentBagList(l1);
		l2 = getNotPersistentBagList(l2);
		return l1.equals(l2);
	}
	
	private static <E> List<E> getNotPersistentBagList(List<E> list) {
		return list instanceof PersistentBag ? new ArrayList<E>(list) : list;
	}

}
