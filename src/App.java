public class App {
    public static void main(String[] args) throws Exception {

        String urlTopFilmes = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

         ApiRequests.listarItensApi("Top Filmes", urlTopFilmes);

        // String urlTopSeries = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";

       //  ApiRequests.listarItensApi("Top Séries", urlTopSeries);

        // String urlFilmesPopulares = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";

        // ApiRequests.listarItensApi("Filmes Mais Populares", urlFilmesPopulares);

        // String urlSeriesPopulares = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";     
        
        // ApiRequests.listarItensApi("Séries Mais Populares", urlSeriesPopulares);
    }
}
