package services;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import domain.Activity;
import domain.Schedule;
import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/datasource.xml",
		"classpath:spring/config/packages.xml"})
@Transactional
@TransactionalConfiguration(defaultRollback = false)

public class ActivityServiceTest extends AbstractTest{

	/** variable local */
	@Autowired
	
	private ActivityService activityService;
	
	
	
	/** Ahora vamos a probar todos los metodos */
	/** TODO */
//	@Test
//	public void createTest(){
//		
//		Activity activity;
//		
//	}
	
	/** TODO */
	@Test
	public void findAllTest(){
		
		Collection<Activity> result;
		result = activityService.findAll();
		for(Activity actividad : result){
			System.out.println(actividad.getName());
		}
		
	}
	
	/** TODO */
	@Test
	public void findOneTest(){
		
		Activity activity;
		
	}
	
	/** TODO */
	@Test
	public void saveTest(){
		
		Activity activity;
		
	}
	
	/** TODO */
	@Test
	public void deleteTest(){
		
		Activity activity;
		
	}
	
	
	@Test
	public void probar(){
		
		for(Activity a : activityService.findAll()){
			for(Schedule s : a.getSchedules()){
				System.out.println(s.getOpeningDate());
			}
		}
		
	}
	
}
