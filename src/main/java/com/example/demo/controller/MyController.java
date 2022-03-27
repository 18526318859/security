package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String show(Model model){
            model.addAttribute ( "msg","错误" );
            return "index";
        }
      @RequestMapping("/add")
        public String add(){
        return "user/add";
        }

    @RequestMapping("/login")
    public  String login()
    {
        return "views/login";
    }

    @RequestMapping("/update")
        public String update(){
        return "user/update";
        }


}
