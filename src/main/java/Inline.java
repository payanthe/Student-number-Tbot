import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.ForwardMessage;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by parsarec on 3/25/2017.
 */
public class Inline {
    public static void main(String[] args) {
//        TelegramBot bot = TelegramBotAdapter.build("356476738:AAF-UZy5Y4hZaxGNn5Mnv88w8quVIAg1a9I");

        //bot2bot2bot

        TelegramBot bot = TelegramBotAdapter.build("349368002:AAFGaR07NuSKnycC8kRNDlzFbXs4_K_xnIs");
// sync



        int offset = 0;




        while (true) {
            GetUpdates getUpdates = new GetUpdates().limit(100).offset(offset).timeout(0);
//            System.out.println(getUpdates);
            GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
            List<Update> updates = updatesResponse.updates();
            updates.forEach(update -> System.out.println(update));

//            InlineQuery inlineQuery = update.inlineQuery();


            if (updates.size() > 0) {
                offset = updates.get(0).updateId() + 1;
                InlineQuery inlineQuery = updates.get(0).inlineQuery();
                 if (inlineQuery!=null) {
                    System.out.println(inlineQuery.query());
                     if (!inlineQuery.query().equals("null")){
                         System.out.println("ooooomaddd");

                         String query;
//                         query=scanner.nextLine();
                         query=inlineQuery.query();
                         String search="http://lmgtfy.com/?q=";
                         String link=search+query.replaceAll("\\s+","+");
//                         System.out.println(search+query.replaceAll("\\s+","+"));
                         System.out.println("in lineke"+link);
                         InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                                 new InlineKeyboardButton[]{
                                         new InlineKeyboardButton("GOOGLE").url(link),

                                 });
                         InlineQueryResult p1 = new InlineQueryResultPhoto(inlineQuery.id()+1, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(10).photoWidth(500).title("akse yek").caption("sadsad");
                         InlineQueryResult p2 = new InlineQueryResultPhoto(inlineQuery.id()+2, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(20).photoWidth(10);
                         InlineQueryResult p3 = new InlineQueryResultPhoto(inlineQuery.id()+3, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(30).photoWidth(50);
                         InlineQueryResult p4 = new InlineQueryResultPhoto(inlineQuery.id()+33, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(40).photoWidth(90);
//                         InlineQueryResult r1 = new InlineQueryResultPhoto(inlineQuery.id(), "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg");
                         InlineQueryResult r2 = new InlineQueryResultArticle(inlineQuery.id(), inlineQuery.query(), inlineQuery.query()).replyMarkup(inlineKeyboard).thumbWidth(40).thumbHeight(20).description("tozihaat").thumbUrl("http://www.mhwebdesigns.com/images/home1.jpg");
                         InlineQueryResult r3 = new InlineQueryResultArticle(inlineQuery.id()+1, inlineQuery.query(), inlineQuery.query()).replyMarkup(inlineKeyboard).description("tozidddhaat").thumbUrl("https://dns-check.nl/basicauth/test.jpg");
//                         InlineQueryResult r3 = new InlineQueryResultArticle(inlineQuery.id(), inlineQuery.query(), inlineQuery.query()).replyMarkup(inlineKeyboard).thumbWidth(30).thumbHeight(20).description("tozidddhaat").thumbUrl("https://dns-check.nl/basicauth/test.jpg");
//                         BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQuery.id(), r1,r3));
                         bot.execute(
                                 new AnswerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{p1,p2,p3,p4})



//                                         .nextOffset("offset")
//                                         .switchPmParameter("pmParam")
//                                         .switchPmText("pmText")
                         );
                     }
                 }
                ChosenInlineResult chosenInlineResult = updates.get(0).chosenInlineResult();
                CallbackQuery callbackQuery = updates.get(0).callbackQuery();


                updates.forEach(update -> System.out.println(update));


                if (updates.get(0).message() != null) {




                }


            }






        }
    }

}


