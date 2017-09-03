package com.example.demo_web.dto;

import com.example.demo_web.Entity.SystemcodeVal;
import lombok.Data;

/**
 * Created by luxuda on 8/1/2017.
 */
@Data
public class Abctr {
    @SystemcodeVal(lable = "rating")
    private String rating;
}
