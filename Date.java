// jan 1 1800 to dec 31 2500
public class Date{
    
private int days = 0;
private int leapYears = 0; 

// constructor(check in range) 
public Date(String date){
// check formating
    
 int month = Integer.parseInt(date.substring(0, 2));
 int day = Integer.parseInt(date.substring(3, 5));
 int year = Integer.parseInt(date.substring(6));
 
 // check range 
 if(year - 1800 < 0 || 2500 - year < 0){
     System.out.println("year out of range");
     return; 
 }
 // send year to leapyear method and convert to days
 int dYears = 0;
 for(int a = year - 1; a > 1799; a--){
    dYears+= leapyear(a);
   // keep track of leap years 
    if(leapyear(a)==366){
        leapYears++;
    }
 }
 
 // convert month to days 
 int dMonths = monthToDays(month, leapyear(year));
 
 // add it all together, minus jan 01 1800
 days = dYears + dMonths + day; 
             
}

private int leapyear(int year){
 int ydays = 365;
 
 if(year%4 == 0){
   if(year%100!=0 || year%400 == 0){
      ydays =366;  
    }
 }
   
 return ydays; 
}

private int monthToDays(int month,int year){
    int mdays = 0;
    int leap = 0; 
    
    if(year%365 == 0){
        leap = 28;
    }
    else leap = 29; 
    
    int[] months = {0,31,leap,31,30,31,30,31,31,30,31,30}; 
    
      for(int a = 0; a < month; a++){
        mdays += months[a];  
      } 
    
    return mdays;
}
    
//subtract two dates 
public int subtract(Date early){
   return days - early.days; 
} 

//increment a date by a number of days 
public void increment(int dayz){
   days += dayz; 
   
} 
//compare two dates (equals and compareTo)

public boolean equals(Date eq){
  return days - eq.days == 0;   
}

public int compareTo(Date comp){
    return days - comp.days; 
}

@Override
public String toString(){
    
 int thisMonth = 0; 
 int monthDays = 0;  
 int yearz = 1800;
 int leap = 0; 
 
while(yearz < 2501){
    
 if(leapyear(yearz)== 365){
      leap = 28;
  }
  else leap = 29; 
 
 int[] daysInMonth = {31,leap,31,30,31,30,31,31,30,31,30,31}; 
 
  int yearCount = 0;  
for(int a = 0; a <12; a++){
    monthDays = daysInMonth[a]; 
    if(days > monthDays ){
        days-=monthDays; 
        yearCount++;
    }
    else{
        thisMonth = a + 1; 
        break;
    }     
}

if(yearCount == 12){
        yearz++; 
    }
else break; 
}

String monthFormat = String.format("%02d", thisMonth);
String dayFormat = String.format("%02d", days);
   return monthFormat+"/"+dayFormat+"/"+yearz ;



        }
}
