package com.learn.api.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author liangchao
 * @create 2021-05-05 13:51
 */

@Data  // 自动填补各个参数的set/get方法
@NoArgsConstructor // 自动填补无参构造器
@Accessors(chain = true) // set参数时可以连续 实例.set().set()
public class Dept implements Serializable {
    private Long deptNo;
    private String dbName;
    private String dbSource;

    public Dept(String dbName){
        this.dbName = dbName;
    }


}
