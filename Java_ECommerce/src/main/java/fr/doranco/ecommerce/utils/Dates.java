package fr.doranco.ecommerce.utils;

import java.text.SimpleDateFormat;

public final class Dates {

	private Dates() {
	}

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static final java.util.Date stringToDateUtil(String dateStr) throws Exception {

		if (dateStr == null || dateStr.trim().isEmpty()) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL ou vide !");
		}
		return formatter.parse(dateStr);
	}

	public static final String dateUtilToString(java.util.Date date) throws Exception {
		
		if (date == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return formatter.format(date);
	}

	public static final java.util.Date dateSqlToDateUtil(java.sql.Date sqlDate) throws Exception {
		if (sqlDate == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return new java.util.Date(sqlDate.getTime());
	}

	public static final java.sql.Date dateUtilToDateSql(java.util.Date utilDate) throws Exception {
		if (utilDate == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return new java.sql.Date(utilDate.getTime());
	}

}