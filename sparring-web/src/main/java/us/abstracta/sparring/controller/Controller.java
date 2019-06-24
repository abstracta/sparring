package us.abstracta.sparring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import us.abstracta.sparring.model.Article;
import us.abstracta.sparring.model.PaymentInfo;

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

    /* purchase an article */
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/purchase")
    public ResponseEntity<PaymentInfo> purchase(@RequestBody PaymentInfo request);


}
