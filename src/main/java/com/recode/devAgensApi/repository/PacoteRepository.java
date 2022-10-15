package com.recode.devAgensApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.recode.devAgensApi.model.Pacote;

public interface PacoteRepository extends JpaRepository<Pacote, Integer>{

	@Query(value ="SELECT * FROM Pacote LIMIT :limit", nativeQuery = true)
	List<Pacote> retrieveUntil(int limit);

}
