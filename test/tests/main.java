package tests;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class main {

	
	
	  private static LocalDateTime fechaIniciada= LocalDateTime.now();
	  private static LocalDateTime fechaFinalizada= fechaIniciada.plusHours(8);
	  public static void main(String[] args) {
	    System.out.println(fechaIniciada); 
	    System.out.println(fechaFinalizada); 
	    DayOfWeek diaDelMinuto= fechaFinalizada.getDayOfWeek();
	    int val = diaDelMinuto.getValue();
	    
		LocalTime rango1= LocalTime.parse("08:00:00"); 
		LocalTime rango2= LocalTime.parse("20:00:00");
		
		LocalTime rango3= LocalTime.parse("09:00:00"); 
		
		LocalDateTime fecha=  LocalDateTime
                .parse("2019-03-27T07:58:30");

	    if (val == 6) {
	    	
	    	System.out.println("CACA"); 
	    }
	    
	    int value = rango3.compareTo(rango1);
	    
		LocalTime minutoX= fechaFinalizada.toLocalTime();
		
		 int esMayorQueInicio= minutoX.compareTo(rango1);
		 int esMenorQueFinal= minutoX.compareTo(rango2);
		 
		 System.out.println(minutoX);
		 System.out.println(fecha = fecha.plusMinutes(1));
		 System.out.println(fecha = fecha.plusMinutes(1));
		 System.out.println(fecha = fecha.plusMinutes(1));
		 System.out.println("Mi texto con\nun salto de línea");
	    
		 if (esMayorQueInicio >= 0 && esMenorQueFinal < 0) {
	    	
	    	System.out.println("0.20"); 
	    }
	    else {
	    	
	    	System.out.println("0.10"); 
	    }
	    
	  }
}
