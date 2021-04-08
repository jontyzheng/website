package boot.no.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSwitcher {

    public static Date makeStrToDate(String s) throws ParseException {
        SimpleDateFormat timer = new SimpleDateFormat("yyyy-mm-dd");
        return timer.parse(s);
    }
}
