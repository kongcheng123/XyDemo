package com.example.demo.Controller;

import com.example.demo.Dao.AdminDao;
import com.example.demo.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xy on 2017/7/10.
 */

@Controller
public class HelloController {
    @Autowired
    private AdminDao adminDao;

    @RequestMapping("/hello")
    public String test(){
        Admin a=new Admin();
        a.setName("hahah");
        a.setPass("hahah");
        a.setType(0);
        a.setCreateTime("hahah");
        a.setUpdateTime("haha");
        adminDao.save(a);
        return "success";
    }

    @RequestMapping("/html")
    public String testHtml(){
        return "index";
    }
}
