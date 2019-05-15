package us.abstracta.sparring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.dao.impl.DefaultArticleDAO;
import us.abstracta.sparring.dao.impl.BadSqlArticleDAO;

@Configuration
public class SparringConfig {

    @Bean
    public ArticleDAO articleDAO(@Value("${articleDAO}") String articleDAO) {
        if ("Default".equals(articleDAO)) {
            return new DefaultArticleDAO();
        } else {
            return new BadSqlArticleDAO();
        }
    }

}
