package com.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 商品 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 15:50
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Integer id;
    private String name;
    private Integer number;
}
