package Llamadas;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LlamadaInternacional extends Llamada {
	
	/**
     * Subclase creada para las llamadas internacionales,  estas tendran un costo por minuto dependiendo el país.
     *  
     */

	
	private String paisLlamada;
	private BigDecimal costoPorMinuto;

	/**
     * Constructor para la clase, ademas de la duracion, esta vez se asignara un parametro string que sera el pais donde se llamó
     * y el costo por minuto.
     * 
     */
	public LlamadaInternacional(String pais, BigDecimal costo, Integer duracion) {
		
		super(duracion);
		this.paisLlamada= pais;
		this.costoPorMinuto= costo;

	}
	/**
     * Para calcular el costo de la llamada simplemente multiplicamos el costo por minuto por la cantidad de minutos que duró la llamada
     *  
     */
	
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
