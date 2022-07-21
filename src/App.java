import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // conexao http e buscar lista do api
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereço = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        

        // extrair dados [titulo,postere e classificar]
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir os dados
        StickerMaker maker = new StickerMaker();
        for (Map<String,String> filme : listaDeFilmes) {
           

            String urlImage = filme.get("image");
            String title = filme.get("title");
            InputStream inputStream = new URL(urlImage).openStream();

            String fileName = title +".png";

            maker.cria(inputStream, fileName);

            System.out.println(title);
            System.out.println();
        }


    }
}
