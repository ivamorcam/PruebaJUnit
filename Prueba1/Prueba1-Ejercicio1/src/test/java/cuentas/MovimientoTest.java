package cuentas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovimientoTest {

	Movimiento m;

	@BeforeEach
	void setUp() throws Exception {
		m = new Movimiento();
	}

	@Test
	void testGetImporte() {
		m.setImporte(20.0);
		assertEquals(20.0, m.getImporte());
	}

	@Test
	void testGetConcepto() {
		m.setConcepto("Ingreso en efectivo");
		assertEquals("Ingreso en efectivo", m.getConcepto());
	}

	@Test
	void testSetConcepto() {
		m.setConcepto("Retirada del cajero");
		assertEquals("Retirada del cajero", m.getConcepto());
	}

	@Test
	void testSetImporte() {
		m.setImporte(200.0);
		assertEquals(200.0, m.getImporte());
	}

}
