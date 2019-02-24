package com.yjry.controller;

import com.yjry.entity.Exp;
import com.yjry.entity.Post;
import com.yjry.entity.User;
import com.yjry.service.ExpService;
import com.yjry.service.PostService;
import com.yjry.service.SignService;
import com.yjry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ToController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private SignService signService;

    @Autowired
    private ExpService expService;

    @RequestMapping("/testtest")
    public String toTesttest(int id, Model model){
        User user = userService.getUserById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "testtest";
    }

    @RequestMapping("/add")
    public String toAdd(){
        return "jie/add";
    }

    @RequestMapping("/exp")
    public String toExp(){
        return "exp";
    }

    @RequestMapping("/index")
    public String toIndex(HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
        HttpSession session = req.getSession();
        if(user != null){
            if(signService.hasSign(user.getName())){
                session.setAttribute("sign", true);
            }else{
                session.setAttribute("sign", false);
            }
        }
        List<Post> listLatest = postService.getLatestData();
        List<Post> listHot = postService.getHotData();
        List<User> userWithLatest = userService.getUsersByPost(listLatest);
        List<User> userWithHot = userService.getUsersByPost(listHot);
        List<Exp> expWithLatest = expService.getExpsByUser(userWithLatest);
        List<Exp> expWithHot = expService.getExpsByUser(userWithHot);
        session.setAttribute("latest", listLatest);
        session.setAttribute("hot", listHot);
        session.setAttribute("expWithLatest", expWithLatest);
        session.setAttribute("expWithHot", expWithHot);
        return "index";
    }

    @RequestMapping("/detail")
    public String toJieDetail(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        Post post = postService.getPostById(id);
        req.getSession().setAttribute("post", post);
        return "jie/detail";
    }

    @RequestMapping("/login")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("/register")
    public String toReg(){
        return "user/reg";
    }

    @RequestMapping("/userIndex")
    public String toUserIndex(){
        return "user/index";
    }

    @RequestMapping("/userMessage")
    public String toUserMessage(){
        return "user/message";
    }

    @RequestMapping("/userSet")
    public String toUserSet(){
        return "user/set";
    }

    @RequestMapping("/jieIndex")
    public String toJieIndex(HttpServletRequest req){
        HttpSession session = req.getSession();
        int type = Integer.parseInt(req.getParameter("type"));
        List<Post> list = postService.getDataByType(type);
        List<User> userList = userService.getUsersByPost(list);
        List<Exp> explist = expService.getExpsByUser(userList);
        session.setAttribute("type", type);
        session.setAttribute("postlist", list);
        session.setAttribute("typeNow", type);
        session.setAttribute("userlist", userList);
        session.setAttribute("explist", explist);
        return "jie/index";
    }

    @RequestMapping("/userHome")
    public String toUserHome(HttpServletRequest req){
        int id = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        User user = userService.getUserById(id);
        String username =  user.getName();
        List<Post> postList = postService.getDataByUser(username);
        session.setAttribute("postList", postList);
        req.setAttribute("user", user);
        return "user/home";
    }

}
