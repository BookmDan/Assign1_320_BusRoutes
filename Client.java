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

    // does not work 
    // finder.printLine(routeUrls.get("Bellevue"));
    
    // finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(null);
  }
}
    