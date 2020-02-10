package com.cap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.model.Carthistory;

@Repository
public interface CarthistoryRepository extends JpaRepository<Carthistory, Integer>{

}
