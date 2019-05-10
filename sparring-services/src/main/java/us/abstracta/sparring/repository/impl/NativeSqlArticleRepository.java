package us.abstracta.sparring.repository.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import us.abstracta.sparring.repository.ArticleRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import us.abstracta.sparring.model.Article;
import java.util.List;

@Service
public class NativeSqlArticleRepository implements ArticleRepository {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Article> getArticles(){
        EntityManager session = entityManagerFactory.createEntityManager();
        try {
            List<Article> articles= (List<Article>) session.createNativeQuery("SELECT * FROM sparringdb.articles")
                    .getResultList();
            return articles;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            if(session.isOpen()) session.close();
        }
    }

    @Override
    public List<Article> getArticlesByCat(String cat){
        EntityManager session = entityManagerFactory.createEntityManager();
        try {
            List<Article> articles= (List<Article>) session.createNativeQuery("SELECT * FROM sparringdb.articles a WHERE a.category='" + cat + "'")
                    .getResultList();
            return articles;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            if(session.isOpen()) session.close();
        }
    }

    @Override
    public List<Article> getArticleById(int id){
        EntityManager session = entityManagerFactory.createEntityManager();
        try {
            List<Article> articles= (List<Article>) session.createNativeQuery("SELECT * FROM sparringdb.articles a WHERE a.id='" + id + "'")
                    .getResultList();

            return articles;
        }
        catch (NoResultException e){
            return null;
        }
        finally {
            if(session.isOpen()) session.close();
        }
    }







}