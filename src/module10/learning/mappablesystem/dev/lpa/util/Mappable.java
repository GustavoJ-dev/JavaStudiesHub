package module10.learning.mappablesystem.dev.lpa.util;

public interface Mappable {
     void render();

     static double[] latLon(String location){
          var splits = location.split(",");
          double lat = Double.valueOf(splits[0]);
          double lon = Double.valueOf(splits[1]);
          return new double[]{lat, lon};
     }
}
