import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by parsa on 4/9/2017.
 */
public class api {
    public static void main(String[] args) throws IOException {
        TelegramBot bot = TelegramBotAdapter.build("376515904:AAHrO48RSR2slvmXnncDol3xTzStBeMSmbY");
        String sURL = "https://hacker-news.firebaseio.com/v0/newstories.json"; //just a string

        // Connect to the URL using java's native library
        URL url = new URL(sURL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        try {
            request.connect();
        }catch (Exception e){
            System.out.println(e);

        }


        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        System.out.println(root.getAsJsonArray().get(0));//Convert the input stream to a json element
        JsonArray newss= root.getAsJsonArray();
        for (JsonElement je:newss
             ) {
            System.out.println(je);
            String urls = "https://hacker-news.firebaseio.com/v0/item/"+je+".json";
            System.out.println(urls);
            URL urll = new URL(urls);
            HttpURLConnection requestt = (HttpURLConnection) urll.openConnection();
            requestt.connect();
            JsonParser jp1 = new JsonParser(); //from gson
//            JsonObject root1 = jp1.parse(new InputStreamReader((InputStream) request.getContent()));
//            JsonObject rootobj1 = root1.getAsJsonObject();
            JsonElement root1 = jp1.parse(new InputStreamReader((InputStream) requestt.getContent())); //Convert the input stream to a json element
            JsonObject rootobj1 = root1.getAsJsonObject(); //May be an array, may be an object.
//            System.out.println(root1.get("title"));
        System.out.println(rootobj1.get("title").getAsString());
        System.out.println(rootobj1.get("url"));

            String urlersali="";
            String text="";
            if (rootobj1.get("url")!=null){
            urlersali = rootobj1.get("url").getAsString();}
            if (rootobj1.get("text")!=null){
                text = rootobj1.get("text").getAsString();}
            bot.execute( new SendMessage("@akhbarapi","<b>"+rootobj1.get("title").getAsString()+"</b>"+"\n"+urlersali+text).parseMode(ParseMode.HTML));

            System.out.println(text);
        }


//        JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
//        System.out.println(rootobj.get("title"));
//        System.out.println(rootobj.get("url"));
    }
}
