import java.util.Scanner;

/** This class is used to get the month , year and day seperately from user and then combine them into
 * string to use later*/

public class date {

    private int day=00,month=00,year=0000;

    Scanner ns = new Scanner(System.in);
    //setters and getters for day month and year
    public void setDay(int day)
    {
        this.day = day;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getDOB()

    {
        return year+"-"+month+"-"+day;
    }
}
