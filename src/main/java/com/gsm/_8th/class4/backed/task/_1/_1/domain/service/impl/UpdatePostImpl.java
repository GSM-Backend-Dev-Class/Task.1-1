package com.gsm._8th.class4.backed.task._1._1.domain.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.dto.AnggimoddiDTO;
import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import com.gsm._8th.class4.backed.task._1._1.domain.repository.AngRepository;
import com.gsm._8th.class4.backed.task._1._1.domain.service.UpdatePost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UpdatePostImpl implements UpdatePost {
    private final AngRepository angRepository;

    public ResponseEntity<Ang> updatePost(AnggimoddiDTO anggimoddiDTO, Long postId) {
        try {
            Optional<Ang> ang = angRepository.findById(postId);
            Ang upAng = ang.get();
            upAng.builder()
                    .idx(anggimoddiDTO.getId())
                    .title(anggimoddiDTO.getTitle())
                    .content(anggimoddiDTO.getContent())
                    .build();
            angRepository.save(upAng);
            return ResponseEntity.ok(upAng);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
