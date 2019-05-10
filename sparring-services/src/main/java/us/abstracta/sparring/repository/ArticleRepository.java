package us.abstracta.sparring.repository;

import us.abstracta.sparring.model.Article;
import java.util.List;

public interface ArticleRepository {


    public List<Article> getArticles();

    public List<Article> getArticlesByCat(String cat);

    public Article getArticleById(int id);
}
