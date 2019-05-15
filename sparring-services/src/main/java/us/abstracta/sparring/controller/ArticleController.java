package us.abstracta.sparring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleDAO articleDAO;


    /* get all the articles */
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Article> getArticles() {
        return articleDAO.getArticles();
    }

    /* get all the articles by cat */
    @CrossOrigin(origins = "*")
    @GetMapping("/all/category")
    public List<Article> getArticlesByCat(@RequestParam("cat") String cat) {
        return articleDAO.getArticlesByCat(cat);
    }

    /* get article by id */
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable("id") int id) {
        return articleDAO.getArticleById(id);
    }

}
