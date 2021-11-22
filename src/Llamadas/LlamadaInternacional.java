package Llamadas;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {

	
	private String paisLlamada;
	private BigDecimal costoPorMinuto;


	public LlamadaInternacional(String pais, BigDecimal costo, Integer duracion) {
		
		super(duracion);
		this.paisLlamada= pais;
		this.costoPorMinuto= costo;

	}
	
	@Override
	public BigDecimal costoLlamada() {
		// TODO Auto-generated method stub
		return this.costoPorMinuto.multiply(new BigDecimal(duracionLlamada()));
	}


	@Override
	public String destinoLlamada() {
		// TODO Auto-generated method stub
		return paisLlamada;
	}



	
	
}
