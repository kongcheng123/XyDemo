package com.example.demo.Controller;

import com.example.demo.Dao.AdminDao;
import com.example.demo.Model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xy on 2017/7/10.
 */

@Controller
public class HelloController {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

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
        Admin a=new Admin();
        a.setName("hahah");
        a.setPass("hahah");
        a.setType(0);
        a.setCreateTime("hahah");
        a.setUpdateTime("haha");
        adminDao.save(a);
        logger.info("hahhaha--");
        return "index";
    }

    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public String hello() {
        getNameById(1);

        return "index";
    }

    public String getNameById(Integer id) {
        String sql = "select name from admin where id = ? ";
        List<String> list = jdbcTemplate.queryForList(sql, new Object[] {id}, String.class);
        return list.isEmpty() ? null : list.get(0);
    }

}
