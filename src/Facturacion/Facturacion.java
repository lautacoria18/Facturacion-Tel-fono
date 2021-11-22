package Facturacion;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import Llamadas.Llamada;
import Llamadas.LlamadaLocal;

public class Facturacion {
	/**
     * Esta sera la clase de la facturación, aqui se podra saber el abono total, imprimir en pantalla la factura completa y registrar llamadas solo si fueron realizadas
     * en el mes correspondiente.
     */

	private List <Llamada> llamadasRealizadas;
	private BigDecimal abonoMensual;
	private Month mesFactura;
	
	public Facturacion (BigDecimal abono) {
		
		llamadasRealizadas= new ArrayList <Llamada>();
		abonoMensual = abono;
		mesFactura= LocalDateTime.now().getMonth();
		
			
	}

	public BigDecimal getAbonoMensual() {
		// TODO Auto-generated method stub
		return this.abonoMensual;
		
	}
	/**
     * Este metodo nos permitirá saber el abono total que se pagara a fin de mes. El costo se calculara en base a todas las llamadas registradas
     * sumadas a el abono mensual fijo.
     * 
     */
	
	public BigDecimal getCostoTotal() {
		// TODO Auto-generated method stub
		BigDecimal res= new BigDecimal(0.0);
		
		for (int i=0; i < llamadasRealizadas.size(); i++) {
			
			res= res.add(llamadasRealizadas.get(i).costoLlamada());
		}
		
		return res.add(this.getAbonoMensual());
		
	}
	
	/**
     * Este metodo nos permitira registrar llamadas solo si estas fueron realizadas en el mes correspondiente de la facturacion.
     * 
     */
	
	public void registrarLlamada(Llamada llamada) {
		// TODO Auto-generated method stub
		if (llamada.fechaRealizada().getMonth() == this.mesFactura) {
			  this.llamadasRealizadas.add(llamada);
	}
	}
	/**
     * Este metodo imprimira la factura sabiendo:
     * -La fecha y hora en la que fue realizada las llamadas
     * -El destino de las llamadas
     * -La duracion en minutos de la llamada
     * -El costo singular de cada llamada.
     * -El abono mensual fijo
     * -El costo total de la factura
     */


	public void imprimirFacturaEnPantalla() {
		// TODO Auto-generated method stub
		System.out.println("----------------------------Factura mes de "+ this.mesFactura +" ----------------------------");
		
		llamadasRealizadas.stream().forEach((l)-> { 
		System.out.println(l.fechaRealizada() +" Llamada a " + l.destinoLlamada() + " -- Duracion en minutos: " + l.duracionLlamada() +" -- Costo de la llamada: $" + l.costoLlamada());

			});
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("					       		Costo abono mensual: 	  $" + this.getAbonoMensual());
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("					       		Costo total de la factura: $" +  this.getCostoTotal());
		
	}



	
	

	
	
	
	
	
}
