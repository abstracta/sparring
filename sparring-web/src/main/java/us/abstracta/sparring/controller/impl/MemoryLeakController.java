package us.abstracta.sparring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import us.abstracta.sparring.controller.Controller;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemoryLeakController implements Controller {

    @Autowired
    ArticleDAO articleDAO;
    List<Article> knownArticles = new ArrayList();

    HashMap<CacheKey, Article> cacheArticles= new HashMap<CacheKey, Article>();


    /* get all the articles */
    @Override
    public List<Article> getArticles() {
        List<Article> articles=articleDAO.getArticles();
        knownArticles.addAll(articles);
        return articles;
    }

    /* get all the articles by cat */
    @Override
    public List<Article> getArticlesByCat(@RequestParam("cat") String cat) {
        return articleDAO.getArticlesByCat(cat);
    }

    /* get article by id */
    @Override
    public Article getArticleById(@PathVariable("id") int id) {
        CacheKey key= new CacheKey(id);
        Article article = cacheArticles.get(key);
        if (article==null){
            article=articleDAO.getArticleById(id);
            cacheArticles.put(key,article);
        }
        return article;
    }



    /*
        This class should override hashCode() and equals() in order to works as a key
     */
    public class CacheKey{

        private int id;

        public CacheKey(int id){
            id= id;
        }




    }

}
