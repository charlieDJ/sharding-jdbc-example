package com.example.shardingjdbc.dao.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "goods")
public class Goods {

    private Long id;

    private String goodsName;

    private Long goodsType;
}
