package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author caojianyi@dxy.cn
 * @date 2020-11-03 01:09
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
     private  long id;
     private String name;
     private  int age;
}
