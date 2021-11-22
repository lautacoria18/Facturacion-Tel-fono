package Llamadas;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada {
	/**
     * Subclase creada para las llamadas locales, estas tendran un costo por minuto diferente dependiendo del día y de la franja horaria.
     *  
     */
	


	/**
     * Constructor para la clase, mismo comportamiento que el de la superclase.
     * 
     */
	public LlamadaLocal(Integer duracion) {

		super(duracion);
		//this.fechaRealizada= LocalDateTime.parse("2021-11-17T07:58:30"); //funcioann bien ambos casos hay que emproli
		
	}
	/**
     * En este metodo recorremos con un "for loop" los minutos donde transcurrió la llamada.
     * Dentro de la variable "res" vamos acumulando los costo de cada minuto, y luego, lo retornamos.
     *  
     */
	@Override
	public BigDecimal costoLlamada() {
		// TODO Auto-generated method stub

		BigDecimal res = new BigDecimal("0.00");
		 LocalDateTime minutoActual= this.fechaRealizada();
		
		for (int i = 0; i < this.duracionLlamada(); i++) {
			
			
			res = res.add(costoDelMinuto(minutoActual));
			minutoActual= minutoActual.plusMinutes(1);
			
		}
		
		return res;
		
	}

	/**
     * En este metodo decidi implementar un switch case consultando el día que se realizo la llamada.
     * El caso por default es cuando la llamada se realizo dentro de un dia habil: con un condicional preguntamos si la hora que se 
     * realizó la llamada esta dentro del rango de las 8:00 - 20:00, si esta dentro de ese, se cobra $0.20. En cualquier otro caso
     * se cobra $0.10 el minuto
     * 
     *  
     */

	public BigDecimal costoDelMinuto(LocalDateTime minuto) {
		
		LocalTime rangoInicial= LocalTime.parse("08:00:00"); 
		LocalTime rangoFinal= LocalTime.parse("20:00:00");
		LocalTime minutoLocalTime= minuto.toLocalTime();
		
		DayOfWeek diaDelMinuto= minuto.getDayOfWeek();
		int diaEnNumero = diaDelMinuto.getValue();
		
		BigDecimal res = new BigDecimal("0.00");
		switch(diaEnNumero)
			{

				default:
			   
					int esMayorQueInicio= minutoLocalTime.compareTo(rangoInicial);
					int esMenorQueFinal= rangoFinal.compareTo(minutoLocalTime);
			   
					if (esMayorQueInicio >= 0 && esMenorQueFinal >= 0) {
				   
						res =  new BigDecimal("0.20");
																	}
					else {
						res= new BigDecimal("0.10");
					}
					break;
			   
				case 6 : 
			   		res=  new BigDecimal("0.10");
			   		break;
			   		
				case 7: 
			   		res= new BigDecimal("0.10");
			   		break;
			}
		
		return res;
		
	}

	/**
     * Como es una llamada local, la ciudad destino será la ciudad local.
     *  
     */
	
	@Override
	public String destinoLlamada() {
		// TODO Auto-generated method stub
		return "Ciudad local";
	}



	
	

}
