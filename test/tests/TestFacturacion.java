package tests;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Facturacion.Facturacion;
import Llamadas.LlamadaInternacional;
import Llamadas.LlamadaLocal;
import Llamadas.LlamadaNacional;


class TestFacturacion {

	private LlamadaLocal llamadaLocal;
	private LlamadaLocal llamadaLocal2;
	private LlamadaLocal llamadaLocal3;

	private LlamadaNacional llamadaNacional;
	private LlamadaNacional llamadaNacional2;
	private LlamadaNacional llamadaNacional3;
	
	private LlamadaInternacional llamadaInternacional;
	private LlamadaInternacional llamadaInternacional2;
	private LlamadaInternacional llamadaInternacional3;
	
	private Facturacion facturacion;

	
	
	

	@BeforeEach
	void setUp() throws Exception {
		llamadaLocal= new LlamadaLocal(8);
		llamadaLocal2= new LlamadaLocal(5);
		llamadaLocal3= new LlamadaLocal(7);
		
		llamadaNacional= new LlamadaNacional("Florencio Varela", new BigDecimal("0.50"), 10);
		llamadaNacional2= new LlamadaNacional("Solano", new BigDecimal("0.40"), 5);
		llamadaNacional3= new LlamadaNacional("Berazategui", new BigDecimal("0.30"), 7);
		
		llamadaInternacional= new LlamadaInternacional("Colombia", new BigDecimal("2.50"), 4);
		llamadaInternacional2= new LlamadaInternacional("Peru", new BigDecimal("5.50"), 4);
		llamadaInternacional3= new LlamadaInternacional("Inglaterra", new BigDecimal("10.50"), 4);
		
		
		facturacion= new Facturacion(new BigDecimal("500.00"));
		
		facturacion.registrarLlamada(llamadaLocal);
		facturacion.registrarLlamada(llamadaLocal2);
		facturacion.registrarLlamada(llamadaLocal3);
		facturacion.registrarLlamada(llamadaNacional);
		facturacion.registrarLlamada(llamadaInternacional);

		
	}

	@Test
	void testLlamadaNacional() {
		assertEquals(llamadaNacional.costoLlamada(), new BigDecimal("5.00"));
		assertEquals(llamadaNacional2.costoLlamada(), new BigDecimal("2.00"));
		assertEquals(llamadaNacional3.costoLlamada(), new BigDecimal("2.10"));

	}
	@Test
	void testLlamadaInternacional() {
		assertEquals(llamadaInternacional.costoLlamada(), new BigDecimal("10.00"));
		assertEquals(llamadaInternacional2.costoLlamada(), new BigDecimal("22.00"));
		assertEquals(llamadaInternacional3.costoLlamada(), new BigDecimal("42.00"));
		
	}
	
	/**
     * Como el costo de la llamada depende del dia y horario implemente un test para cada caso
     * 
     * 	|
     * 	|
     * 	v
     * 
     */
	
	/**
     * En el caso de que sea d?a habil (Lunes a viernes) dentro del rango de las 8 y 20, este test sera el correcto
     * 
     */
	@Test
	void testLlamadaLocalDentroDeUnDiaHabilDe8a20() { 
		assertEquals(llamadaLocal.costoLlamada(), new BigDecimal("1.60"));
		assertEquals(llamadaLocal2.costoLlamada(), new BigDecimal ("1.00"));
		assertEquals(llamadaLocal3.costoLlamada(), new BigDecimal ("1.40"));

	}
	/**
     * En el caso de que sea fin de semana o dia habil fuera del rango este test sera el correcto
     * 
     */
	@Test
	void testLlamadaLocalEnUnFinDeSemanaOFueraDelRango() { 
		assertEquals(llamadaLocal.costoLlamada(), new BigDecimal("0.80"));
		assertEquals(llamadaLocal2.costoLlamada(), new BigDecimal ("0.50"));
		assertEquals(llamadaLocal3.costoLlamada(), new BigDecimal ("0.70"));

	}
	
	/**
     * Lo mismo sucedera en este test, en el caso de que sea dia habil dentro del rango mencionado anteriormente, este sera el correcto
     * 
     */
	@Test
	void testFacturacionDiaHabil() {

		facturacion.imprimirFacturaEnPantalla();
		assertEquals(facturacion.getAbonoMensual(), new BigDecimal("500.00"));
		assertEquals(facturacion.getCostoTotal(), new BigDecimal("519.00"));

	}
	
	/**
     * En el caso de que sea fin de semana, o dia habil fuera del rango, este test sera el correcto
     * 
     */
	@Test
	void testFacturacionFinDeSemanaOFueraDelRango() {

		
		assertEquals(facturacion.getAbonoMensual(), new BigDecimal("500.00"));
		assertEquals(facturacion.getCostoTotal(), new BigDecimal("517.00"));

	}

}
