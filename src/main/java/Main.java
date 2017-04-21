//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.TelegramBotAdapter;
//import com.pengrad.telegrambot.model.Message;
//import com.pengrad.telegrambot.model.PhotoSize;
//import com.pengrad.telegrambot.model.Update;
//import com.pengrad.telegrambot.model.request.ForceReply;
//import com.pengrad.telegrambot.model.request.ParseMode;
//import com.pengrad.telegrambot.request.GetUpdates;
//import com.pengrad.telegrambot.request.SendMessage;
//import com.pengrad.telegrambot.response.BaseResponse;
//import com.pengrad.telegrambot.response.GetUpdatesResponse;
//import com.pengrad.telegrambot.response.SendResponse;
//
//import java.util.List;
//import java.util.Queue;
//
///**
// * Created by parsarec on 3/25/2017.
// */
//public class Main {
//    public static void main(String[] args) {
//        TelegramBot bot = TelegramBotAdapter.build("356476738:AAF-UZy5Y4hZaxGNn5Mnv88w8quVIAg1a9I");
//// sync
//        int offset = 0;
//        while (true) {
//            GetUpdates getUpdates = new GetUpdates().limit(100).offset(offset).timeout(0);
////            System.out.println(getUpdates);
//            GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
//            List<Update> updates = updatesResponse.updates();
//            if (updates.size() > 0) {
//                offset = updates.get(updates.size() - 1).updateId() + 1;
//                updates.forEach(update -> System.out.println(update.message()));
//
//
//                if (updates.get(0).message().chat().id()==84777663){
//                    bot.execute(new SendMessage(199078222,updates.get(0).message().text()));
//                }
//                if (updates.get(0).message().chat().id()==199078222){
//                   bot.execute( new SendMessage(84777663,updates.get(0).message().text()));
//                }
//
//
//
//
//                if (updates.get(0).message().chat().id()==84777663){
//                    if (updates.get(0).message().voice()!=null){
//                        bot.execute(new Pmforwarding().sendVoice(updates.get(0).message().voice().fileId(),199078222));
//                    }
//                }
//
///*---------------------------Forward Sticker--------------------------------------------  */
//
//if (!updates.get(0).message().equals("null")) {
//    if (updates.get(0).message().chat().id() == 84777663) {
//        if (updates.get(0).message().sticker()!=null) {
//
//            bot.execute(new Pmforwarding().sendSticker(updates.get(0).message().sticker().fileId(), 199078222));
//        }
//    }
//
//}
//
//
///*---------------------------Forward PHoto--------------------------------------------
//                if (updates.get(0).message().chat().id()==84777663){
//                    if (!updates.get(0).message().photo().equals("null")){
//                        bot.execute(new Pmforwarding().sendPhoto(updates.get(0).message().photo()[2].fileId(),199078222));
//                    }
//                }
//
//*/
//
//
//
//
//
//
//
////                SendMessage sendMyMess = new SendMessage(updates.get(0).message().from().id(), "<b>bold</b>, <strong>bold</strong>\n" +
////                        "<i>italic</i>, <em>italic</em>\n" +
////                        "<a href=\"http://www.example.com/\">inline URL</a>\n" +
////                        "<code>inline fixed-width code</code>\n" +
////                        "<pre>pre-formatted fixed-width code block</pre>")
////                        .parseMode(ParseMode.HTML)
////                        .disableWebPagePreview(true)
////                        .disableNotification(true)
////                        .replyToMessageId(updates.get(0).message().messageId())
////                        .replyMarkup(new ForceReply());
////                if (updates.get(0).message().text().equals("/start")) {
////                    SendResponse sendResponse = bot.execute(sendMyMess);
////                    boolean ok = sendResponse.isOk();
////                    Message message = sendResponse.message();
////                }
//
//
//
//
//
//            }
//        }
//
//    }
//
//}
