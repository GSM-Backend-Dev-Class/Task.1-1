package com.gsm._8th.class4.backed.task._1._1.domain.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import com.gsm._8th.class4.backed.task._1._1.domain.repository.AngRepository;
import com.gsm._8th.class4.backed.task._1._1.domain.service.DeletePost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
public class DeletePostImpl implements DeletePost {
    private final AngRepository angRepository;

    public ResponseEntity<Ang> deleteAng(Long id) {
        angRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
