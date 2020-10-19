package com.domain.meh.repositories;

import com.domain.meh.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByTitle(String title);
    Article findByPublished(Long published);
}
