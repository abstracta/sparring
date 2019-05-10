package us.abstracta.sparring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.abstracta.sparring.repository.ArticleRepository;
import us.abstracta.sparring.repository.impl.NativeSqlArticleRepository;
import us.abstracta.sparring.repository.impl.DefaultArticleRepository;

@Configuration
public class SparringConfig {

    @Bean
    public ArticleRepository articleRepository(@Value("${articleRepository}") String articleRepository) {
        if ("NativeSql".equals(articleRepository)) {
            return new NativeSqlArticleRepository();
        } else {
            return new DefaultArticleRepository();
        }
    }

}
