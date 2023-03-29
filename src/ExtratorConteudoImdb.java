import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoImdb implements ExtratorConteudo{
  public List<Conteudo> extraiConteudo (String json){
        JsonParser parser = new JsonParser();

         List<Map<String, String>> listaDeAtributos =  parser.parse(json);

         List<Conteudo> conteudos = new ArrayList<>();

         for (Map<String, String> atributos: listaDeAtributos){
          String titulo = atributos.get("title");
          String urlImagem = atributos.get("image");

          Conteudo conteudo = new Conteudo(titulo, urlImagem);
          
          conteudos.add(conteudo);
         }
         
        return conteudos;
  }
}
