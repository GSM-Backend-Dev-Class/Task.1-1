package com.gsm._8th.class4.backed.task._1._1.domain.service.impl;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import com.gsm._8th.class4.backed.task._1._1.domain.repository.AngRepository;
import com.gsm._8th.class4.backed.task._1._1.domain.service.Postpost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class PostpostImpl implements Postpost {
    private final AngRepository angRepository;

    public ResponseEntity<Ang> postPost(Ang ang) {
        return ResponseEntity.ok(angRepository.save(ang));
    }
}
