package com.example.shardingjdbc;

import com.example.shardingjdbc.dao.mapper.GoodsMapper;
import com.example.shardingjdbc.dao.model.Goods;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class ShardingTest extends ShardingjdbcApplicationTests {

    @Autowired
    private GoodsMapper mapper;

    @Test
    public void add() {
        //不支持批量插入
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            mapper.insert(goods);
        }
    }


    @Test
    public void search() {
        PageHelper.startPage(1, 10,"goods_type");
        Example example = new Example(Goods.class);
        example.createCriteria()
                .andLessThan("goodsType", 20);
        List<Goods> list = mapper.selectByExample(example);
        System.err.println(list);
    }
}
