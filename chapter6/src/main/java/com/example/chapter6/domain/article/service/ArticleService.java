package com.example.chapter6.domain.article.service;

import com.example.chapter6.domain.article.entity.Article;
import com.example.chapter6.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public long count() {
        return articleRepository.count();
    }
    public Article write(String title, String body){
        Article article = Article
                .builder()
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .title(title)
                .body(body)
                .build();
        return articleRepository.save(article);
    }
    public void delete(Article article) {
        articleRepository.delete(article);
    }
    public Optional<Article> findById(long Id){
        return articleRepository.findById(Id);
    }
    public List<Article> findAll(){
        return articleRepository.findAll();
    }
}
