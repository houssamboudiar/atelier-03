package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Lodgement;
import com.realestate.models.User;

public interface LodgementRepository extends JpaRepository<Lodgement, Integer> {
	
	@Query(value = "SELECT * FROM lodgement l WHERE l.state = :state ", nativeQuery= true)
	public List<Lodgement> getLodgementByState(@Param("state") String state);
	
	@Query(value = "SELECT * FROM lodgement l WHERE l.state = :state AND l.reserved=1 ", nativeQuery= true)
	public List<Lodgement> getFreeLodgementByState(@Param("state") String state);
	
	@Query(value = "SELECT * FROM lodgement l WHERE l.id = :id ", nativeQuery= true)
	public Lodgement getLodgementById(@Param("id") int id);
	
	@Query(value = "SELECT * FROM lodgements", nativeQuery= true)
	public List<Lodgement> getLodgements();
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE lodgement l SET l.reserved=:reserved WHERE l.id=:id", nativeQuery= true)
	public int updateLodgementStatus(@Param("id") int id, @Param("reserved") int reserved);
	
	
}
