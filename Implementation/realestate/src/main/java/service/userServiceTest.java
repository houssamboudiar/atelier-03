package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.realestate.RealestateApplication;
import com.realestate.models.User;
import com.realestate.repositories.UserRepository;
import com.realestate.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RealestateApplication.class)
public class userServiceTest {
	
		@Autowired
		private UserService userService;
		
		@Autowired
		private UserRepository userRepository;
		
		@Before
	    public void setUp() {
			userService.evictCache();
	    }
	
	    @After
	    public void tearDown() {
	        // clean up after each test method
	    }
	    
	    // should be true , testing return type of the getAllUsers method 
	    @Test
	    public void TestgetAllUsersType() {
	
	        List<User> list = userService.getAllUsers();
	
	        Assert.assertNotNull("failure - expected not null", list);
	
	    }
	    
	 // should be true , testing return type of the getAllUsers method 
	    @Test
	    public void TestgetAllUsersType() {
	
	        List<User> list = userService.getAllUsers();
	
	        Assert.assertNotNull("failure - expected not null", String);
	
	    }
    
	    //should be false , expecting 2 users while we got 27 on our database 
	    @Test
	    public void TestgetUsersListLength() {
	        List<User> list = userService.getAllUsers();
	        Assert.assertEquals("failure - expected list size", 2, list.size());
	    }

	    //most of the time true , getting a random number in range of [17-list.size()] "our ids range" and trying to get the user by id
	    @Test
	    public void testFindUserByID() {
	    	
	    	List<User> list = userService.getAllUsers();
	
	        Integer id = new Random().nextInt(list.size()) + 17 ;
	
	        User entity = userService.getUser(id);
	
	        Assert.assertEquals("failure - expected id attribute match", (Integer)id,
	        		(Integer)entity.getId());
	
	    }
	    
		// should be true , Subscribe test ... adding a user then trying to get it using "getUserByEmailAndPassword" method
	    @Test
		public void testADDuser(){

			User user = new User();
			user.setUsername("ami");
			user.setEmail("ami@gmail.com");
			user.setPassword("123456789");
			user.setType("Client");
			user.setName("ami");
			user.setF_name("ami");
			user.setBirthdate("2002-12-14");
			user.setPhone("0606040550");
			user.setAddress("alger");
			user.setGender("Male");
				
			UserRepository mock = org.mockito.Mockito.mock(UserRepository.class);
		    Mockito.when(mock.save(user)).thenReturn(user);
		    assertThat(userRepository.getUserByEmailAndPassword("ami@gmail.com", "123456789").getUsername()).isEqualTo(user.getUsername());
		}
	    //should be false , adding a user already exists on our database
	    @Test
    //@Ignore
		public void falsetestADDuser(){

			User user = new User();
			
			user.setUsername("amine100");
			user.setEmail("amine100@gmail.com");
			user.setPassword("00000000");
			user.setType("00000000");
			user.setName("amine");
			user.setF_name("amine");
			user.setBirthdate("2018-04-24");
			user.setPhone("0559677270");
			user.setAddress("algeria");
			user.setGender("Male");
				
			UserRepository mock = org.mockito.Mockito.mock(UserRepository.class);
		    Mockito.when(mock.save(user)).thenReturn(user);
		    assertThat(userService.addUser(user)).isEqualTo(true);
		}
	
	//should be true , blocking user then " blocked = 1 " then comparing getblocked() it to "1"
	@Test
	public void testUpdateUser(){
		User user = new User();
		user.setId(43);
		user.setUsername("amine1111");
		user.setPassword("00000000");
		user.setEmail("amine1111@gmail.com");
		user.setType("Client");
		user.setName("amine");
		user.setF_name("amine");
		user.setBirthdate("2002-11-14");
		user.setPhone("0605040550");
		user.setAddress("alger");
		user.setGender("Male");
		UserRepository mock = org.mockito.Mockito.mock(UserRepository.class);
		Mockito.when(mock.updateUserStatus(user.getId() , 1)).thenReturn(user.getBlocked());
	    assertThat(userRepository.getUserByEmailAndPassword("amine1111@gmail.com", "00000000").getBlocked()).isEqualTo(1);
	}
	//should be false , updating "blocked to 0(keeping it the same)" then comparing it to 1 
	@Test
	public void falsetestUpdateUser(){
		
		User user = new User();
		user.setId(44);
		user.setUsername("houssam");
		user.setPassword("1234567");
		user.setEmail("hou@gmail.com");
		user.setType("Client");
		user.setName("boudiar");
		user.setF_name("houssam");
		user.setBirthdate("2002-12-04");
		user.setPhone("0605040550");
		user.setAddress("bir el ater");
		user.setGender("Male");
		UserRepository mock = org.mockito.Mockito.mock(UserRepository.class);
		Mockito.when(mock.updateUserStatus(user.getId() , 0)).thenReturn(user.getBlocked());
	    assertThat(userRepository.getUserByEmailAndPassword("hou@gmail.com", "1234567").getBlocked()).isEqualTo(1);
	    //System.out.println("Blocked  :" + user.getBlocked());
	    
     }
	
}
	
    
    
    
    
    
    
    
    
    
    

