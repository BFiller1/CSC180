package exercises.seven;

import static org.junit.Assert.*;

import org.junit.Test;

public class PaddingTest {

	Padding p = new Padding();

	@Test
	public void PadTest() {
		p.pad("batman is awesome", 12);
	}
	
	@Test
	public void UnpadTest() {
		p.unpad("batman" + "0x1e" + "0x1e");
	}

}
