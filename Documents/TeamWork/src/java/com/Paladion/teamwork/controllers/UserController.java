/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Paladion.teamwork.controllers;

import com.Paladion.teamwork.beans.EmailBean;
import com.Paladion.teamwork.beans.UserDataBean;

import com.Paladion.teamwork.services.LoginService;
import com.Paladion.teamwork.services.UserService;
import com.Paladion.teamwork.utils.EmailUtil;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
@Controller
public class UserController {
	
    @Autowired
 @Qualifier(value="LoginService")
 LoginService LS;
 
 
 
 UserDataBean lb=null;
	
@Autowired
@Qualifier(value="UserService")
 UserService userService;
	
@ModelAttribute("UserM")
 public UserDataBean PopulateLoginBean() 
{
   return new UserDataBean(); // populates form for the first time if its null
}
	
 
	@RequestMapping(value="/CreateUser",method=RequestMethod.GET)
     public String createUser()
    {   
	    return "CreateUser";
    }
	
	@RequestMapping(value="/CreateUser",method=RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("UserM")UserDataBean loginBean,HttpServletRequest req )
    {
        System.out.println("in user controller create user post method");
    
	  boolean result = userService.addUser(loginBean);
	   if(result==true){
               
               //Send Email to user
               EmailBean ebean=new EmailBean();
               EmailUtil eutil=new EmailUtil();
               ebean.setTo(loginBean.getEmail());
               String subject="Paladion TeamWork- User Account Invitation";
               String message="Dear "+loginBean.getUsername()+"\n\nYour account has been created in the Paladion Teamwork Application ( http://10.0.1.128/TeamWork/ ).\nPlease Log into your account using the following credentials\n\nUsername: "+loginBean.getEmail() +"\nPassword: "+loginBean.getPassword()+"\n\n\n\nBest Regards\nTeam Paladion";
               ebean.setSubject(subject);
               ebean.setMessage(message);
               eutil.sendEmail(ebean);
               
               //Update user list in session
                HttpSession Sess=req.getSession(false);
                Sess.setAttribute("AllUsers", userService.GetAllUser());
                      
                return new ModelAndView("CreateUser","Message","User Created Successfully");
           }
           else{
               return new ModelAndView("CreateUser","Message","User Creation Failed Due to Error");
           }
        }


@RequestMapping(value="/ViewAllUser",method=RequestMethod.GET)
public ModelAndView ViewAllUser( )
    {
        System.out.println("ViewAllUser");
    
	   List<UserDataBean> userList=userService.GetAllUser();
	   ModelAndView result=new ModelAndView("ViewAllUser");
           result.addObject("AllUsers",userList);
	   return result;
        }

@RequestMapping(value="/DeleteUser",method=RequestMethod.GET)
    public ModelAndView DeleteUser(@RequestParam int id, HttpServletRequest req) throws ParseException
    {
        ModelAndView result=new ModelAndView("ViewAllUser");
           if(id!=0)
           {
               userService.DeleteUser(id);
               List<UserDataBean> userList=userService.GetAllUser();
               HttpSession Sess=req.getSession(false);
               //update user list in session
               Sess.setAttribute("AllUsers", userList);
	       result.addObject("AllUsers",userList);
               result.addObject("Message","User deleted successfully");    
           }
           else{
                result=new ModelAndView("Welcome");
            }
           return result;
      
    }
    
@RequestMapping(value="/GetUserDetails",method=RequestMethod.GET)
public ModelAndView GetUserDetails(@RequestParam int id)
{
           ModelAndView result=new ModelAndView("UpdateUser");
           if(id!=0)
            {
                UserDataBean userBean=userService.GetUserById(id);
                result.addObject("UserDetail",userBean);
                return result;
            }
           else{
                result=new ModelAndView("fail");
            }
           return result;
}
    


@RequestMapping(value="/UpdateUserDetails",method=RequestMethod.POST)
    public ModelAndView updateUserDetails(@ModelAttribute("UserM")UserDataBean UserBean)
    {
        System.out.println("in update user details controller method");
    
	   userService.UpdateUserDetails(UserBean);
           
           List<UserDataBean> userList=userService.GetAllUser();
	   ModelAndView result=new ModelAndView("ViewAllUser");
           result.addObject("AllUsers",userList);
           result.addObject("Message","User Details Updated Successfully");
	   return result;
	   
	   
        }
    
}

