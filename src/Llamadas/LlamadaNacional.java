package Llamadas;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LlamadaNacional extends Llamada {

	

	private BigDecimal costoPorMinuto;
	private String localidadLlamada;

	
	public LlamadaNacional(String localidad, BigDecimal costo, Integer duracion) {
		super(duracion);
		this.localidadLlamada= localidad;
		this.costoPorMinuto= costo;

	}

	@Override
	public BigDecimal costoLlamada() {
		// TODO Auto-generated method stub		
		return this.costoPorMinuto.multiply(new BigDecimal(this.duracionLlamada()));
	}




	@Override
	public String destinoLlamada() {
		// TODO Auto-generated method stub
		return this.localidadLlamada;
	}


	
	
	
	
}
