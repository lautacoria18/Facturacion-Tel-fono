package Llamadas;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LlamadaNacional extends Llamada {
	/**
     * Clase concreta creada para las llamadas nacionales, estas tendran un costo por minuto dependiendo de la localidad.
     *  
     */
	

	private BigDecimal costoPorMinuto;
	private String localidadLlamada;

	/**
     * Constructor para la clase, ademas de la duracion, esta vez se asignara un parametro string que sera la localidad donde se llamó
     * y el costo por minuto.
     * 
     */
	
	public LlamadaNacional(String localidad, BigDecimal costo, Integer duracion) {
		super(duracion);
		this.localidadLlamada= localidad;
		this.costoPorMinuto= costo;

	}
	/**
     * Para calcular el costo de la llamada simplemente multiplicamos el costo por minuto por la cantidad de minutos que duró la llamada
     *  
     */
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
