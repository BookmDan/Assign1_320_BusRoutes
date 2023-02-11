import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Client { // implements IRouteFinder
  public static void main(String[] args) throws IOException {
    RouteFinder finder = new RouteFinder();
    Map<String, List<String>>  routeUrls = finder.getBusRoutesUrls('b');
    
    finder.getBusRouteTripsLengthsInMinutesToAndFromDestination(routeUrls.get("Bellevue"));

    // currently returns all, can't seem to just pull one city destination. 
    /* if you comment below, the code runs. I have not yet tested the bus trip lenghts 
    in minutes portion of this assignment */


    /* *************************** DOES NOT WORK BELOW THIS LINE ***************** */
    // get minutes destination 
    // Map<String, List<Long>>
    // 
    

    // String busROUTEURL = "https://www.communitytransit.org/busservice/schedules/route/880";
    // URLConnection bus = new URL(busROUTEURL).openConnection();

    // bus.setRequestProperty("user-Agent",
    //     "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

    // BufferedReader in2 = new BufferedReader(new InputStreamReader(bus.getInputStream()));

    // String inputLine2 = "";

    // String text2 = "";
    // while ((inputLine2 = in2.readLine()) != null) {
    //   text2 += inputLine2 + "\n";

    // }
    // // System.out.println(text2);
    // in2.close();

    // Pattern timeStart = Pattern.compile(
    //     "<td.*?>(.*?)</td>\\s<td.*?>(.*?)</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>");
    
    // // Pattern timeStop = Pattern.compile("<td.*?>(.*?)</td>\\s<td.*?>(.*?)</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>\\s<td.*?>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>");


    // Matcher travelTimeStart = timeStart.matcher(text2);


    // Matcher travelTimeStop = timeStart.matcher(text2);
    
    // // List<String> destRoutes = new LinkedList<>();

    // ArrayList<Long> eachRouteTime = new ArrayList<>();

    // // System.out.println("done");
    // SimpleDateFormat format = new SimpleDateFormat("h:mm a");
    // while (travelTimeStart.find()) {
    //   // System.out.println(travelTimeStart.group(1));

    //   Date t1 = format.parse(travelTimeStart.group(1));
    //   Date t2 = format.parse(travelTimeStart.group(13));
    //   // System.out.println("done");
    //   // System.out.println(travelTimeStart.group(13));

    //   Date t3 = format.parse(travelTimeStart);
    //   Date t4 = format.parse(travelTimeStop);

    //   long diff = t2.getTime() - t1.getTime();
    //   long diffMinutes = diff / (60 * 1000);         
                       
    //   System.out.println("Time in minutes: " + diffMinutes + " minutes.");         

    //   eachRouteTime.add(diffMinutes);
    // }

    // BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
    // // int T= Integer.parseInt(inp.readLine()); // for taking a number as an input 
    // String str = inp.readLine(); // for taking a string as an input

    // for (int i = 0; i < destMap.size(); i++) {
    //   if (str.equals(destMap.get(i))) {
    //     System.out.println("Bus Trips Lengths in Minutes are: ");
    //     System.out.println(destMap.get(i));
    //     System.out.println("- Bellevue Transit Center=");
    //     System.out.println(eachRouteTime);
    //   }
    // }
  }
}
    