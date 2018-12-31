package com.travix.medusa.busyflights.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.validation.Errors;

public class DateValidator {

	public static boolean isDateValid(Errors errors, String dateOfInterest) {
		boolean isValid = true;
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date cd = null; // current date
		Date doi = null; // date of interest

		try {
			cd = sdf.parse(sdf.format(new Date()));
			;
			doi = sdf.parse(dateOfInterest);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		long diff = cd.getTime() - doi.getTime();
		int diffDays = (int) (diff / (24 * 1000 * 60 * 60));

		if (diffDays > 0) {
			isValid = false;
		} else {
			isValid = true;
		}
		return isValid;
	}
}
