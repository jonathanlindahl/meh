package com.domain.meh;

import com.domain.meh.repositories.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MehApplication {
    public static void main(String[] args) {
        SpringApplication.run(MehApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner createEntries(
            ArticleRepository articleRepository) {
        return (args) -> {
//            String title = "title";
//            String content = "content";
//            for (int i = 1; i < 11; ++i) {
//                articleRepository.save(
//                        new Article(
//                                title + String.valueOf(i),
//                                content + String.valueOf(i)));
//            }
        };
    }
}
