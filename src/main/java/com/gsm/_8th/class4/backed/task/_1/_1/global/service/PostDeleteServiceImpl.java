package com.gsm._8th.class4.backed.task._1._1.global.service;
import com.gsm._8th.class4.backed.task._1._1.global.repository.PostRepository;
import com.gsm._8th.class4.backed.task._1._1.global.service.PostDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostDeleteServiceImpl implements PostDeleteService {
    private final PostRepository postRepository;

    @Override
    @Transactional
    public boolean deletePost(Long id) {
        try {
           postRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
