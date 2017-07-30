package com.example.demo_web.Entity;

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
    String message() default "SystemcodeVal error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

