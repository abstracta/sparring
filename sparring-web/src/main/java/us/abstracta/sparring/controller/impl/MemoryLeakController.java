package us.abstracta.sparring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import us.abstracta.sparring.controller.Controller;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;

import java.util.List;

public class MemoryLeakController implements Controller {

    @Autowired
    ArticleDAO articleDAO;


    /* get all the articles */
    @Override
    public List<Article> getArticles() {
        return articleDAO.getArticles();
    }

    /* get all the articles by cat */
    @Override
    public List<Article> getArticlesByCat(@RequestParam("cat") String cat) {
        return articleDAO.getArticlesByCat(cat);
    }

    /* get article by id */
    @Override
    public Article getArticleById(@PathVariable("id") int id) {
        for (int i = 0; i < 100000; i++) {
            finalizer f = new finalizer();
        }
        return articleDAO.getArticleById(id);
    }


    public class finalizer {
        @Override
        protected void finalize() throws Throwable {
            while (true) {
                Thread.yield();
            }
        }

    }

}
