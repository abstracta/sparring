package us.abstracta.sparring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BadSqlArticleDAO implements ArticleDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Override
    public List<Article> getArticles(){
        String sqlExtra = "SELECT * FROM sparringdb.articles a1, sparringdb.articles a2, sparringdb.articles a3, sparringdb.articles a4";

        List<Article> articles  = jdbcTemplate.query(sqlExtra,
                new BeanPropertyRowMapper(Article.class));

        String sql = "SELECT * FROM sparringdb.articles";

        articles  = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Article.class));

        return articles;
    }

    @Override
    public List<Article> getArticlesByCat(String cat){
        String sql = "SELECT * FROM sparringdb.articles a WHERE a.category= :category";

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("category", cat);

        List<Article> articles  = namedParameterJdbcTemplate.query(sql, parameters,
                new BeanPropertyRowMapper(Article.class));
        return articles;

    }

    @Override
    public Article getArticleById(int id){
        String sql = "SELECT * FROM sparringdb.articles a WHERE a.id= :id";

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("id", id);

        List<Article> articles  = namedParameterJdbcTemplate.query(sql, parameters,
                new BeanPropertyRowMapper(Article.class));
        return articles.get(0);

    }
}
