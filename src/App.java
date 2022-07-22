import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        // conexao http e buscar lista do api

        //PopularTv
        String url = "https://api.mocki.io/v2/549a5d8b/MostPopularTVs";
        ContentExtractor extractor = new ContentExtractor2(); 

        //nasa
        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        //ContentExtractor extractor = new ContentExtractor1(); 

        var http = new ClientHttp();
        String json = http.SearchData(url);


      

        // exibir os dados
        List<Content> contents = extractor.extractContent(json);


        StickerMaker maker = new StickerMaker();
        for (int i = 0; i < 3; i++) {

            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "saida/" + content.getTitle() + ".png";

            maker.cria(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }

    }
}
