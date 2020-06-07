package email.cleaning.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PlainEmailSourceTest {
	
	@Test
	public void getLines() {
		List<String> lines = TextSourceUtil.getLinesFromFile("testEmail.txt");
		
		assertEquals(12, lines.size());
	}
}
