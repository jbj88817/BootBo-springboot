package us.bojie.bootbo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import us.bojie.bootbo.domain.Girl;
import us.bojie.bootbo.domain.Result;
import us.bojie.bootbo.repository.GirlRepository;
import us.bojie.bootbo.service.GirlService;
import us.bojie.bootbo.utils.ResultUtil;

@SuppressWarnings("ALL")
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository mGirlRepository;

    @Autowired
    private GirlService mGirlService;

    // Find all girls
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList");
        return mGirlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(mGirlRepository.save(girl));
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return mGirlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {

        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return mGirlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        mGirlRepository.delete(id);
    }

    // Find by age
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return mGirlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        mGirlService.insertTwo();
    }
}
