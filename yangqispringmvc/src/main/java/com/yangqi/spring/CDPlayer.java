package com.yangqi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yangqi on 25/01/2017.
 */
@Component
public class CDPlayer {
    private CompactDisc cd;
    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }
    public void play() {
        cd.play();
    }
}
