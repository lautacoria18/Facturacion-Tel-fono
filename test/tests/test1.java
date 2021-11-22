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


class test1 {

	private LlamadaLocal llamadaLocal;
	private LlamadaLocal llamadaLocal2;
	private LlamadaLocal llamadaLocal3;
	private LlamadaLocal llamadaMockLocal;
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
		
		
		LocalDateTime lt = LocalDateTime.parse("2021-11-18T19:34:50.63");
		
		
		llamadaMockLocal= mock(LlamadaLocal.class);
		when(llamadaMockLocal.duracionLlamada()).thenReturn(10);
		when(llamadaMockLocal.fechaRealizada()).thenReturn(lt);
		
		facturacion= new Facturacion(new BigDecimal("500.00"));

		
	}
	
	@Test
	void testLlamadaNacional() {
		//assertEquals(llamadaLocal.costoLlamada(), 0.50); //funciona bien la llamada local
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
	@Test
	void testLlamadaLocal() { //mockear
		//LocalDateTime lt = LocalDateTime.parse("2021-11-18T19:34:50.63");
		//when(llamadaMockLocal.duracionLlamada()).thenReturn(10);
		//when(llamadaMockLocal.fechaRealizada()).thenReturn(lt);
		//assertEquals(llamadaMockLocal.costoLlamada(), new BigDecimal("0.80"));
		assertEquals(llamadaLocal.costoLlamada(), new BigDecimal("0.80"));
		assertEquals(llamadaLocal2.costoLlamada(), new BigDecimal ("0.50"));
		assertEquals(llamadaLocal3.costoLlamada(), new BigDecimal ("0.70"));

	}
	@Test
	void testFacturacion() {
		facturacion.agregarLlamada(llamadaLocal);
		facturacion.agregarLlamada(llamadaLocal2);
		facturacion.agregarLlamada(llamadaLocal3);
		facturacion.agregarLlamada(llamadaNacional);
		facturacion.agregarLlamada(llamadaInternacional);
		facturacion.agregarLlamada(llamadaLocal3);
		facturacion.imprimirFactura();
		assertEquals(facturacion.getAbonoMensual(), new BigDecimal("500.00"));
		assertEquals(facturacion.getAbonoTotal(), new BigDecimal("517.70"));

	}

}
