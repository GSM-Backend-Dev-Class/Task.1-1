package com.gsm._8th.class4.backed.task._1._1.domain.repository;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AngRepository extends JpaRepository<Ang, Long> {
}
