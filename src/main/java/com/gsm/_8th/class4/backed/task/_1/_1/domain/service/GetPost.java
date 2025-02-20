package com.gsm._8th.class4.backed.task._1._1.domain.service;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GetPost {
    ResponseEntity<List<Ang>> getAngs();
    ResponseEntity<Optional<Ang>> getAngById(Long id);
}
