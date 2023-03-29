import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ApiRequests {

  public static void imprimirResultados (List<Map<String, String>> listaItens) throws Exception{

     for (Map<String,String> item : listaItens) {
          Integer imdbRatingRounded = Math.round(Float.parseFloat(item.get("imDbRating")));
          String titulo = item.get("title");
          String urlImagem = item.get("image");
          InputStream inputStream = new URL(urlImagem).openStream();
          String nomeArquivo = "saida/" + titulo.replaceAll("[^a-zA-Z0-9]" , "") + ".png";

          GeradorDeFigurinhas gerador = new GeradorDeFigurinhas();
          gerador.cria(inputStream, nomeArquivo);
              
            System.out.println("\u001b[1mTítulo:\u001b[m " + titulo);
            System.out.println("\u001b[1mPoster: \u001b[m" + urlImagem);      
            System.out.println("\u001b[1m \u001b[40m \u001b[32m Classificação: " + item.get("imDbRating" ) + "\u001b[m");
            for (int index = 0; index < imdbRatingRounded; index++) {
              System.out.printf("⭐");
            }
            System.out.println("");      
        }
  }
}
