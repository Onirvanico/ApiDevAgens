package com.recode.devAgensApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.recode.devAgensApi.model.Destino;

public interface DestinoRepository extends JpaRepository<Destino, Integer>{

	@Query(value ="SELECT * FROM Destino LIMIT :limit", nativeQuery = true)
	List<Destino> retrieveUntil(@Param("limit") int limit);
                       
}                            
