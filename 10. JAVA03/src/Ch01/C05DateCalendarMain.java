package Ch01;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
public class C05DateCalendarMain {

	public static void main(String[] args) {
		
Date d1 =new Date();
System.out.println(d1);
System.out.println(d1.getYear()+1900);
System.out.println(d1.getMonth());
System.out.println(d1.getDay());
System.out.println(d1.getHours());
System.out.println(d1.getMinutes());
System.out.println(d1.getSeconds());
System.out.println(d1.getTime());

//Calendar
Calendar cal = Calendar.getInstance();//Calendar같은 경우는 Singletone패턴으로 객체를 생성 할 필요 없음.
System.out.println(cal.get(Calendar.YEAR));
System.out.println(cal.get(Calendar.MONTH)+1);
System.out.println(cal.get(Calendar.DAY_OF_MONTH));
System.out.println(cal.get(Calendar.DAY_OF_WEEK));
System.out.println(cal.get(Calendar.HOUR_OF_DAY));
System.out.println(cal.get(Calendar.MINUTE));
System.out.println(cal.get(Calendar.SECOND));

//LocalDateTime
LocalDateTime now = LocalDateTime.now();
int year =now.getYear();
int month =now.getMonthValue();
int day =now.getDayOfMonth();
int hour =now.getHour();
int minute =now.getMinute();
int second =now.getSecond();
DayOfWeek dayofweek =now.getDayOfWeek();


System.out.println("연: "+ year);
System.out.println("월: "+ month);
System.out.println("일: "+ day);
System.out.println("시: "+ hour);
System.out.println("분: "+ minute);
System.out.println("초: "+ second);
System.out.println("요일: "+ dayofweek);


	}

}

