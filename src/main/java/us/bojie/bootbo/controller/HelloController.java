package us.bojie.bootbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import us.bojie.bootbo.properties.GirlProperties;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties mGirlProperties;

    @RequestMapping(value = {"/say", "/hi"}, method = RequestMethod.GET)
    public String say() {
        return mGirlProperties.getCupSize();
    }

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable(value = "id") Integer id) {
        return "id " + id;
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String hello2(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id " + id;
    }
}
