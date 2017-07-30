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

    private SystemcodeVal systemcodeVal;
    @Override
    public void initialize(SystemcodeVal systemcodeVal) {
       this.systemcodeVal=systemcodeVal;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
        boolean isValid;

      //  List<SystemCode> systemCodeListxuda= systemCodeDBRepository.findByCodename( "ZouXuan" );
        if(value != null&& value.equals("ZouXuan")&&systemcodeVal.isNeedPatch().equals("YES") ) {
            isValid = true;
        }
        else {
            isValid = false;
        }
        if(!isValid) {
           constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(systemcodeVal.message()).addConstraintViolation();
        }
        return isValid;

    }
}
