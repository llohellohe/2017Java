package com.yangqi.springmvc.service;

import com.yangqi.springmvc.dataobject.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yangqi on 25/01/2017.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository{
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle>list=new ArrayList<Spittle>();

        for(int i=0;i<10;i++){
            Spittle s=new Spittle("hello"+i,new Date());
            list.add(s);
        }
        return list;
    }
}
