package us.abstracta.sparring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import us.abstracta.sparring.repository.ArticleRepository;
import us.abstracta.sparring.model.Article;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;


    /* get all the articles */
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    /* get all the articles by cat */
    @CrossOrigin(origins = "*")
    @GetMapping("/all/category")
    public List<Article> getArticlesByCat(@RequestParam("cat") String cat) {
        return articleRepository.getArticlesByCat(cat);
    }

    /* get article by id */
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public List<Article> getArticleById(@PathVariable("id") int id) {
        return articleRepository.getArticleById(id);
    }

}
