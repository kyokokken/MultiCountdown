import com.kookoon.multicountdown.Countdown;
import com.kookoon.multicountdown.Timer;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Repeatable;


public class CountdownTest {
    @Test
    public void newCountdown() {
        Countdown c = new Countdown(new Timer(0, 0, 1));
        c.start();
        try {
            Thread.sleep(1 * 1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, c.isElapsed());
    }


    public void newCountdown100times() {
        for (int i = 0; i < 100; i++) {
            newCountdown();
        }
    }
}
