package zk.maven.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("generalDAO")
@Transactional
public class GeneralDAO {

    @PersistenceContext
    protected EntityManager em;

    public void insert(Object obj) {
        this.em.merge(obj);
    }

    public void update(Object obj) {
        this.em.merge(obj);
    }

    public void delete(Object obj) {
        this.em.remove(this.em.merge(obj));
    }
}