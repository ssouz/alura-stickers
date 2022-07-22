import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// imdb
public class ContentExtractor2 implements ContentExtractor {
    
    public List<Content> extractContent(String json) {

        // extrair dados [titulo,postere e classificar]
        var parser = new JsonParser();
        List<Map<String, String>> attributList = parser.parse(json);

        List<Content> contents = new ArrayList<>();
        //popular lista conteudos
        for (Map<String, String> attribut : attributList) {
            String title = attribut.get("title");
            String urlImage = attribut.get("image");

            var content = new Content(title, urlImage);

            contents.add(content);            
        }
        return contents;
    } 
}