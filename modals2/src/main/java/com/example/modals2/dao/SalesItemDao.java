package com.example.modals2.dao;

import com.example.modals2.model.SalesItem;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

// @Repository
public class SalesItemDao {

    //@PersistenceContext
    private EntityManager em;

    public List<SalesItem> findAll() {
        return em.createQuery("select i from SalesItem i", SalesItem.class).getResultList();
    }

    /*public SalesItem findSalesItemByTitle(String title) {
        TypedQuery<SalesItem> query = em.createQuery("select s from SalesItem s where s.title = :title", SalesItem.class);
        query.setParameter("title", title);

        return query.getSingleResult();
    }

    public SalesItem findSalesItemByText(String text) {
        TypedQuery<SalesItem> query = em.createQuery("select s from SalesItem s where s.text = :text", SalesItem.class);
        query.setParameter("text", text);

        return query.getSingleResult();
    }*/

    public List<SalesItem> findSalesItemsByTitle(String title) {
        TypedQuery<SalesItem> query = em.createQuery("select s from SalesItem s where s.title = :title", SalesItem.class);
        query.setParameter("title", title);

        return query.getResultList();
    }

    public List<SalesItem> findSalesItemsByText(String text) {
        TypedQuery<SalesItem> query = em.createQuery("select s from SalesItem s where s.text = :text", SalesItem.class);
        query.setParameter("text", text);

        return query.getResultList();
    }



}
