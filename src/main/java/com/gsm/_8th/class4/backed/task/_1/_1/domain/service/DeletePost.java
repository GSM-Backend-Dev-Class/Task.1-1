package com.gsm._8th.class4.backed.task._1._1.domain.service;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DeletePost {
    ResponseEntity<Ang> deleteAng(Long id);
}
