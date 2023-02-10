import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.*;

class RouteFinder implements IRouteFinder {
  // public Map<String, Map<String, String>> getBusRoutesUrls(final char destInitial) {
  //   // scan the page 
  //   // if letter matches char,
  //   // put to map, name of city as key, and as value, the bus route #, and url 

  // }
      
  public ArrayList<String> busRoutesNew = new ArrayList<>();
  public Map<String, List<String>> busRouteUrl = new HashMap<String, List<String>>();
    
  @Override
  public Map<String, Map<String, String>> getBusRoutesUrls(char destInitial) {
    // TODO Auto-generated method stub
    // getUrlText(busRoute#)
    


    for (Map.Entry<String, List<String>> entry : destMap.entrySet()) {
      String busKey = entry.getKey().toString();
      List<String> destination = entry.getValue();

      for (int i = 0; i < destination.size(); i++) {
        String number = destination.get(i);
        String destUrl = TRANSIT_WEB_URL + "route/" + number;
        if (number.contains("/")) {
          String newNumber = destination.get(i).replace("/", "-");
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
    // System.out.println(busRouteUrl.get("Bellevue"));

    return null;
  }
  
  @Override
  public Map<String, List<Long>> getBusRouteTripsLengthsInMinutesToAndFromDestination(
      Map<String, String> destinationBusesMap) {
    // TODO Auto-generated method stub
    return null;
  }


  public static String getUrlText(String urlString) {
    String TRANSIT_WEB_URL = "https://www.communitytransit.org/busservice/schedules/";
    // URLConnection ct = new URL(TRANSIT_WEB_URL).openConnection();
    return TRANSIT_WEB_URL;
  }
}

