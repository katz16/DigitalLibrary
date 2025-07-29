package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Penalty;

public interface PenaltyRepository extends JpaRepository<Penalty, Integer>{

}
