package Tests;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.realestate.repositories.ClientRepository;
import com.realestate.services.ClientService;

public class ClientServiceTest {
	
	@Autowired
	private ClientService userService;
	
	@Autowired
	private ClientRepository userRepository;
	
	@Before
    public void setUp() {
		userService.evictCache();
    }

    @After
    public void tearDown() {
        // clean up after each test method
    }

}
