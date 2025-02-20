package com.gsm._8th.class4.backed.task._1._1.domain.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.dto.AnggimoddiDTO;
import com.gsm._8th.class4.backed.task._1._1.domain.entity.Ang;
import com.gsm._8th.class4.backed.task._1._1.domain.service.DeletePost;
import com.gsm._8th.class4.backed.task._1._1.domain.service.GetPost;
import com.gsm._8th.class4.backed.task._1._1.domain.service.Postpost;
import com.gsm._8th.class4.backed.task._1._1.domain.service.UpdatePost;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class AnggimoddiController {

    private final GetPost getPost;
    private final Postpost postpost;
    private final UpdatePost updatePost;
    private final DeletePost deletePost;

    @GetMapping("/")
    public ResponseEntity<List<Ang>> getShitAll() {
        return getPost.getAngs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ang>> getThatShit(@PathVariable Long id) {
        return getPost.getAngById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Ang> makeShit(Ang ang) {
        return postpost.postPost(ang);
    }

    @PatchMapping(("/{id}"))
    public ResponseEntity<Ang> editThatShit(AnggimoddiDTO anggimoddiDTO, @PathVariable Long id) {
        return updatePost.updatePost(anggimoddiDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ang> removeThatShit(@PathVariable Long id) {
        return deletePost.deleteAng(id);
    }
}
