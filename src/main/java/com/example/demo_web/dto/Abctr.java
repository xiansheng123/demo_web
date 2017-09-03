package com.example.demo_web.dto;

import com.example.demo_web.Entity.SystemcodeVal;
import lombok.Data;

@Data
public class Abctr {
    @SystemcodeVal(lable = "rating")
    private String rating;
}
