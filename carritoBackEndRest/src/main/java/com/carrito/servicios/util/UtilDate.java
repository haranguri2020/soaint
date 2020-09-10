package com.carrito.servicios.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

	public final static DateFormat dateTimeFormatDefault = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static String formatDateYYYYMMDD = "yyyyMMdd";
	public final static String formatDateYYYYMMDD_HHMMSS = "yyyyMMdd_HHmmss";
	public final static String formatDateTime = "yyyy-MM-dd'T'HH:mm:ssXXX";

	public static void main(String[] args) {
		String fecha = UtilDate.convertDateToString(new Date(), formatDateYYYYMMDD_HHMMSS);
		System.out.println(fecha);
	}

	public static String obtenerFechaFormatoDefault(Date fecha) {
		return dateTimeFormatDefault.format(fecha);
	}

	public static String formatoFechaDisponible(String fechaAS) {
		String dia, mes, anio, fecFin;
		int mesNum;
		anio = fechaAS.substring(0, 4);
		mes = fechaAS.substring(4, 6);
		mesNum = Integer.valueOf(mes);
		dia = fechaAS.substring(6, 8);
		switch (mesNum) {
		case 1:
			mes = "Ene";
			break;
		case 2:
			mes = "Feb";
			break;
		case 3:
			mes = "Mar";
			break;
		case 4:
			mes = "Abr";
			break;
		case 5:
			mes = "May";
			break;
		case 6:
			mes = "Jun";
			break;
		case 7:
			mes = "Jul";
			break;
		case 8:
			mes = "Ago";
			break;
		case 9:
			mes = "Set";
			break;
		case 10:
			mes = "Oct";
			break;
		case 11:
			mes = "Nov";
			break;
		case 12:
			mes = "Dic";
			break;
		}
		fecFin = "(Saldos al " + dia + "/" + mes + "/" + anio + ")";
		return fecFin;
	}

	public static String formatoFechaMillas(String fechaAS) {
		String dia, mes, anio, fecFin;
		int mesNum;
		anio = fechaAS.substring(0, 4);
		mes = fechaAS.substring(4, 6);
		mesNum = Integer.valueOf(mes);
		dia = fechaAS.substring(6, 8);
		switch (mesNum) {
		case 1:
			mes = "Ene";
			break;
		case 2:
			mes = "Feb";
			break;
		case 3:
			mes = "Mar";
			break;
		case 4:
			mes = "Abr";
			break;
		case 5:
			mes = "May";
			break;
		case 6:
			mes = "Jun";
			break;
		case 7:
			mes = "Jul";
			break;
		case 8:
			mes = "Ago";
			break;
		case 9:
			mes = "Set";
			break;
		case 10:
			mes = "Oct";
			break;
		case 11:
			mes = "Nov";
			break;
		case 12:
			mes = "Dic";
			break;
		}
		fecFin = "(Millas al " + dia + "/" + mes + "/" + anio + ")";
		return fecFin;
	}

	public static String fechaHoyYYYYMMDD() {
		StringBuilder sb = new StringBuilder();
		Calendar c = Calendar.getInstance();
		sb.append(c.get(Calendar.YEAR));
		sb.append((c.get(Calendar.MONTH) + 1) < 10 ? "0" + (c.get(Calendar.MONTH) + 1) : c.get(Calendar.MONTH) + 1);
		sb.append(
				c.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + c.get(Calendar.DAY_OF_MONTH) : c.get(Calendar.DAY_OF_MONTH));
		return sb.toString();
	}

	public static String horaActualHHMMSS() {
		StringBuilder sb = new StringBuilder();
		Calendar c = Calendar.getInstance();
		sb.append(c.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + c.get(Calendar.HOUR_OF_DAY) : c.get(Calendar.HOUR_OF_DAY));
		sb.append(c.get(Calendar.MINUTE) < 10 ? "0" + c.get(Calendar.MINUTE) : c.get(Calendar.MINUTE));
		sb.append(c.get(Calendar.SECOND) < 10 ? "0" + c.get(Calendar.SECOND) : c.get(Calendar.SECOND));
		return sb.toString();
	}

	public static String dayOfYear() {
		StringBuilder sb = new StringBuilder();
		Calendar c = Calendar.getInstance();
		sb.append(c.get(Calendar.DAY_OF_YEAR));
		return sb.toString();
	}

	public static Date convertStringToDate(String fecha, String formato) {
		Date fechaRetorno = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			fechaRetorno = sdf.parse(fecha);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fechaRetorno;
	}

	public static String convertStringToDateString(String fecha, String formatoOrigen, String formatoSalida) {
		String fechaRetorno = "";
		try {
			if (fecha == null || fecha.isEmpty()) {
				fechaRetorno = "";
			} else {
				SimpleDateFormat sdfOrigen = new SimpleDateFormat(formatoOrigen);
				SimpleDateFormat sdfSalida = new SimpleDateFormat(formatoSalida);
				Date fechaOrigen = sdfOrigen.parse(fecha);
				fechaRetorno = sdfSalida.format(fechaOrigen);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fechaRetorno;
	}

	public static String convertDateToString(Date fecha, String formato) {
		String fechaRetorno = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			fechaRetorno = sdf.format(fecha);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fechaRetorno;
	}

	public static long getCurrentDateTime() {
		return System.currentTimeMillis();
	}

	public static String obtenerTiempoUTC() {
		long tiempoUTC = System.currentTimeMillis() / 1000;
		return String.valueOf(tiempoUTC);
	}

	public static boolean vencioFechaAlmacenamientoCache(Date fechaConsulta) {
		Date fechaActual = new Date();
		// SETEAMOS LA FECHA ACTUAL
		Calendar calendarFechaActual = Calendar.getInstance();
		calendarFechaActual.setTime(fechaActual);

		// SETEAMOS LA FECHA DE VENCIMIENTO DE CACHE
		Calendar calendarFechaVencimiento = Calendar.getInstance();
		calendarFechaVencimiento.setTime(fechaActual);
		calendarFechaVencimiento.set(Calendar.HOUR_OF_DAY, Globales.CACHE_USUARIO_HORA_FENCIMIENTO);
		calendarFechaVencimiento.set(Calendar.MINUTE, Globales.CACHE_USUARIO_MINUTO_FENCIMIENTO);
		calendarFechaVencimiento.set(Calendar.SECOND, 0);

		// SETEAMOS LA FECHA DE ALMACENAMIENTO EN CACHE
		Calendar calendarFechaConsulta = Calendar.getInstance();
		calendarFechaConsulta.setTime(fechaConsulta);

		if (calendarFechaActual.after(calendarFechaVencimiento)
				&& calendarFechaConsulta.before(calendarFechaVencimiento)) {
			// SI LA FECHA ACTUAL SUPERO LA FECHA DE VENCIMIENTO Y
			// LA ULTIMA FECHA DEL CACHE ES MENOR QUE LA FECHA DE VENCIMIENTO
			// TRAEMOS LA DATA LOCAL
			return true;
		} else {
			return false;
		}
	}
}
