package com.example.demo_web.Entity;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo_web.service.SystemCodeDBRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by luxuda on 7/16/2017.
 */
public class SystemcodeValidator implements ConstraintValidator<SystemcodeVal, String> {
 //   @Resource
//    private ResourceBundleMessageSource messageSource;

    private SystemcodeVal systemcode;
    @Autowired
    private SystemCodeDBRepository systemCodeDBRepository;

    @Override
    public void initialize(SystemcodeVal systemcode) {
       this.systemcode=systemcode;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
        boolean isValid;

        List<SystemCode> systemCodeListxuda= systemCodeDBRepository.findByCodename( "ZouXuan" );
        if(value != null&&value.equals("ZouXuan") ) {
            isValid = true;
        }
        else {
            isValid = false;
        }
        if(!isValid) {
           constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(systemcode.message()).addConstraintViolation();
        }
        return isValid;

    }
}
