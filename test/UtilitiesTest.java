import com.kookoon.multicountdown.Alarm;
import com.kookoon.multicountdown.Time;
import com.kookoon.multicountdown.Utilities;
import org.junit.Assert;
import org.junit.Test;

public class UtilitiesTest {

    @Test
    public void millisToTime() {
        Time t = Utilities.fromMillisToTime(1000);
        Assert.assertEquals(1, t.seconds);
        Assert.assertEquals(0, t.minutes);
        Assert.assertEquals(0, t.hours);
        Assert.assertEquals(0, t.millis);

        t = Utilities.fromMillisToTime(1234);
        Assert.assertEquals(1, t.seconds);
        Assert.assertEquals(0, t.minutes);
        Assert.assertEquals(0, t.hours);
        Assert.assertEquals(234, t.millis);

        t = Utilities.fromMillisToTime(12345678);
        Assert.assertEquals(45, t.seconds);
        Assert.assertEquals(25, t.minutes);
        Assert.assertEquals(3, t.hours);
        Assert.assertEquals(678, t.millis);
    }

    @Test
    public void playSound() {
        Alarm alarm = new Alarm();
        alarm.playSound();
    }
}
