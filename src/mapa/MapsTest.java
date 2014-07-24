package mapa;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.Test;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class MapsTest {

	@Test
	public void testaSeHashMapAcaitaChaveNull() {
		HashMap<String, BigDecimal> notas = new HashMap<>();
		
		notas.put("Matematica", BigDecimal.valueOf(8.5));
		notas.put("Fisica", BigDecimal.valueOf(9));
		notas.put("Historia", BigDecimal.valueOf(10));
		notas.put("Geografia", BigDecimal.valueOf(10));
		
		notas.put(null, BigDecimal.valueOf(5.3));
		
		assertEquals(notas.get(null), BigDecimal.valueOf(5.3));

	}
	
	@Test(expected = NullPointerException.class)
	public void testaSeHashtableAceitaChaveNull() {
		Hashtable notas = new Hashtable();
		
		notas.put("Matematica", BigDecimal.valueOf(8.5));
		notas.put("Fisica", BigDecimal.valueOf(9));
		notas.put("Historia", BigDecimal.valueOf(10));
		notas.put("Geografia", BigDecimal.valueOf(10));
		
		notas.put("portugues", null);

	}
	
}
