import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class ApiRequests {
  private static List<Map<String, String>> parsearDados (String url) throws Exception {
      URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

       JsonParser parser = new JsonParser();

        return parser.parse(body);
  }

  private static void imprimirResultados (List<Map<String, String>> listaItens){
     for (Map<String,String> item : listaItens) {
            System.out.println("Título: " + item.get("title"));
            System.out.println("Poster: " + item.get("image"));      
            System.out.println("Classificação: " + item.get("imDbRating"));      
            System.out.println("");      
        }
  }

  public static void listarItensApi(String nomeApi, String url) throws Exception{
      System.out.println("**" + nomeApi + "**");
      System.out.println(" ");
      List<Map<String, String>> listaFilmes = parsearDados(url);
      imprimirResultados(listaFilmes);
  }
}
