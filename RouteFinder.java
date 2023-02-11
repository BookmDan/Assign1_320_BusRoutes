import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class RouteFinder implements IRouteFinder {
//   //Map<String, List<String>>
//   // each routeTime calculated in an arraylist
//   public static ArrayList<Long> eachRouteTime = new ArrayList<>();
// // timeMap for times 
//   public Map<String, List<String>> timeMap = new HashMap<String, List<String>>();


  public static String getUrlText(String urlString) {
    // String TRANSIT_WEB_URL = "https://www.communitytransit.org/busservice/schedules/";
    // // URLConnection ct = new URL(TRANSIT_WEB_URL).openConnection();
    String text = "";
    try {
      String TRANSIT_WEB_URL = "https://www.communitytransit.org/busservice/schedules/";
      URLConnection ct = new URL(TRANSIT_WEB_URL).openConnection();
  
      ct.setRequestProperty("user-Agent",
          "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
  
      BufferedReader in = new BufferedReader(new InputStreamReader(ct.getInputStream()));
  
      String inputLine = "";
      
      while ((inputLine = in.readLine()) != null) {
        text += inputLine + "\n";
      }
    
      // System.out.println(text);
      in.close();
    } catch (Exception e) {
      // TODO: handle exception
    }
    return text;
    // returns the text of the url 
  }

  @Override
  public Map<String, List<String>> getBusRoutesUrls(char destInitial) {
    // TODO Auto-generated method stub
    // getUrlText(busRoute#)
    
    String text = getUrlText(TRANSIT_WEB_URL);
    
  
    Pattern routes = Pattern.compile("<a href=\"/schedules/route/(.*?)\"(.*?)>(.*?)</a>");

    Matcher matcher = routes.matcher(text);

    ArrayList<String> destRoutes = new ArrayList<>();

    while (matcher.find()) {
      destRoutes.add(matcher.group(3));
    }

    Map<String, List<String>> destMap = new HashMap<String, List<String>>();

    List<String> ar = destRoutes.subList(0, 5);
    destMap.put("Arlington", ar);

    List<String> be = destRoutes.subList(5, 6);
    destMap.put("Bellevue", be);

    List<String> bo = destRoutes.subList(6, 13);
    destMap.put("Bothell", bo);
    // System.out.println(destMap);
    List<String> br = destRoutes.subList(12, 13);
    destMap.put("Brier", br);
    List<String> da = destRoutes.subList(13, 14);
    destMap.put("Darrington", da);
    List<String> ed = destRoutes.subList(14, 24);
    destMap.put("Edmonds", ed);

    List<String> ev = destRoutes.subList(24, 41);
    destMap.put("Everett", ev);

    List<String> evb = destRoutes.subList(41, 48);
    destMap.put("Everett (Boeing)", evb);

    List<String> go = destRoutes.subList(48, 49);
    destMap.put("Gold Bar", go);
    List<String> gr = destRoutes.subList(49, 50);
    destMap.put("Granite Falls", gr);
    List<String> la = destRoutes.subList(50, 54);
    destMap.put("Lake Stevens", la);
    List<String> ly = destRoutes.subList(54, 77);
    destMap.put("Lynnwood", ly);

    List<String> ma = destRoutes.subList(77, 85);
    destMap.put("Marysville", ma);
    List<String> may = destRoutes.subList(85, 87);
    destMap.put("Mays Pond", may);
    List<String> mi = destRoutes.subList(87, 97);
    destMap.put("Mill Creek", mi);
    List<String> mon = destRoutes.subList(97, 99);
    destMap.put("Monroe", mon);
    List<String> mou = destRoutes.subList(99, 111);
    destMap.put("Mountlake Terrace", mou);

    List<String> mu = destRoutes.subList(111, 114);
    destMap.put("Mukilteo", mu);
    List<String> no = destRoutes.subList(114, 121);
    destMap.put("Northgate (light rail connection)", no);

    List<String> se = destRoutes.subList(121, 135);
    destMap.put("Seattle (Downtown)", se);
    List<String> sh = destRoutes.subList(135, 140);
    destMap.put("Shoreline", sh);

    List<String> Si = destRoutes.subList(140, 143);
    destMap.put("Silver Firs", Si);
    List<String> Sn = destRoutes.subList(143, 146);
    destMap.put("Snohomish", Sn);
    List<String> St = destRoutes.subList(146, 149);
    destMap.put("Standwood", St);
    List<String> Su = destRoutes.subList(149, 150);
    destMap.put("Sultan", Su);
    List<String> Tu = destRoutes.subList(150, 152);
    destMap.put("Tulalip/Quil Ceda", Tu);

    //getting entries by first name 
    // char destInput = 'b';

    for (Map.Entry<String, List<String>> entry : destMap.entrySet()) {
      String dest = entry.getKey();
      List<String> busRoutes = entry.getValue();

      // System.out.println(dest.charAt(0));
      // System.out.println("Destination: " + dest);
      // System.out.println("Bus Number: " + busRoutes);

      if (Character.toLowerCase(dest.charAt(0)) == Character.toLowerCase(destInitial)) {
        System.out.println("Destination: " + dest);
        System.out.println("Bus Number: " + busRoutes);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
      }
      // else System.err.println("try again");
    }

    // get key value entries to destination and value for trip lengths 
    // Map<String, List<String>> tripLengths = new HashMap<String, List<String>>();

    //key: cityDest, map: busRoute #, url
    // for each sublist, add url and add to this new map
    // <Brier, <111, url/route/111>>

    List<String> busRoutesNew = new ArrayList<>();
    Map<String, List<String>> busRouteUrl = new HashMap<String, List<String>>();

    for (Map.Entry<String, List<String>> entry : destMap.entrySet()) {
      String busKey = entry.getKey().toString();
      List<String> destination = entry.getValue();

      for (int i = 0; i < destination.size(); i++) {
        String number = destination.get(i);
        String destUrl = TRANSIT_WEB_URL + "route/" + number;
        if (number.contains("/")) {
          String newNumber = destination.get(i).replace("/", "-"); //  matcher.group(2);
          String destUrl2 = TRANSIT_WEB_URL + "route/" + newNumber;
          busRoutesNew.add(number);
          busRoutesNew.add(destUrl2);
          busRouteUrl.put(busKey, busRoutesNew);
        } else {
          busRoutesNew.add(destination.get(i));
          busRoutesNew.add(destUrl);
          busRouteUrl.put(busKey, busRoutesNew);
        }
      }
    }
    return busRouteUrl;
  }
    // System.out.println(busRouteUrl.get("Bellevue"));
  // System.out.println(busRouteUrl.get("Bellevue"));

  @Override
  public Map<String, List<String>> getBusRouteTripsLengthsInMinutesToAndFromDestination(final List<String> routeUrls) {
    // TODO Auto-generated method stub
    //second set of pattern match 

    // String urlString = "https://www.communitytransit.org/busservice/schedules/route/532-535";
    // // String urlString = TRANSIT_WEB_URL + "route/532-535";
    // // String urlString = TRANSIT_WEB_URL + getBusRoutesUrls('b').get("Bellevue");
    // // getBusRoutesUrls.busRouteUrl.get("Bellevue");
    // // get new Url with helper
    // String text = getUrlText(urlString);

    // System.out.println(text);
    // // String text2 = text + getBusRoutesUrls(0).busRoutesNew

    String text2 = "";
    Map<String, List<String>> timeMap = new HashMap<String, List<String>>();

    // for each() routeurl
    for (String string : routeUrls) {
      try {

        String busROUTEURL = string;
        URLConnection bus = new URL(busROUTEURL).openConnection();

        bus.setRequestProperty("user-Agent",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        BufferedReader in2 = new BufferedReader(new InputStreamReader(bus.getInputStream()));

        String inputLine2 = "";
        while ((inputLine2 = in2.readLine()) != null) {
          text2 += inputLine2 + "\n";

        }
        // System.out.println(text2);
        in2.close();
      } catch (Exception e) {
        // TODO: handle exception
      }

      /**********  this method is not working    *********** */

      // pattern match to extract just 'weekdays'

      Pattern justGetWeekDay = Pattern.compile("<div id=\"Weekday532-535nb\" style class = \"RouteChart\">(.*?)</div>");

      Matcher weekDayMatcher = justGetWeekDay.matcher(text2);

      ArrayList<String> weekDayDiv = new ArrayList<>();

      while (weekDayMatcher.find()) {
        weekDayDiv.add(weekDayMatcher.group(0));
      }
      // System.out.println(weekDayDiv);

      // ArrayList<String> times = new ArrayList<>();

      // pattern match to extract just 'times'
      for (String timesText : weekDayDiv) {
        Pattern timesPattern = Pattern.compile("(<td(.*?)>(.*?)(<a h.*?>)*(.*?)(</a>)*</td>)*", Pattern.DOTALL);
        Matcher timeMatcher = timesPattern.matcher(timesText);
        // System.out.println("err");
        // times.add(0, "Hello");

        while (timeMatcher.find()) {
          // System.out.println("err");

          // set time to date format
          SimpleDateFormat format = new SimpleDateFormat("h:mm a");
          Date t1;
          try {
            t1 = (Date) format.parse(timeMatcher.group(1));
            Date t2 = (Date) format.parse(timeMatcher.group(13));

            long diff = t2.getTime() - t1.getTime();
            long diffMinutes = diff / (60 * 1000);
  
            System.out.println("Time in minutes: " + diffMinutes + " minutes.");
            eachRouteTime.add(diffMinutes);

          } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    }
    return timeMap;
  }

  public static String printLine(Map<String, List<String>> destMap) {
    BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
    // int T= Integer.parseInt(inp.readLine()); // for taking a number as an input 
   
    try {
      String str = inp.readLine(); // for taking a string as an input

      for (int i = 0; i < destMap.size(); i++) {
        if (str.equals(destMap.get(i))) {
          System.out.println("Bus Trips Lengths in Minutes are: ");
          System.out.println(destMap.get(i));
          System.out.println("- Bellevue Transit Center=");
        
        }
      }
    } catch (Exception e) {
      // TODO: handle exception
    }
    System.out.println(eachRouteTime);
    return null;
  }
}

