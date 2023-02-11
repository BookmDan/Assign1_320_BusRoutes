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
    
    // asks for destination intial input from user
    System.out.println("Enter city destination initial:");

    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    // int T= Integer.parseInt(inp.readLine()); // for taking a number as an input 
    Map<String, List<String>> routeUrls;
    try {
      
      String str = inp.readLine();
      char c = str.charAt(0);
      routeUrls = finder.getBusRoutesUrls(c);

      // asks for destination name input from user 
      System.out.println("Enter city destination:");
      
      String str2 = inp.readLine();

      // should return the calculated distances but it does not do this currently
      finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(finder.getBusRoutesUrls(c).get(str2));
    } catch (Exception e) {
      // TODO: handle exception
    }

     // Map<String, List<String>> routeUrls = finder.getBusRoutesUrls('b');
     // finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(routeUrls.get("Bellevue"));
    
    // does not work 
    // finder.printLine(routeUrls.get("Bellevue"));
    
    // finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(null);
  }
}
    