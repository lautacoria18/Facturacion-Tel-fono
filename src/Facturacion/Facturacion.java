package Facturacion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import Llamadas.Llamada;

public class Facturacion {

	private List <Llamada> llamadasRealizadas;
	private BigDecimal abonoMensual;
	private LocalDateTime fechaActual;
	private Month mesFactura;
	
	public Facturacion (BigDecimal abono) {
		
		llamadasRealizadas= new ArrayList <Llamada>();
		abonoMensual = abono;
		fechaActual= LocalDateTime.now();
		mesFactura= fechaActual.getMonth();
		
			
	}
/*
	public BigDecimal abonoNacionalTotal() {
		BigDecimal res= new BigDecimal(0.0);
		
		for (int i=0; i < llamadasNacionales.size(); i++) {
			
			res= res.add(llamadasNacionales.get(i).costoLlamada());
		}
		
		return res;
		
	}

	public BigDecimal abonoInternacionalTotal() {
		// TODO Auto-generated method stub
		BigDecimal res= new BigDecimal(0.0);
		
		for (int i=0; i < llamadasInternacionales.size(); i++) {
			
			res= res.add(llamadasInternacionales.get(i).costoLlamada());
		}
		
		return res;
	}

	public BigDecimal abonoLocalTotal() {
		// TODO Auto-generated method stub
		BigDecimal res= new BigDecimal(0.0);
		
		for (int i=0; i < llamadasLocales.size(); i++) {
			
			res= res.add(llamadasLocales.get(i).costoLlamada());
		}
		
		return res;
		
	}
*/
	public BigDecimal getAbonoMensual() {
		// TODO Auto-generated method stub
		return this.abonoMensual;
		
	}
	
	public BigDecimal getAbonoTotal() {
		
		
		//(this.abonoNacionalTotal().add(this.abonoInternacionalTotal()).add(this.abonoLocalTotal()));
				BigDecimal res= new BigDecimal(0.0);
		
		for (int i=0; i < llamadasRealizadas.size(); i++) {
			
			res= res.add(llamadasRealizadas.get(i).costoLlamada());
		}
		
		return res.add(this.getAbonoMensual());
		
	}
	
	
	
	public void agregarLlamada(Llamada llamada) {
		
		if (llamada.fechaRealizada().getMonth() == this.mesFactura) {
			  this.llamadasRealizadas.add(llamada);
		}
		else {
			//arrojar error
		}
	}
	
	public void imprimirFactura() {
		
		System.out.println("----------------------------Factura mes de "+ this.mesFactura +" ----------------------------");
		
		llamadasRealizadas.stream().forEach((l)-> { 
		System.out.println(l.fechaRealizada() +" Llamada a " + l.destinoLlamada() + " -- Duracion en minutos: " + l.duracionLlamada() +" -- Costo de la llamada: $" + l.costoLlamada());

			});
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("					       		Costo abono mensual: 	  $" + this.getAbonoMensual());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("					       		Costo total de la factura: $" +  this.getAbonoTotal());
		
	}
	
	

	
	
	
	
	
}
