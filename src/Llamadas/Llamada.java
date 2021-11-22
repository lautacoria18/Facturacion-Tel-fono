package Llamadas;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Llamada {

	private Integer duracionLlamada;
	protected LocalDateTime fechaRealizada;
	
	public Llamada(Integer duracion) {
		this.duracionLlamada= duracion;
		this.fechaRealizada= LocalDateTime.now();
	}
	
	public abstract BigDecimal costoLlamada();

	public Integer duracionLlamada() {
		return this.duracionLlamada;
	}
	
	public abstract String destinoLlamada();
	
	public LocalDateTime fechaRealizada() {
		return this.fechaRealizada;
	}
}
