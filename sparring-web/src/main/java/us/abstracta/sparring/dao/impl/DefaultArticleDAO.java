package us.abstracta.sparring.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import us.abstracta.sparring.dao.ArticleDAO;
import us.abstracta.sparring.model.Article;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class DefaultArticleDAO implements ArticleDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



   @Override
    public List<Article> getArticles(){
       String sql = "SELECT * FROM sparringdb.articles";

       List<Article> articles  = jdbcTemplate.query(sql,
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