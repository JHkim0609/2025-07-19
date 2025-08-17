package com.example.chapter6.global.initData;

import com.example.chapter6.domain.article.entity.Article;
import com.example.chapter6.domain.article.repository.ArticleRepository;
import com.example.chapter6.domain.article.service.ArticleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Profile("!prod")
@Configuration
@RequiredArgsConstructor
public class NotProd {
    @Lazy
    @Autowired
    private NotProd self;
    private final ArticleService articleService;

    @Bean
    public ApplicationRunner initNotProd() {
        return args -> {
            self.work();
            System.out.println("hi");
            self.work2();
        };
    }
    @Transactional
    public void work() {
        if ( articleService.count() > 0) return;
        articleService.write("제목1", "내용1");
    }
    @Transactional
    public void work2() {
        Article article = articleService.findById(1L).get();
    }
}
