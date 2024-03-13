package com.istl.interview.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    //region Methods

    @GetMapping("/")
    public String index() {
        return "index";
    }

    //endregion
}
