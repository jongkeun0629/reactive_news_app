package com.example.reactive_news_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("news_articles")
public class NewsArticle {

    @Id
    private Long id;

    private String title;
    private String content;
    private String category;
    private String author;
    private LocalDateTime publishedAt;
    private Integer viewCount;
    private List<String> tags;

    // 정적 팩토리 메서드
    public static NewsArticle create(String title, String content, String category, String author) {
        return NewsArticle.builder()
                .title(title)
                .content(content)
                .category(category)
                .author(author)
                .publishedAt(LocalDateTime.now())
                .viewCount(0)
                .build();
    }
}