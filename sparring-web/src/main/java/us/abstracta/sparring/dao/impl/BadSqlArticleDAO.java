package us.abstracta.sparring.dao.impl;

import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;
import java.util.List;

public class BadSqlArticleDAO implements ArticleDAO {


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
