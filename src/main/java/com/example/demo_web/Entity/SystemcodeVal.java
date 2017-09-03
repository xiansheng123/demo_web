package com.example.demo_web.Entity;

import com.sun.javafx.binding.StringFormatter;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * Created by luxuda on 7/16/2017.
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SystemcodeValidator.class)
@Documented
public @interface SystemcodeVal {
    String isNeedPatch() default "NO";
    String lable() default "";
    String message() default  "this %s is not exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}

