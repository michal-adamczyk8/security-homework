package com.kodilla.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "/m1")
    public String m1() {
        System.out.println("m1");
        return "m1";
    }

    @GetMapping(path = "/m2")
    public String m2() {
        System.out.println("m2");
        return "m2";
    }


    @GetMapping(path = "/m3")
    public String m3() {
        System.out.println("m3");
        return "m3";
    }

}
