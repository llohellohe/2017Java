package sping;

import com.yangqi.spring.CDPlayer;
import com.yangqi.spring.CDPlayerConfig;
import com.yangqi.spring.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by yangqi on 25/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired()
    private CompactDisc cd;
    @Autowired()
    private CDPlayer player;
    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
        cd.play();
    }

    @Test
    public void testPlay(){
        player.play();
    }

}
