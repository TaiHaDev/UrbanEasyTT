package util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Ultilities {
    public static List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        if (calendar.getTime().equals(endDate)) {
        	dates.add(startDate);
        	return dates;
        } else {
        	calendar.add(Calendar.DATE, 1);
        }
        while (calendar.getTime().before(endDate)) {
            Date result = new Date(calendar.getTimeInMillis());
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return dates;
    }
    public static List<String> reformatDates(List<Date> dates) {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	return dates.stream().map(elem -> format.format(elem)).collect(Collectors.toList());
    }
    public static String reformatDate(Date date) {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    	return format.format(date);
    }
}
