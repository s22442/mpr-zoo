package com.example.zoo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo, Integer> {
  @Transactional
  @Modifying
  @Query("UPDATE Zoo z SET z.name = :name WHERE z.id = :id")
  void updateNameById(Integer id, String name);

  List<Zoo> findAllByIdGreaterThan(Integer idThreshold);
}
