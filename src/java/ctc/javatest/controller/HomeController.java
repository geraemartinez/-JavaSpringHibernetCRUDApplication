/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctc.javatest.controller;

import ctc.javatest.api.UserVO;
import ctc.javatest.business.UserServiceInt;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author gerardo
 */
@Controller
public class HomeController {
    
    @Autowired
    private UserServiceInt userService;
    
    @ModelAttribute("UserVO")
    public UserVO getUserVO(){
        return new UserVO();
    }
    
    @RequestMapping("/index")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
	return mv;

    }
    
    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView("add");
	return mv;
    }
    
    @RequestMapping("/save")
    public ModelAndView save(@ModelAttribute("UserVO") UserVO vo){
        userService.save(vo);
        List<UserVO> users =  userService.all();
        ModelAndView mv = new ModelAndView("add");
        mv.addObject("users", users);
	return mv;
    }
    
    @RequestMapping("/edit")
    public ModelAndView edit(){
        return null;
    }
    
    @RequestMapping("/delete")
    public ModelAndView delete(){
        return null;
    }
    
    @RequestMapping("/list")
    public ModelAndView list(){
        List<UserVO> users =  userService.all();
        ModelAndView mv = new ModelAndView("add");
        mv.addObject("users", users);
        return null;
    }
    
    @RequestMapping("/get")
    public ModelAndView get(){
        return null;
    }
    
    
    
}
