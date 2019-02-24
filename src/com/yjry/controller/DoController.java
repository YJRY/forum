package com.yjry.controller;

import com.alibaba.fastjson.JSONObject;
import com.yjry.entity.Exp;
import com.yjry.entity.Post;
import com.yjry.entity.User;
import com.yjry.pojo.Data;
import com.yjry.pojo.Page;
import com.yjry.service.ExpService;
import com.yjry.service.PostService;
import com.yjry.service.SignService;
import com.yjry.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.Random;

@Controller
public class DoController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private SignService signService;

    @Autowired
    private ExpService expService;


    @RequestMapping("/doReg")
    @ResponseBody
    public JSONObject doReg(HttpServletRequest req){
        String vercode = req.getParameter("vercode");
        String code = (String)req.getSession().getAttribute("code");
        JSONObject jsonObject = new JSONObject();
//        PrintWriter out = resp.getWriter();
        if(!vercode.equalsIgnoreCase(code)){
            jsonObject.put("msg", "验证码有误，请重新输入！");
            jsonObject.put("flag", 0);
        } else{
            String username = req.getParameter("username");
            if(!userService.isReg(username)){
                String pwd = req.getParameter("pwd");
                if(userService.addUser(username, pwd) == 1){
                    jsonObject.put("msg", "注册成功");
                    jsonObject.put("flag", 1);
                }else{
                    jsonObject.put("msg", "注册失败，请稍候再试");
                    jsonObject.put("flag", 0);
                }
            }else{
                jsonObject.put("msg", "账号名称已存在，请重新输入");
                jsonObject.put("flag", 0);
            }
        }
        return jsonObject;
    }

    @RequestMapping("/validate")
    public void getValidate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedImage bi = new BufferedImage(100, 35, BufferedImage.TYPE_INT_RGB);
        char[] ch = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890".toCharArray();
        Graphics g = bi.getGraphics();
        Color c = new Color(219, 238, 206);
        Font font = new Font("黑体", Font.BOLD, 20);
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int len = ch.length;
        int index;
        g.setColor(c);
        g.fillRect(0, 0, 100, 35);
        for(int i = 0; i < 10; i++){
            g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
            int x1 = random.nextInt(100);
            int y1 = random.nextInt(35);
            int x2 = random.nextInt(100);
            int y2 = random.nextInt(35);
            g.drawLine(x1, y1, x2, y2);
        }
        for(int i = 0; i < 4; i++){
            index = random.nextInt(len);
            char temp = ch[index];
            g.setColor(new Color(random.nextInt(88), random.nextInt(176), random.nextInt(255)));
            g.setFont(font);
            g.drawString(temp + "", i * 25 + 3, 20);
            sb.append(temp);
        }
        req.getSession().setAttribute("code", sb.toString());
        ImageIO.write(bi, "jpg", resp.getOutputStream());
    }

    @RequestMapping("/doPage")
    @ResponseBody
    public JSONObject doPage(HttpServletRequest req){
        int pageNow = Integer.parseInt(req.getParameter("pageNow"));
        int showCount = Integer.parseInt(req.getParameter("showCount"));
        Data<Post> data = new Data<>();
        Page page = new Page();
        JSONObject jsonObject = new JSONObject();
//        PrintWriter out = resp.getWriter();
        int totalPageCount = ((postService.getRowCount() % showCount) == 0) ? (postService.getRowCount() / showCount) : (postService.getRowCount() / showCount + 1);
        String typestr = req.getSession().getAttribute("type").toString();
        int type = Integer.parseInt(typestr);
        java.util.List<Post> postList = postService.getDataByPageAndType((pageNow-1) * showCount, type, showCount);
        java.util.List<User> userList = userService.getUsersByPost(postList);
        List<Exp> expList = expService.getExpsByUser(userList);
        data.setDataList(postList);
        data.setUserList(userList);
        data.setExpList(expList);
        page.setShowCount(showCount);
        page.setTotalRowCount(postService.getRowCountByType(type));
        page.setTotalPageCount(totalPageCount);
        page.setPageNow(pageNow);
        data.setPage(page);
        jsonObject.put("data", data);
//        out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    @RequestMapping("/doLogout")
    @ResponseBody
    public JSONObject doLogout(HttpServletRequest req){
        req.getSession().removeAttribute("user");
//        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = new JSONObject();
        if(req.getSession().getAttribute("user") == null){
            jsonObject.put("msg", "账户已注销");
//            out.println(jsonObject.toJSONString());
        }else{
            jsonObject.put("msg", "系统繁忙");
        }
        return jsonObject;
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public JSONObject doLogin(HttpServletRequest req){
        String vercode = req.getParameter("vercode");
        String code = (String)req.getSession().getAttribute("code");
        JSONObject jsonObject = new JSONObject();
//        PrintWriter out = resp.getWriter();
        if(!vercode.equalsIgnoreCase(code)){
            jsonObject.put("msg", "验证码有误，请重新输入！");
            jsonObject.put("flag", 0);
        } else{
            String username = req.getParameter("username");
            String pwd = req.getParameter("pwd");
            if(userService.hasUser(username, pwd)){
                jsonObject.put("msg", "欢迎你，" + username);
                jsonObject.put("flag", 1);
                User user = userService.getUserByNameAndPwd(username, pwd);
                Exp exp = expService.getDataByExp(user.getExp());
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("exp", exp);
                System.out.println(exp.getName());
            }else{
                jsonObject.put("msg", "账号或密码有误，请重新输入！");
                jsonObject.put("flag", 0);
            }
        }
//        out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    @RequestMapping("/doAdd")
    @ResponseBody
    public JSONObject doAdd(HttpServletRequest req){
        String vercode = req.getParameter("vercode");
        JSONObject jsonObject = new JSONObject();
//        PrintWriter out = resp.getWriter();
        if (!vercode.equalsIgnoreCase((String) req.getSession().getAttribute("code"))) {
            jsonObject.put("msg", "验证码有误，请重新输入！");
            jsonObject.put("flag", 0);
        } else {
            User user = (User) req.getSession().getAttribute("user");
            String username = user.getName();
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int type = Integer.parseInt(req.getParameter("type"));
            if (postService.addPost(username, title, content, type) == 1) {
                jsonObject.put("msg", "发帖成功");
                jsonObject.put("flag", 1);
            } else {
                jsonObject.put("msg", "发帖失败");
                jsonObject.put("flag", 0);
            }
        }
//        out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    @RequestMapping("/doChange")
    @ResponseBody
    public JSONObject doChange(HttpServletRequest req){
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
//        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = new JSONObject();
        String pwdNow = req.getParameter("pwdNow");
        String pwdNew = req.getParameter("pwdNew");
        String pwdNew_c = req.getParameter("pwdNew_c");
        if(email != null && sex != null){
            if(userService.changeUser(user.getId(), email, sex) == 1){
                user.setEmail(email);
                user.setSex(sex);
                jsonObject.put("msg", "修改成功");
            }else{
                jsonObject.put("msg", "修改失败");
            }
        }else if(pwdNow != null && pwdNew != null && pwdNew_c != null){
            String pwdBefore = user.getPwd();
            if(!pwdNow.equals(pwdBefore)){
                jsonObject.put("msg", "原密码不正确，请重新输入");
            }else{
                if(!pwdNew.equals(pwdNew_c)){
                    jsonObject.put("msg", "两次输入的密码不一致");
                }else{
                    if(userService.changePwd(user.getId(), pwdNew) == 1){
                        user.setPwd(pwdNew);
                        jsonObject.put("msg", "修改成功");
                    }else{
                        jsonObject.put("msg", "修改失败");
                    }
                }
            }
        }
//        out.println(jsonObject.toJSONString());
        return jsonObject;
    }

    @RequestMapping("/doExp")
    @ResponseBody
    public JSONObject doExp(HttpServletRequest req){
        User user = (User)req.getSession().getAttribute("user");
//        PrintWriter out = resp.getWriter();
        JSONObject jsonObject = new JSONObject();
        if(signService.hasSign(user.getName())){
            jsonObject.put("flag", 1);
        }else{
            int num = Integer.parseInt(req.getParameter("num"));
            Exp exp = (Exp)req.getSession().getAttribute("exp");
            expService.addExp(num, user.getId());
            signService.addSign(user.getName());
            exp.setExp(exp.getExp() + num);
            req.getSession().setAttribute("exp", exp);
            jsonObject.put("msg", "积分+" + num);
            jsonObject.put("flag", 1);
//            out.println(jsonObject.toJSONString());
        }
        return jsonObject;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject doUpload(HttpServletRequest req){
        String savePath = "D:\\IntelijProjects\\SVN\\U3Demo\\web\\images\\userImage";
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        JSONObject jsonObject = new JSONObject();
//        PrintWriter out = resp.getWriter();
        try{
            //创建DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(req);
            for(FileItem item: list){
                String filename = item.getName();
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                filename = getRandom() + filename.substring(filename.lastIndexOf("."));
                System.out.println(filename);
                //获取item中的上传文件输入流
                InputStream in = item.getInputStream();
                //创建一个文件输出流
                FileOutputStream fileout = new FileOutputStream(savePath + "\\" + filename);
                //创建一个缓冲区
                byte[] buffer = new byte[1024];
                int len = 0;
                while((len =in.read(buffer)) > 0){
                    fileout.write(buffer, 0, len);
                }
                in.close();
                fileout.close();
                item.delete();
                User user = (User)req.getSession().getAttribute("user");
                String path = "./images/userImage/" + filename;
                if(userService.addImagePath(user.getId(), path) == 1){
                    user.setImage(path);
                    jsonObject.put("msg", "图片上传成功");
                }else{
                    jsonObject.put("msg", "图片上传失败");
                }
//                out.println(jsonObject.toJSONString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String getRandom(){
        String str = "";
        for(int i = 0; i < 10; i++){
            str += Math.round(Math.random() * 10);
        }
        return str;
    }

}
