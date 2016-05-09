/**
 * Created by Fornia.fu on 2015/11/25.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DateUtil
{
    private static String defaultPattern = "yyyy-MM-dd HH:mm:ss";

    /** 锁对象 */
    private static final Object lockObj = new Object();

    /** 存放不同的日期模板格式的sdf的Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap =
            new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern)
    {
        ThreadLocal<SimpleDateFormat> sdfLocal = sdfMap.get(pattern);

        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (sdfLocal == null)
        {
            synchronized (lockObj)
            {
                sdfLocal = sdfMap.get(pattern);
                if (sdfLocal == null)
                {

                    // 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    sdfLocal = new ThreadLocal<SimpleDateFormat>()
                    {

                        @Override
                        protected SimpleDateFormat initialValue()
                        {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, sdfLocal);
                }
            }
        }

        return sdfLocal.get();
    }

    public static String time2str(Date date, String pattern)
    {
        SimpleDateFormat sdf = null;
        if (!pattern.equals(""))
        {
            sdf = getSdf(pattern);
        }
        else
        {
            sdf = getSdf(defaultPattern);
        }

        return sdf.format(date);
    }

    public static Date str2Date(String yy_mm_dd_hh_mm_ss, String pattern)
            throws Exception
    {
        SimpleDateFormat sdf = null;
        if (!pattern.equals(""))
        {
            sdf = getSdf(pattern);
        }
        else
        {
            sdf = getSdf(defaultPattern);
        }
        return sdf.parse(yy_mm_dd_hh_mm_ss);
    }

    /**
     *
     * 描 叙: 根据生日获取用户年龄
     * <p>
     * 作 者: 胡吉方<br>
     * 时 间: 2015-1-14 下午6:01:55
     */
    public static int getAgeByBirthday(Date birthday)
    {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday))
        { // 年龄不能为负数
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }

        // 当前日期
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        // 生日日期
        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth)
        {
            if (monthNow == monthBirth)
            {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth)
                {
                    age--;
                }
            }
            else
            {
                // monthNow<monthBirth
                age--;
            }
        }
        return age;
    }

    public static Date subSomeMinute(Date beginDate, int minute)
    {
        SimpleDateFormat dft = getSdf(defaultPattern);
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        int subMinute = 0;

        if (minute > 0)
        {
            subMinute -= minute;
        }

        date.add(Calendar.MINUTE, subMinute);
        Date endDate = beginDate;
        try
        {
            endDate = dft.parse(dft.format(date.getTime()));
        }
        catch (ParseException e)
        {
            //
        }
        return endDate;
    }

    public static Date subSomeDay(Date beginDate, int day)
    {
        SimpleDateFormat dft = getSdf(defaultPattern);
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);

        date.set(Calendar.DATE, date.get(Calendar.DATE) - day);
        Date endDate = beginDate;
        try
        {
            endDate = dft.parse(dft.format(date.getTime()));
        }
        catch (ParseException e)
        {
            //
        }
        return endDate;
    }

    public static String format(Date date, String pattern)
    {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static void main(String[] args)
            throws Exception
    {
        System.out.println(str2Date("1977-08-02", "yyyy-MM-dd"));
    }

    public static int daysBetween(Date smdate, Date bdate)
    {
        return (int)((smdate.getTime() / 86400000L) - (bdate.getTime() / 86400000L));
    }

    public static Date str2Date(String dateStr)
            throws Exception
    {
        String[] date = dateStr.split(" ");
        dateStr = date[0];
        String regExp = "^\\d{4}(\\-|\\/)?\\d{1,2}\\1\\d{1,2}$";
        if (!Pattern.matches(regExp, dateStr) && !Pattern.matches("^\\d{8}$", dateStr)){
            throw new Exception();
        }
        String pattern = "yyyyMMdd";

        if (dateStr.split("/").length > 1)
        {
            pattern = "yyyy/MM/dd";
        }
        if (dateStr.split("-").length > 1)
        {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = getSdf(pattern);
        return sdf.parse(dateStr);
    }
}
