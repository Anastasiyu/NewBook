package com.example.newbook.service;

import com.example.newbook.exception.IncorrectParamExeption;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public String validate(String param){
        if(!StringUtils.isAlpha(param)){
            throw  new IncorrectParamExeption();
        }
        return StringUtils.capitalize(param.toLowerCase());
    }
}
