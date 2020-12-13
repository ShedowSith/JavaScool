import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TimeFormatter {
/*
Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 */
    public static void main(String[] args) {
        System.out.println(formatDuration(1010003662));
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) return "now";
        List<String> result = new ArrayList<>();
        int years = (int)TimeUnit.SECONDS.toDays(seconds) / 365;
        int days = (int)TimeUnit.SECONDS.toDays(seconds) - years * 365;
        int hours = (int)TimeUnit.SECONDS.toHours(seconds) - (int)TimeUnit.SECONDS.toDays(seconds)*24;
        int minutes = (int)TimeUnit.SECONDS.toMinutes(seconds) - (int)TimeUnit.SECONDS.toHours(seconds)*60;
        int sec = seconds - (int)TimeUnit.SECONDS.toMinutes(seconds) * 60;
        if(years!=0){
            result.add(years>1?years+" years":years+" year");
        }
        if(days!=0){
            result.add(days>1?days+" days":days+" day");
        }
        if(hours!=0){
            result.add(hours>1?hours+" hours":hours+" hour");
        }
        if(minutes!=0){
            result.add(minutes>1?minutes+" minutes":minutes+" minute");
        }
        if(sec!=0){
            result.add(sec>1?sec+" seconds":sec+" second");
        }
        String formatTime = "";
        for (int i=0; i<result.size(); i++){
            String r = "";
            if(i==result.size()-2) {
                r = " and ";
            }else if(i<result.size()-2){
                r = ", ";
            }
            formatTime+=result.get(i)+r;
        }
        return formatTime;
    }
}
