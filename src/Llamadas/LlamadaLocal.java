package Llamadas;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada {



	
	public LlamadaLocal(Integer duracion) {

		super(duracion);
		this.fechaRealizada= LocalDateTime.parse("2019-03-27T07:58:30"); //funcioann bien ambos casos hay que emproli
		
	}
	
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

	@Override
	public String destinoLlamada() {
		// TODO Auto-generated method stub
		return "Ciudad local";
	}


	
	

}
