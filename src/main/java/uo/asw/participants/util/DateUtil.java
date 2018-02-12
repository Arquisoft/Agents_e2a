package uo.asw.participants.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase de utilidad para fechas
 *
 */
public class DateUtil {

	/**
	 * Calcula la edad a patir de la fecha de nacimiento
	 * @param fechaNacimiento
	 * @return anyos de la persona
	 */
	public static int getYears(Date fechaNacimiento) {

		Calendar fechaActual = Calendar.getInstance();
		int hoyDia = fechaActual.get(Calendar.DAY_OF_YEAR);

		Calendar nacimiento = Calendar.getInstance();

		nacimiento.setTime(fechaNacimiento);
		int nacimientoDia = nacimiento.get(Calendar.DAY_OF_YEAR);

		// Todavía no ha cumplido los años
		if (nacimientoDia - hoyDia < 0)
			return fechaActual.get(Calendar.YEAR)
					- nacimiento.get(Calendar.YEAR) - 1;
		else
			// Ya ha cumplido los años
			return fechaActual.get(Calendar.YEAR)
					- nacimiento.get(Calendar.YEAR);

	}
}
