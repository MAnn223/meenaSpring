package com.nighthawk.spring_portfolio.mvc.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        // implementation not shown
        if (((year % 4 == 0) &&  (year % 100 != 0)) || (year % 400 ==0)) {
            return true;
        }
        else {
            return false;
        }
        
        }
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 

    static int days [] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static int dayOfYear(int month, int day, int year) {
        // implementation not shown
        // int lastTwoDig = year % 100; 
        // String stringNum = Integer.toString(year)
        // int[] yearDigits = new int[stringNum.length()]; 
        // for (int i = 0; i < stringNum.length(); i++) {
        //     yearDigits[i] = stringNum.charAt(i);
        // }
        // double weekDay = ((lastTwoDig + (0.25*lastTwoDig) + day + year) - 1) / 7; 
        // int finalWeekDay = (int) weekDay; 
        //int W = day + ((13*month -1)/5) + yearDigits[0:2] + (year/4) +
        // int finalWeekDay = day;
        // if (month > 2 && year % 4 == 0 &&
        //    (year % 100 != 0 || year % 400 == 0))
        // {
        //     finalWeekDay++;
        // }
     
        // // Add the days in the previous months
        // while (--month > 0)
        // {
        //     finalWeekDay= finalWeekDay + daysOfMonth[month - 1];
        // }

        if (month > 2 && year % 4 == 0 &&
           (year % 100 != 0 || year % 400 == 0))
        {
            ++day;
        }
     
        // Add the days in the previous months
        while (--month > 0)
        {
            day = day + days[month - 1];
        }
        return day;
        //return finalWeekDay;
        }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    
    public static int numberOfLeapYears(int year1, int year2) {
        int numLeapYears = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                numLeapYears ++;
            } 
        }
        return numLeapYears;
    }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */

    static int monthKeys [] = { 1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    static int leapMonthKeys [] = { 0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
    public static int dayOfWeek(int day, int month, int year) { 
        
        int lastTwoDig = year % 100;
        double weekDay = ((lastTwoDig + (0.25*lastTwoDig) + day + monthKeys[month - 1]) - 1) % 7; 
        if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
         {
            weekDay = ((lastTwoDig + (0.25*lastTwoDig) + day + leapMonthKeys[month - 1]) - 1) % 7;
         }
        int finalWeekDay = (int) weekDay; 
        // int firstDay = firstDayOfYear(year);
        // int theDate = dayOfYear(month, day, year);
        //DayOfWeek theDay = date.getDayOfWeek();
        //return theDay.getValue();

        //sunday is 1, monday is 2, etc
        return finalWeekDay;
        }

    public static int firstDayOfYear(int year) {
            return dayOfWeek(1, 1, year); 
        }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2014));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(3, 2, 2005));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(26, 12, 2004));
    }

}
