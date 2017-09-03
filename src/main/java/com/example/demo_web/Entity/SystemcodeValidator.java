package com.example.demo_web.Entity;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by luxuda on 7/16/2017.
 */
public class SystemcodeValidator implements ConstraintValidator<SystemcodeVal, String> {

    private SystemcodeVal systemcodeVal;

    @Override
    public void initialize(SystemcodeVal systemcodeVal) {
        this.systemcodeVal = systemcodeVal;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintContext) {
        boolean isValid;

        //  List<SystemCode> systemCodeListxuda= systemCodeDBRepository.findByCodename( "ZouXuan" );
        if (value != null && systemcodeVal.isNeedPatch().equals("NO")) {
            isValid = true;
        } else {
            isValid = false;
        }
        if (!isValid) {
            constraintContext.disableDefaultConstraintViolation();
            String msg =String.format(systemcodeVal.message(),systemcodeVal.lable());
            constraintContext.buildConstraintViolationWithTemplate( msg)
                        .addConstraintViolation();
        }
        return isValid;

    }
}
