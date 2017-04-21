//import com.google.common.base.Stopwatch;
//import com.google.common.collect.BiMap;
//import com.google.common.collect.HashBiMap;
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.TelegramBotAdapter;
//import com.pengrad.telegrambot.model.Update;
//import com.pengrad.telegrambot.request.ForwardMessage;
//import com.pengrad.telegrambot.request.GetUpdates;
//import com.pengrad.telegrambot.request.SendMessage;
//import com.pengrad.telegrambot.response.GetUpdatesResponse;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Scanner;
//
//import static java.util.concurrent.TimeUnit.MILLISECONDS;
//
///**
// * Created by parsarec on 3/25/2017.
// */
//public class Bot {
//    public static void main(String[] args) {
////        TelegramBot bot = TelegramBotAdapter.build("356476738:AAF-UZy5Y4hZaxGNn5Mnv88w8quVIAg1a9I");
//
//        //bot2bot2bot
//
//        TelegramBot bot = TelegramBotAdapter.build("339126622:AAGncGWQA8LJW4-V0YXrgnuSQD2rK7sNbSE");
//// sync
//
//        ArrayList<Long> arraychat = new ArrayList<>();
//        BiMap<Long, Long> biMap = HashBiMap.create();
//        Scanner scanner = new Scanner(System.in);
//        int offset = 0;
//        Pmforwarding pf = new Pmforwarding();
//
//        Stopwatch stopwatch = null;
//
//        while (true) {
//            GetUpdates getUpdates = new GetUpdates().limit(100).offset(offset).timeout(0);
////            System.out.println(getUpdates);
//            GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
//            List<Update> updates = updatesResponse.updates();
//            if (updates.size() > 0) {
//                offset = updates.get(0).updateId() + 1;
//                updates.forEach(update -> System.out.println(update.message()));
//                Long id = updates.get(0).message().chat().id();
//
//                if (updates.get(0).message() != null) {
//                     stopwatch= Stopwatch.createStarted();
//
////                    System.out.println(updates.get(0).message().from().id() + "   " + updates.get(0).message().chat().id());
//                    System.out.println(updates.get(0).message().text());
////                    System.out.println(!Objects.equals(updates.get(0).message().text(), null)+"in bara pm hast faghat");
//                    if (!Objects.equals(updates.get(0).message().text(), null)) {
////                        System.out.println("faghat pm haa");
//
////                        if (updates.get(0).message().sticker() != null) {
////                            System.out.println("Stickeram oomad inja ridi");
////                        }
//
//
//                        if (Objects.equals(updates.get(0).message().text(), "/start")) {
//                            bot.execute(new SendMessage(updates.get(0).message().chat().id(),
//                                    "سلام،\n" +
//                                    "خوشحالیم که اینجا می بینمیت \uD83D\uDE0A\n" +
//                                    "\n" +
//                                    "این ربات بهت کمک می کنه که با افراد تازه آشنا بشی و باهاشون چت کنی.\n" +
//                                    "\n" +
//                                    "استفاده از ربات خیلی آسونه و فقط ۲تا دستور اصلی داره!\n" +
//                                    "\n" +
//                                    "✅ برای شروع چت با یه نفر کافیه از دستور /chat استفاده کنی؛\n" +
//                                    "❌ هر وقت هم خواستی از چت بیای بیرون دستور /end رو بزن.\n" +
//                                    "\n" +
//                                    "اینجا هیچکس نمی فهمه شما کی هستین و اسمتون چیه، اما لازمه که ادب رو رعایت کنین. هر موقع کسی برای شما مزاحتمی ایجاد کرد با استفاده از دستور /report اون رو گزارش کنین. ما بررسی می کنیم اگه تعداد ریپورت های طرف بالا باشه اون رو برای همیشه از ربات بلاک می کنیم :)\n" +
//                                    "\n" +
//                                    "با معرفی  به دوستانت به ما کمک بزرگی می کنی \uD83D\uDE09\n" +
//                                    "\n" +
//                                    "\uD83D\uDCE9 اگه خواستی پیامی به ما بفرستی  /feedback رو بزن.\n" +
//                                    "\n" +
//                                    "امیدواریم که از این ربات درست استفاده بشه! \uD83C\uDF3A"));
//                        } else if (Objects.equals(updates.get(0).message().text(), "/chat")) {
//                            if (!arraychat.contains(updates.get(0).message().chat().id())) {
//
//                                boolean hasPartner = false;
//
//                                if (biMap.get(id) != null) {
////                                System.out.println(b + "partner= " + biMap.get(b));
//                                    hasPartner = true;
//                                } else if (biMap.inverse().get(id) != null) {
////                                System.out.println(b + "partner= " + biMap.inverse().get(b));
//                                    hasPartner = true;
//                                }
//                                if (!hasPartner) {
//                                    arraychat.add(updates.get(0).message().chat().id());
//
//                                    bot.execute(new SendMessage(updates.get(0).message().chat().id(), "صبر کن تا یه نفر برای چت پیدا بشه، اگه نخواستی بزن:\n" +
//                                            "❌ /cancel"));
//
//                                }
//                                if (hasPartner) {
//                                    bot.execute(new SendMessage(updates.get(0).message().chat().id(), "chete haari mage?"));
//                                }
//                            } else {
//                                bot.execute(new SendMessage(updates.get(0).message().chat().id(), "صبر کن تا یه نفر برای چت پیدا بشه، اگه نخواستی بزن:\n" +
//                                        "❌ /cancel"));
//                            }
//
//                        } else if (Objects.equals(updates.get(0).message().text(), "/cancel")) {
//
//                            if (arraychat.size() != 0) {
//
//                                if (arraychat.contains(updates.get(0).message().chat().id())) {
//
//                                    for (int i = 0; i < arraychat.size(); i++) {
////                                        System.out.println("oomad too cancel");
//                                        Long element = arraychat.get(i);
////                                        System.out.println(element.equals(updates.get(0).message().chat().id()));
//                                        if (element.equals(updates.get(0).message().chat().id())) {
////                                            System.out.println("oomad too ife delete");
//                                            arraychat.remove(i);
//                                            bot.execute(new SendMessage(updates.get(0).message().chat().id(), "شما خارج شدید"));
//                                        }
//
//                                    }
//                                } else {
//                                    bot.execute(new SendMessage(updates.get(0).message().chat().id(), "برای شروع چت با یه نفر بزن:\n" +
//                                            "✅ /chat\n" +
//                                            "\n" +
//                                            "برای خوندنِ راهنما:\n" +
//                                            "\uD83D\uDCC3 /help\n" +
//                                            "\n" +
//                                            "برای ارسال پیام به تیم سازنده:\n" +
//                                            "\uD83D\uDCE9 /feedback"));
//
//                                }
//
//                            }
//                        } else if (Objects.equals(updates.get(0).message().text(), "/end")) {
////                            Long id=updates.get(0).message().chat().id();
//                            if (biMap.inverse().get(id) != null) {
////                                System.out.println(id + "partner= " + biMap.inverse().get(id)+"paak shod");
//                                bot.execute(new SendMessage(biMap.inverse().get(id), "مـهـرچـت:\n" +
//                                        "طرف مقابل از چت خارج شد.\n" +
//                                        "برای شروع چت با یه نفر بزن:\n" +
//                                        "✅ /chat"));
//                                biMap.inverse().forcePut(id, null);
//                                biMap.inverse().forcePut(null, null);
//                                bot.execute(new SendMessage(updates.get(0).message().chat().id(), "از این چت خارج شدی.\n" +
//                                        "برای شروع چت با یه نفر بزن:\n" +
//                                        "✅ /chat"));
//
//
//                            } else if (biMap.get(id) != null) {
//                                bot.execute(new SendMessage(biMap.get(id), "مـهـرچـت:\n" +
//                                        "طرف مقابل از چت خارج شد.\n" +
//                                        "برای شروع چت با یه نفر بزن:\n" +
//                                        "✅ /chat"));
////                                System.out.println(b + "partner= " + biMap.get(b)+"paak shod");
//                                biMap.forcePut(id, null);
//                                biMap.forcePut(null, null);
//                                bot.execute(new SendMessage(updates.get(0).message().chat().id(), "از این چت خارج شدی.\n" +
//                                        "برای شروع چت با یه نفر بزن:\n" +
//                                        "✅ /chat"));
//                            } else {
////                                System.out.println("too saf nabood");
//                                bot.execute(new SendMessage(updates.get(0).message().chat().id(), "برای شروع چت با یه نفر بزن:\n" +
//                                        "✅ /chat\n" +
//                                        "\n" +
//                                        "برای خوندنِ راهنما:\n" +
//                                        "\uD83D\uDCC3 /help\n" +
//                                        "\n" +
//                                        "برای ارسال پیام به تیم سازنده:\n" +
//                                        "\uD83D\uDCE9 /feedback"));
//
//                            }
//
//
//                        } else {
//                            long partner = -1;
//                            if (biMap.get(id) != null) {
////                                System.out.println(b + "partner= " + biMap.get(b));
//                                partner = biMap.get(id);
//                            } else if (biMap.inverse().get(id) != null) {
////                                System.out.println(b + "partner= " + biMap.inverse().get(b));
//                                partner = biMap.inverse().get(id);
//                            } else {
//                                boolean findInarraychat = false;
//                                for (int i = 0; i < arraychat.size(); i++) {
//
//                                    Long element = arraychat.get(i);
//                                    if (element.equals(id)) {
////                                        arraychat.remove(i);
//                                        findInarraychat = true;
//                                        bot.execute(new SendMessage(updates.get(0).message().chat().id(), "صبر کن تا یه نفر برای چت پیدا بشه، اگه نخواستی بزن:\n" +
//                                                "❌ /cancel"));
//
//                                    }
//                                }
//                                if (!findInarraychat) {
//
//                                    bot.execute(new SendMessage(updates.get(0).message().chat().id(), "برای شروع چت با یه نفر بزن:\n" +
//                                            "✅ /chat\n" +
//                                            "\n" +
//                                            "برای خوندنِ راهنما:\n" +
//                                            "\uD83D\uDCC3 /help\n" +
//                                            "\n" +
//                                            "برای ارسال پیام به تیم سازنده:\n" +
//                                            "\uD83D\uDCE9 /feedback"));
//
//                                }
//
//
////                                System.out.println("not found");
//                            }
//
//
//                            if (partner > 0) {
//                                bot.execute(new SendMessage(partner, updates.get(0).message().text()));
//                                bot.execute(new ForwardMessage("@testjavachannel",updates.get(0).message().chat().id(),updates.get(0).message().messageId()));
//
//                            }
//
//
//                        }
//
//
//                    }
////                    System.out.println("gheyre pm" + updates.get(0).message().text() == "null");
//                    if (Objects.equals(updates.get(0).message().text(), null)) {
//                        System.out.println("raft too gheyre pm");
//
//                        long partner = -1;
//                        if (biMap.get(id) != null) {
////                                System.out.println(b + "partner= " + biMap.get(b));
//                            partner = biMap.get(id);
//                        } else if (biMap.inverse().get(id) != null) {
////                                System.out.println(b + "partner= " + biMap.inverse().get(b));
//                            partner = biMap.inverse().get(id);
//                        } else {
//                            System.out.println();
//                            boolean findInarraychat = false;
//
//                            if (arraychat.contains(updates.get(0).message().chat().id())) {
//                                findInarraychat = true;
//                                bot.execute(new SendMessage(updates.get(0).message().chat().id(), "صبر کن تا یه نفر برای چت پیدا بشه، اگه نخواستی بزن:\n" +
//                                        "❌ /cancel"));
//                            }
////                            for (int i = 0; i < arraychat.size(); i++) {
////
////                                Long element = arraychat.get(i);
////                                if (element.equals(id)) {
//////                                        arraychat.remove(i);
////                                    findInarraychat = true;
////                                    bot.execute(new SendMessage(updates.get(0).message().chat().id(), "صبر کن تا یه نفر برای چت پیدا بشه، اگه نخواستی بزن:\n" +
////                                            "❌ /cancel"));
////                                    System.out.println();
////                                }
////                            }
//                            if (!findInarraychat) {
//
//                                bot.execute(new SendMessage(updates.get(0).message().chat().id(), "برای شروع چت با یه نفر بزن:\n" +
//                                        "✅ /chat\n" +
//                                        "\n" +
//                                        "برای خوندنِ راهنما:\n" +
//                                        "\uD83D\uDCC3 /help\n" +
//                                        "\n" +
//                                        "برای ارسال پیام به تیم سازنده:\n" +
//                                        "\uD83D\uDCE9 /feedback"));
//
//                            }
//
//
//                        }
//
//                            ////////////////////////////////////////////////////////////////////
//
//                            if (partner > 0) {
//                                System.out.println("ta balash ooamd");
//                                if (!Objects.equals(updates.get(0).message().sticker(), null)) {
//                                    System.out.println("oomad too if sticker");
//                                    bot.execute(pf.sendSticker(updates.get(0).message().sticker().fileId(), partner));
//                                }
//
//
//                                if (!Objects.equals(updates.get(0).message().photo(), null)) {
//                                    bot.execute(pf.sendPhoto(updates.get(0).message().photo()[2].fileId(), partner));
//                                    bot.execute(new ForwardMessage("@testjavachannel",updates.get(0).message().chat().id(),updates.get(0).message().messageId()));
//                                }
//
//                                if (!Objects.equals(updates.get(0).message().voice(), null)) {
//                                    bot.execute(pf.sendVoice(updates.get(0).message().voice().fileId(), partner));
//                                    bot.execute(new ForwardMessage("@testjavachannel",updates.get(0).message().chat().id(),updates.get(0).message().messageId()));
//                                }
//                                if (!Objects.equals(updates.get(0).message().audio(), null)) {
//                                    bot.execute(pf.sendAudio(updates.get(0).message().audio().fileId(), partner));
//                                    bot.execute(new ForwardMessage("@testjavachannel",updates.get(0).message().chat().id(),updates.get(0).message().messageId()));
//                                }
//
//
//
////                                if (updates.get(0).message().chat().id()==84777663){
////                    if (updates.get(0).message().voice()!=null){
////                        bot.execute(new Pmforwarding().sendVoice(updates.get(0).message().voice().fileId(),199078222));
////                    }
////                }
//
//
//                            }
//
//
////                                System.out.println("not found");
//                        }
//
//                    System.out.println("Time elapsed for myCall() is " + stopwatch.elapsed(MILLISECONDS));
//                    }
//
//
//                }
//
//
//                if (arraychat.size() > 1) {
//                    biMap.put(arraychat.get(0), arraychat.get(1));
//
//                    bot.execute(new SendMessage(arraychat.get(0), "\uD83C\uDFAD  یه نفر برای چت پیدا شد، میتونی صحبت کنی.\n" +
//                            "❌ برای خروج از چت: /end\n" +
//                            "⚠️ توجه کنید که ادعای هرکس مبنی بر مدیریت این ربات، هک کردن شما، افشای اطلاعات شما و ... صرفا کذب محض بوده و هویت شما در امانت کامل می باشد و هیچکس توانایی دسترسی به آن را ندارد!"));
////                    System.out.println(arraychat.get(0) + " vasl shod be" + arraychat.get(1));
//
//
//                    bot.execute(new SendMessage(arraychat.get(1), "\uD83C\uDFAD  یه نفر برای چت پیدا شد، میتونی صحبت کنی.\n" +
//                            "❌ برای خروج از چت: /end\n" +
//                            "⚠️ توجه کنید که ادعای هرکس مبنی بر مدیریت این ربات، هک کردن شما، افشای اطلاعات شما و ... صرفا کذب محض بوده و هویت شما در امانت کامل می باشد و هیچکس توانایی دسترسی به آن را ندارد!"));
////                    System.out.println(arraychat.get(0) + " vasl shod be" + arraychat.get(1));
//                    arraychat.remove(0);
//                    arraychat.remove(0);
//
//                }
////            stopwatch.stop(); // optional
////            if (stopwatch.elapsed(MILLISECONDS)!=null)
//
////
////                if (updates.get(0).message().chat().id()==84777663){
////                    bot.execute(new SendMessage(199078222,updates.get(0).message().text()));
////                }
////                if (updates.get(0).message().chat().id()==199078222){
////                    bot.execute( new SendMessage(84777663,updates.get(0).message().text()));
////                }
////
////
////
////
////                if (updates.get(0).message().chat().id()==84777663){
////                    if (updates.get(0).message().voice()!=null){
////                        bot.execute(new Pmforwarding().sendVoice(updates.get(0).message().voice().fileId(),199078222));
////                    }
////                }
//
///*---------------------------Forward Sticker--------------------------------------------  */
//
////if (!updates.get(0).message().equals("null")) {
////    if (updates.get(0).message().chat().id() == 84777663) {
////        if (updates.get(0).message().sticker()!=null) {
////
////            bot.execute(new Pmforwarding().sendSticker(updates.get(0).message().sticker().fileId(), 199078222));
////        }
////    }
////
////}
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
//            }
//        }
//
//    }
//
//
