/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctc.javatest.business;

import ctc.javatest.api.UserVO;
import java.util.List;

/**
 *
 * @author gerardo
 */
public interface UserServiceInt {
   
   void save(UserVO user);
   void update(UserVO user);
   void delete(UserVO user);
   
   List<UserVO>all();
   UserVO get(UserVO user);
}
