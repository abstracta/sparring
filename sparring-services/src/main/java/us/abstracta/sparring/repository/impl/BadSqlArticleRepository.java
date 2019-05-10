package us.abstracta.sparring.repository.impl;

import us.abstracta.sparring.repository.ArticleRepository;
import us.abstracta.sparring.model.Article;
import java.util.List;

public class BadSqlArticleRepository implements ArticleRepository {


    @Override
    public List<Article> getArticles(){
        return null;
    }

    @Override
    public List<Article> getArticlesByCat(String cat){
        return null;
    }

    @Override
    public Article getArticleById(int id){
        return null;
    }
}
