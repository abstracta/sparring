package us.abstracta.sparring.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;
import us.abstracta.sparring.controller.Controller;
import us.abstracta.sparring.model.PaymentInfo;

import java.util.List;

public class ArticleController implements Controller {

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
        return articleDAO.getArticleById(id);
    }

    /* purchase an article */
    @Override
    public ResponseEntity<PaymentInfo> purchase(@RequestBody PaymentInfo request) {
        return new ResponseEntity<PaymentInfo>(request, HttpStatus.OK);
    }

}
