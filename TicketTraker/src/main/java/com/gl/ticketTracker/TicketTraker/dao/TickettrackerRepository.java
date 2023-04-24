package com.gl.ticketTracker.TicketTraker.dao;

import java.util.List;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.ticketTracker.TicketTraker.model.TicketTracker;


@Repository
public interface TickettrackerRepository extends JpaRepository<TicketTracker, Long> {
	
	 //Custom query
	 @Query(value = "select * from tickettracker s where s.title like %:title%", nativeQuery = true)
	
	List<TicketTracker> findBytitle(@Param("title") String title);


}
