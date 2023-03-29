import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static final String NASA_API_KEY = PropertiesReader.getProperty("NASA_API_KEY");
    public static void main(String[] args) throws Exception {

        // String urlNasa = "https://api.nasa.gov/planetary/apod?api_key=" + NASA_API_KEY + "&start_date=2023-03-25&end_date=2023-03-29";
        // ExtratorConteudo extrator = new ExtratorConteudoNasa();
    
         String urlImdb = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
         ExtratorConteudo extrator = new ExtratorConteudoImdb();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(urlImdb);

       
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        for (Conteudo conteudo : conteudos){
              InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
          String nomeArquivo = "saida/" + conteudo.getTitulo().replaceAll("[^a-zA-Z0-9]" , "") + ".png";

          GeradorDeFigurinhas gerador = new GeradorDeFigurinhas();
          gerador.cria(inputStream, nomeArquivo); 

          System.out.println("\u001b[1mTítulo:\u001b[m " + conteudo.getTitulo());
          System.out.println("");  
        }
        

        // String urlTopFilmes = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

         // ApiRequests.listarItensApi("Top Filmes", urlTopFilmes);

        // String urlTopSeries = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";

       //  ApiRequests.listarItensApi("Top Séries", urlTopSeries);

        // String urlFilmesPopulares = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";

        // ApiRequests.listarItensApi("Filmes Mais Populares", urlFilmesPopulares);

        // String urlSeriesPopulares = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";     
        
        // ApiRequests.listarItensApi("Séries Mais Populares", urlSeriesPopulares);
    }
}
