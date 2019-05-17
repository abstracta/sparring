package us.abstracta.sparring.dao;

import us.abstracta.sparring.model.Article;
import java.util.List;

public interface ArticleDAO {


    public List<Article> getArticles();

    public List<Article> getArticlesByCat(String cat);

    public Article getArticleById(int id);
}
