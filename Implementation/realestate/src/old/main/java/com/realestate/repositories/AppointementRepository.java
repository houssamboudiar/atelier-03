package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Appointement;

public interface AppointementRepository extends JpaRepository<Appointement, Integer> {

	@Query(value = "SELECT * FROM appointement WHERE id_lodgement=:id  ORDER BY date ASC", nativeQuery= true)
	public List<Appointement> getAppointementByLodgementId(@Param("id") int id);
	
	@Query(value = "SELECT * FROM appointement WHERE id_client=:id", nativeQuery= true)
	public List<Appointement> getAppointementByClientId(@Param("id") int id);
	
	@Query(value = "SELECT * FROM appointement WHERE id_agent=:id", nativeQuery= true)
	public List<Appointement> getAppointementByAgentId(@Param("id") int id);
	
	@Query(value = "SELECT * FROM appointement WHERE date=:date AND id_lodgement=:id", nativeQuery= true)
	public Appointement getAppointementByDate(@Param("date") String Date, @Param("id") int id);

	@Query(value = "SELECT * FROM appointement WHERE date=:date AND id_agent=:id", nativeQuery= true)
	public Appointement getAgentByDate(@Param("id")int id,@Param("date") String date);
	
	@Query(value = "SELECT * FROM appointement WHERE date=:date AND id_client=:id", nativeQuery= true)
	public Appointement getClientByDate(@Param("id")int id,@Param("date") String date);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "INSERT INTO `appointement` (`id`, `date`, `id_client`, `id_agent`, `id_lodgement`, `agent_confirmed`, `client_confirmed`, `review`) VALUES (NULL, :date, :id_client, :id_agent, :id_lodgement, '0', '0', NULL);", nativeQuery= true)
	public int saveAppointement(@Param("id_client")int id_client, @Param("id_agent")int id_agent, @Param("id_lodgement")int id_lodgement, @Param("date")String date );

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE `appointement` SET `agent_confirmed`=:confirm WHERE `id`=:id ;", nativeQuery= true)
	public int confirmAppointementByAgentId(@Param("id") int id, @Param("confirm") int confirm);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE `appointement` SET `client_confirmed`=:confirm  WHERE `id`=:id  ;", nativeQuery= true)
	public int confirmAppointementByClientId(@Param("id") int id, @Param("confirm") int confirm);
	
	@Query(value = "SELECT * FROM appointement WHERE id=:id LIMIT 1", nativeQuery= true)
	public Appointement getAppointementById(@Param("id") int id);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE `appointement` SET `date`=':date' WHERE `id`=:id", nativeQuery= true)
	public int changeAppointement(@Param("id") int id, @Param("date") String date);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "DELETE FROM `appointement` WHERE id = :id", nativeQuery= true)
	public int deleteAppointement(@Param("id") int id);
	
	
	@Query(value = "SELECT id FROM appointement WHERE id_client=:id", nativeQuery= true)
	public List<Integer> getAllIds(@Param("id") int id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE appointement SET review =:review WHERE id=:id", nativeQuery= true)
	public int save_review(@Param("id") int id, @Param("review") String review);

	@Query(value = "SELECT review FROM appointement WHERE id_lodgement=:id_lodgement AND review != 'null'", nativeQuery= true)
	public List<String> getAllReviewByAppointementId(@Param("id_lodgement") int id_lodgement);
	
}
