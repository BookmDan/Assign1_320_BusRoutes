import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client { // implements IRouteFinder
  public static void main(String[] args) throws IOException {
    RouteFinder finder = new RouteFinder();
    Map<String, List<String>> routeUrls = finder.getBusRoutesUrls('b');
    
    finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(routeUrls.get("Bellevue"));

    finder.printLine(timeMap);
    
    // finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(null);

    // currently returns all, can't seem to just pull one city destination. 
    /* if you comment below, the code runs. I have not yet tested the bus trip lenghts 
    in minutes portion of this assignment */


    /* *************************** DOES NOT WORK BELOW THIS LINE ***************** */
    // get minutes destination 
    // Map<String, List<Long>>
    // 
    

    // System.out.println(times);
    // pattern match given section 
    // not sure how to store in this in a String




    // Pattern timeStart = Pattern.compile(
    //     "<td.*?>(.*?)</td>\\s<td.*?>(.*?)</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>");
    
    // // Pattern timeStop = Pattern.compile("<td.*?>(.*?)</td>\\s<td.*?>(.*?)</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>");


    // Matcher travelTimeStart = timeStart.matcher(text2);


    // Matcher travelTimeStop = timeStart.matcher(text2);
    
    // // List<String> destRoutes = new LinkedList<>();

  }
}
    