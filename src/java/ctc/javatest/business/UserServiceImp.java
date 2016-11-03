/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctc.javatest.business;

import ctc.javatest.api.UserVO;
import ctc.javatest.data.UserDaoInt;
import ctc.javatest.entities.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gerardo
 */
@Service
public class UserServiceImp implements UserServiceInt {
    
    @Autowired
    private UserDaoInt userDao;
    
    @Override
    public void save(UserVO user) {
       if (user != null){
           User usr = convert(user);
           userDao.save(usr);
       }
    }

    @Override
    public void update(UserVO user) {
       if (user != null){
           User usr = convert(user);
           userDao.update(usr);
       } 
    }

    @Override
    public void delete(UserVO user) {
       if (user != null){
           User usr = convert(user);
           userDao.delete(usr);
       }
    }

    @Override
    public List<UserVO> all() {
       return convertToVOs(userDao.all());
    }

    @Override
    public UserVO get(UserVO user) {
        
        return convert(userDao.get(convert(user)));
    }
    
    public UserVO convert(User user){
        UserVO vo = new UserVO();
        if(user != null){
            
            vo.setId(user.getId());
            
            if (!user.getName().isEmpty()){
                vo.setName(user.getName());
            }
            
            if (!user.getLast_name().isEmpty()){
                vo.setLast_name(user.getName());
            }
            
            return vo;
            
        }else{
            return null;
        }
    }
    
    public User convert(UserVO user){
        User obj = new User();
        if(user != null){
            
            obj.setId(user.getId());
            
            if (!user.getName().isEmpty()){
                obj.setName(user.getName());
            }
            
            if (!user.getLast_name().isEmpty()){
                obj.setLast_name(user.getName());
            }
            
            return obj;
            
        }else{
            return null;
        }
    }
    
    public List<User> convertToObjs (List<UserVO> users){
        List<User> result = new ArrayList<User>();
        
        if( users != null ){
           
            for(UserVO vo : users){
                result.add(convert(vo));
            }
        }
        return result;
    }
    
    public List<UserVO> convertToVOs (List<User> users){
        List<UserVO> result = new ArrayList<UserVO>();
       
        if( users != null ){
          
            for(User obj : users){
                result.add(convert(obj));
            }
           
        }
        return result;
    }
    
    
}
