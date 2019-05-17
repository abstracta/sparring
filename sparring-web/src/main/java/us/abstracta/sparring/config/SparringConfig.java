package us.abstracta.sparring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.dao.impl.DefaultArticleDAO;
import us.abstracta.sparring.dao.impl.BadSqlArticleDAO;
import us.abstracta.sparring.controller.impl.MemoryLeakController;
import us.abstracta.sparring.controller.impl.ArticleController;
import us.abstracta.sparring.controller.Controller;


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

    @Bean
    public Controller controller(@Value("${controller}") String controller) {
        if ("MemoryLeak".equals(controller)) {
            return new MemoryLeakController();
        } else {
            return new ArticleController();
        }
    }

}
