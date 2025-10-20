package com.example.reactive_news_app.service;

import com.example.reactive_news_app.model.NewsArticle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class NewsService {

    private final Map<Long, NewsArticle> newsRepository = new HashMap<>();
    private final List<String> categories = Arrays.asList("TECH", "SPORTS", "POLITICS", "ENTERTAINMENT", "SCIENCE");
    private final List<String> authors = Arrays.asList("김기자", "이기자", "박기자", "최기자", "정기자");

    public NewsService() {
        initializeData();
    }

    /**
     * 초기 데이터 생성
     */
    private void initializeData() {
        log.info("초기 뉴스 데이터 생성 시작");

        List<NewsArticle> initialNews = Arrays.asList(
                NewsArticle.create("Spring WebFlux 완전정복", "리액티브 프로그래밍의 새로운 패러다임", "TECH", "김기자"),
                NewsArticle.create("월드컵 결승전 하이라이트", "역사상 가장 치열했던 경기", "SPORTS", "이기자"),
                NewsArticle.create("새로운 정책 발표", "국민들의 관심이 집중되고 있습니다", "POLITICS", "박기자"),
                NewsArticle.create("블록버스터 영화 개봉", "올해 최고의 작품으로 평가받고 있습니다", "ENTERTAINMENT", "최기자"),
                NewsArticle.create("획기적인 과학적 발견", "노벨상 수상이 유력한 연구 결과", "SCIENCE", "정기자")
        );

        for (int i = 0; i < initialNews.size(); i++) {
            NewsArticle article = initialNews.get(i);
            article.setId((long) (i + 1));
            article.setViewCount(ThreadLocalRandom.current().nextInt(100, 1000));
            newsRepository.put(article.getId(), article);
        }

        log.info("초기 뉴스 데이터 {} 개 생성 완료", initialNews.size());
    }
}
