package com.yangqi.springmvc.service;

import com.yangqi.springmvc.dataobject.Spittle;

import java.util.List;

/**
 * Created by yangqi on 25/01/2017.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
