package Llamadas;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Llamada {
	
	/**
     * Esta sera la superclase de la Llamada
     * 
     */

	private Integer duracionLlamada;
	protected LocalDateTime fechaRealizada;

	/**
     * Constructor para la clase, se le asignara un parametro integer que sera la duracion de la llamada en minutos
     * y la fecha realizada sera la del momento que se intancie esta clase.
     * 
     */
	public Llamada(Integer duracion) {
		this.duracionLlamada= duracion;
		this.fechaRealizada= LocalDateTime.now();
		
	}
	
	public Integer duracionLlamada() {
		return this.duracionLlamada;
	}
	
	public LocalDateTime fechaRealizada() {
		return this.fechaRealizada;
	}
	public abstract BigDecimal costoLlamada();


	public abstract String destinoLlamada();
	
}
