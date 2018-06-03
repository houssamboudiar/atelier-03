package Tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.realestate.models.Client;
import com.realestate.repositories.ClientRepository;
import com.realestate.services.ClientService;

public class ClientServiceTest {
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Before
    public void setUp() {
		userService.evictCache();
    }

    @After
    public void tearDown() {
        // clean up after each test method
    }
    
 // should be true , Subscribe test ... adding a user then trying to get it using "getUserByEmailAndPassword" method
    @Test
	public void testADDuser(){
    	boolean T = true ;   	
		Client client = new Client();
		client.setUsername("ami");
		client.setEmail("ami@gmail.com");
		client.setPassword("123456789");
		client.setName("ami");
		client.setLast_name("darenyl");		
		client.setPhone("0606040550");
		client.setGender("Male");
			
		ClientRepository mock = org.mockito.Mockito.mock(ClientRepository.class);
	    Mockito.when(mock.save(client)).thenReturn(client);
	    assertThat(clientService.client_email_exists("ami@gmail.com").isEqualTo(clientService.client_email_exists("houssam01@gmail.com"));
	}

}
