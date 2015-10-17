package com.codephobia.interfaces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by benimario on 15. 9. 13..
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public String index() {
        return "test";
    }

    @RequestMapping(value = "/json")
    @ResponseBody
    public Collection<String> jsonTest() {
        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        return list;
    }

}
