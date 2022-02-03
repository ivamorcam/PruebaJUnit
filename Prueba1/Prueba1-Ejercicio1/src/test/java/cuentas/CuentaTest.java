package cuentas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaTest {

	Cuenta cuenta;

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new Cuenta("1234567890", "Persona");
	}

	@Test
	void testIngresar() {
		try {
			cuenta.ingresar("Ingreso en efectivo", 875.0);

		} catch (Exception e) {
			fail("No debería fallar");
		}
		assertTrue(cuenta.getSaldo() == 875.0);
	}

	
	@Test
	void testIngresarNegativoExcepcion() {
		try {
			cuenta.ingresar("Ingreso en efectivo", -300);

		} catch (Exception e) {
			fail("No se pueden hacer ingresos negativos");
		}
		assertTrue(cuenta.getSaldo() == -300.0);
	}
	@Test
	void testRetirar() {
		try {
			cuenta.ingresar("Ingreso en efectivo", 1200);
			cuenta.retirar("Retirada del cajero", 800);
		} catch (Exception e) {
		}
		assertTrue(cuenta.getSaldo() == 400.0);
	}
	
	@Test
	void testRetirarImporteNegativoExcepcion() {
		try {
			cuenta.ingresar("Ingreso en efectivo", 1300);
			cuenta.retirar("Retiro", -100);

		} catch (Exception e) {
			fail("No se pueden hacer retiradas negativas");
		}
		assertTrue(cuenta.getSaldo() == -100.0);
	}
	
	@Test
	void testRetirarImporteExcepcion() {
		try {
			cuenta.ingresar("Ingreso en efectivo", 1800);
			cuenta.retirar("Retira del cajero", 2000);

		} catch (Exception e) {
			fail("Saldo insuficiente");
		}
		assertTrue(cuenta.getSaldo() == -100.0);
	}

	@Test
	void testGetSaldo() {
		try {
			Movimiento m = new Movimiento();
			cuenta.ingresar("Ingreso en efectivo", 100);
			m.getImporte();
		} catch (Exception e) {
		}
		assertEquals(100.0, cuenta.getSaldo());
	}

}