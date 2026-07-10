package praticas.mappablesystem.dev.lpa.util;

/**
 * Interface que define o comportamento de um objeto mapeável no sistema.
 * Qualquer objeto que possa ser desenhado em um mapa deve implementar esta interface.
 */
public interface Mappable {
     /**
      * Metodo responsável por exibir a representação visual ou textual do objeto.
      */
     void render();

     /**
      * Metodo utilitário estático para converter uma string de coordenadas em um array de doubles.
      *
      * @param location String no formato "latitude, longitude".
      * @return Um array contendo [latitude, longitude].
      */
     static double[] location(String location){
          var splits = location.split(",");
          double lat = Double.valueOf(splits[0]);
          double lon = Double.valueOf(splits[1]);
          return new double[]{lat, lon};
     }
}
