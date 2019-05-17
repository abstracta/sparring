package us.abstracta.sparring.controller;

import org.springframework.web.bind.annotation.*;
import us.abstracta.sparring.model.Article;

import java.util.List;

@RestController
@RequestMapping("/articles")
public interface Controller {

    /* get all the articles */
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Article> getArticles();

    /* get all the articles by cat */
    @CrossOrigin(origins = "*")
    @GetMapping("/all/category")
    public List<Article> getArticlesByCat(@RequestParam("cat") String cat);

    /* get article by id */
    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable("id") int id);


}
