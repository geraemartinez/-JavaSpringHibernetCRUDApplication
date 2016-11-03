/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctc.javatest.data;

import ctc.javatest.entities.User;
import java.util.List;

/**
 *
 * @author gerardo
 */
public interface UserDaoInt {
    
   void save(User user);
   void update(User user);
   void delete(User user);
   
   List<User>all();
   User get(User user);
}
