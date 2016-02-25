package zk.maven.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zk.maven.entity.Person;

/**
 * Data Access Object for Person Entity (tblperson)
 * @author hendro.tampake
 *
 */

@Repository("personDAO")
@Transactional
public class PersonDAO extends GeneralDAO {

	public List<Person> getAll(){
		return em.createQuery("SELECT p FROM Person p").getResultList();
	}
}
