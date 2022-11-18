package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private int month;
   private int day;
   private boolean isLeapYear;
   private int dayOfYear;
   private int numberOfLeapYears;
   private int year1;
   private int year2;
   private int dayOfWeek;
   private int firstDayOfYear; 

   // zero argument constructor
   public Year() {} 

   /* year getter/setters */
   public int getYear() {
      return year;
   }
   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.setFirstDayOfYear(year);
   }


   public int getDay() {
      return day;
   }
   public void setDay(int day, int month, int year) {
      this.day = day;
      this.month = month; 
      this.year = year;
      this.setDayOfYear(day, month, year);
   }

   public void setNumLeapYears(int year1, int year2) {
      this.year1 = year1;
      this.year2 = year2;
      this.setNumberOfLeapYears(year1, year2);
   }

   public void setDayWeek(int day, int month, int year) {
      this.day = day;
      this.month = month;
      this.year = year; 
      this.setDayOfWeek(day, month, year);
   }

   public void setFirstDayYear(int year) {
      this.year = year;
      this.setFirstDayOfYear(year);
   }


   // public void setMonth(int month) {
   //    this.month = month;
   //    this.setMonthOfYear(year);
   // }
   /* isLeapYear getter/setters */
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }

   public int getDayOfYear(int day, int month, int year) {
      return APCalendar.dayOfYear(day, month, year);
   }

   public int getNumberOfLeapYears(int year1, int year2) {
      return APCalendar.numberOfLeapYears(year1, year2);
   }

   public int getDayOfWeek(int day, int month, int year) {
      return APCalendar.dayOfWeek(day, month, year);
   }

   public int getFirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }

   private void setIsLeapYear(int year) {  // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   private void setDayOfYear(int day, int month, int year) {  // this is private to avoid tampering
      this.dayOfYear = APCalendar.dayOfYear(day, month, year);
   }

   private void setNumberOfLeapYears(int year1, int year2) {
      this.numberOfLeapYears = APCalendar.numberOfLeapYears(year1, year2);
   }


   private void setDayOfWeek(int day, int month, int year) {  // this is private to avoid tampering
      this.dayOfWeek = APCalendar.dayOfWeek(day, month, year);
   }

   private void setFirstDayOfYear(int year) {  // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"isLeapYear\": "  +this.isLeapYear+ " }" );
   }	

   public String getDayOfYearToString(){
      return ( "{ \"year\": "  +this.year+  ", " + "\"dayOfYear\": "  +this.dayOfYear+ " }" );
   }	

   public String getNumberOfLeapYearsToString(){
      return ( "{ \"year1\": "  +this.year1+  ", " + "\"year2\": "  +this.year2+  ", " + "\"numberOfLeapYears\": "  +this.numberOfLeapYears+ " }" );
   }	

   public String getDayOfWeekToString(){
      return ( "{ \"year\": "  +this.year+  ", "  + "\"dayOfWeek\": "  +this.dayOfWeek+ " }" );
   }	

   public String getFirstDayOfYearToString(){
      return ( "{ \"year\": "  +this.year+  ", "  + "\"firstDayOfYear\": "  +this.firstDayOfYear+ " }" );
   }

   /* standard toString placeholder until class is extended */
   public String toString() { 
      return isLeapYearToString(); 
   }

   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2022);
      System.out.println(year);
   }
}