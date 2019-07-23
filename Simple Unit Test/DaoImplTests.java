import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DaoImplTests {
	
	@InjectMocks
	private PatientDaoImpl daoImp;
	
	@Mock
	private Connection conn;
	
	@Mock
	private PreparedStatement prep;
	
	@Test
	public void insert_patientHappyPathTest() throws SQLException, PatientDaoException {
		when(conn.prepareStatement(anyString())).thenReturn(prep);
		when(prep.executeUpdate()).thenReturn(1);
		Patient p = new Patient("Ali", "Ahmed");
		daoImp.insert_patient(p);
		verify(prep, times(1)).executeUpdate();
		
		ArgumentCaptor<String> fnameCapture = ArgumentCaptor.forClass(String.class);
		verify(prep, times(5)).setString(anyInt(), fnameCapture.capture());
		org.junit.Assert.assertTrue(fnameCapture.getAllValues().get(1).equals("Ali"));
				
	}
	
	@Test(expected = PatientDaoException.class)
	public void insert_patientExceptionTest() throws SQLException, PatientDaoException {
		when(conn.prepareStatement(anyString())).thenReturn(prep);
		when(prep.executeUpdate()).thenThrow(new SQLException());
		Patient p = new Patient("Ali", "Ahmed");
		daoImp.insert_patient(p);
	}
	

}
