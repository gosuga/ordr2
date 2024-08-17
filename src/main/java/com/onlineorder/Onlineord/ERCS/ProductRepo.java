package com.onlineorder.Onlineord.ERCS;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import jakarta.persistence.LockModeType;


@Repository
public interface ProductRepo  extends JpaRepository<Product, Long>{
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Product> findById(Long id);
}
