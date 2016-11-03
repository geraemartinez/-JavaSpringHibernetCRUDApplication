/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctc.javatest.data;

import ctc.javatest.entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author gerardo
 */
@Repository
public class UserDaoImp implements UserDaoInt{
    
    //private static Logger logger = Logger.getLogger(UserDaoInt);
    private EntityManager entityManager;

    public UserDaoImp(){
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
	entityManager = emf.createEntityManager();
    }
    @Override
    public void save(User user) {
        EntityTransaction transaction = null;
        try{
            if (get(user)==null){

                transaction = entityManager.getTransaction();
                transaction.begin();
                entityManager.persist(user);
                entityManager.flush();
                transaction.commit();
             }
        }catch(PersistenceException e){
            transaction.rollback();
            e.printStackTrace();
                
        }catch(Exception e){
            transaction.rollback();
             e.printStackTrace();
                
        }
       
       
    }

    @Override
    public void update(User user) {
        
        try{
            
            entityManager.contains(user);
            entityManager.merge(user);
            entityManager.flush();

        }catch(PersistenceException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> all() {
        StringBuilder sql = new StringBuilder("SELECT u FROM User u");
	Query q = entityManager.createQuery(sql.toString());
	try {
            List<User> users = q.getResultList();
            if (CollectionUtils.isEmpty(users)) {
                    return null;
            } else {
                    return users;
            }
	} catch (PersistenceException e) {
                e.printStackTrace();
	} catch (Exception e){
                e.printStackTrace();
        }
        return null;
    }

    @Override
    public User get(User user) {
        StringBuilder sql = new StringBuilder("SELECT u FROM User u WHERE u.id = :id");
	Query q = entityManager.createQuery(sql.toString());
	q.setParameter("id", user.getId());
        try {
            List<User> users = q.getResultList();
            if (CollectionUtils.isEmpty(users)) {
                    return null;
            } else {
                    return users.get(0);
            }
	} catch (PersistenceException e) {
                e.printStackTrace();
	} catch (Exception e){
                e.printStackTrace();
        }
        return null;
        
    }
    
}
