
package showcurrenttime;


public class ShowCurrentTime {
    
    
    public static void main(String[] args) {
        
        long currentTime = System.currentTimeMillis();
        //Current Times
        ///*
        System.out.println(currentTime);
        long secoends = currentTime/1000;
        System.out.println(secoends);
        long minutes = secoends/60;
        System.out.println(minutes);
        long hours= minutes/60;
        System.out.println(hours);
        long days = hours/24;
        System.out.println(days);
        long months = days/30;
        System.out.println(months);
        long years = months/12;
        System.out.println(years);
        
        
        //GMT
        long totalSecoends = currentTime/1000;
        long currntSecoend = totalSecoends%60;
        long totalMinutes = totalSecoends/60;
        long currentminute = totalMinutes%60;
        
        //Obtain total hours
        long totalHours = (totalMinutes/60)+6;
        
        //Current hour
        long currentHour = totalHours%24;
        
        //Display result
        System.out.println("Current time is "+ currentHour + ":" + currentminute + ":" +currntSecoend + " GMT 6+");
        
        
        //Double example
        double i = 3.50, j =3.32;
        
        double preResult = i*j;
        int result = (int) (i*j);
        
        System.out.println(preResult);
        System.out.println(result);
        
        
    }
}
