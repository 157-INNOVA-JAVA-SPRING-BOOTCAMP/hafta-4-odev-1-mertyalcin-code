package com.innova.controller;


import com.innova.dto.UserValidationDto;
import com.innova.entity.UserEntity;
import com.innova.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j2
public class UserController {
    @Autowired
    UserRepository userRepository;
    // http://localhost:8080/register
    @GetMapping("/register")
    public String getForm(Model model) {
        model.addAttribute("key_form", new UserValidationDto());
        return "registerformfloating";
    }

    // http://localhost:8080/register
    @PostMapping("/register")
    public String postForm(@Valid @ModelAttribute("key_form") UserValidationDto dto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(dto);
            return "registerformfloating";
        }
        UserEntity newUser= UserEntity.builder()
                .userId(0L)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                        .email(dto.getEmail()).build();
        userRepository.save(newUser);
            log.info(dto);
            return "success";
    }
    @GetMapping("/user/list")
    @ResponseBody
    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }

}
