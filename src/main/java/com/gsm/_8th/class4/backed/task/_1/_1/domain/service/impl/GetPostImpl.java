package com.gsm._8th.class4.backed.task._1._1.domain.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import com.gsm._8th.class4.backed.task._1._1.domain.repository.AngRepository;
import com.gsm._8th.class4.backed.task._1._1.domain.service.GetPost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GetPostImpl implements GetPost {
    private final AngRepository angRepository;

    public ResponseEntity<List<Ang>> getAngs() {
        try {
            return ResponseEntity.ok(angRepository.findAll());
        } catch (IllegalArgumentException e) {
            List<Ang> emptyList = Collections.emptyList();
            return ResponseEntity.ok(emptyList);
        }
    }

    public ResponseEntity<Optional<Ang>> getAngById(Long id) {
        try {
            return ResponseEntity.ok(angRepository.findById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
