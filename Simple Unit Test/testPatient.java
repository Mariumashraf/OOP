import org.junit.Assert;
import org.junit.Test;

public class testPatient {
	
	
	@Test
	public void patientTest() {
		Patient patient = new Patient ("Marium","Ashraf");
		final String PhNum = "01011383";
		final String SSN = "54879579457947";
		patient.setPhNum("01011383");
		patient.setSSN("54879579457947");
		Assert.assertTrue(patient.getfname().equals("Marium"));
		Assert.assertTrue(patient.getlname().equals("Ashraf"));
		Assert.assertEquals(patient.getPhNum(), PhNum);
		Assert.assertEquals(patient.getSSN(), SSN);

	}
}