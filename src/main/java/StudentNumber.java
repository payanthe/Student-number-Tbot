import com.google.common.base.Stopwatch;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.AnswerInlineQuery;
import com.pengrad.telegrambot.request.ForwardMessage;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Created by parsa on 4/13/2017.
 */
public class StudentNumber {
    public static void main(String[] args) {

        TelegramBot bot = TelegramBotAdapter.build("337353511:AAFH3Ds2gDxc7TbAf2VP1QHc4lp8-K7xihY");
        Statement data=ConnectDatabase();
        int offset = 0;
        while (true) {
            GetUpdates getUpdates = new GetUpdates().limit(100).offset(offset).timeout(0);
            GetUpdatesResponse updatesResponse = bot.execute(getUpdates);
            List<Update> updates = updatesResponse.updates();
            if (updates.size() > 0) {
                offset = updates.get(0).updateId() + 1;
                updates.forEach(update -> System.out.println(update.message()));

                /////////////////////////////////////
                ////////////////////////////////////////
                ////////////////////////////////////////
                InlineQuery inlineQuery = updates.get(0).inlineQuery();

                if (inlineQuery!=null) {
                    System.out.println(inlineQuery.query());
                    if (!inlineQuery.query().equals("null")){
                        System.out.println("ooooomaddd");


                            if (inlineQuery.query().length()==8 && isNumeric(inlineQuery.query())){
                                ResultSet rs=null;
                                String name=null;
                                try {
                                    rs=data.executeQuery("select * FROM data WHERE student_number="+inlineQuery.query());
                                    System.out.println("ta ghabl az vujud dar data");
                                    if (rs.next()) {
                                        bot.execute(new SendMessage("@studentrequestdataxyz","#"+inlineQuery.from().id().toString()+" "+inlineQuery.query()+"  "+inlineQuery.from().username()));

                                        System.out.println("Dar database mojood ast");
//                                    System.out.println(rs.next());
                                        System.out.println(rs.getMetaData());
                                        System.out.println(rs.findColumn("student_name"));
                                        System.out.println(rs.getString("student_name"));
                                        name=rs.getString(2);

//                                        bot.execute(new SendMessage(inlineQuery.id(), "<b>"+name+"</b>").replyToMessageId(updates.get(0).message().messageId()).parseMode(ParseMode.HTML));
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
                                        InputTextMessageContent inputTextMessageContent=new InputTextMessageContent("<b>"+inlineQuery.query()+"</b>"+"➖"+"<b>"+name+"</b>"+"\n t.me/Studentnumberbot ©").parseMode(ParseMode.HTML);
                                        InlineQueryResult p1 = new InlineQueryResultPhoto(inlineQuery.id()+1, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(10).photoWidth(500).title("akse yek").caption("sadsad");
                                        InlineQueryResult p2 = new InlineQueryResultPhoto(inlineQuery.id()+2, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(20).photoWidth(10);
                                        InlineQueryResult p3 = new InlineQueryResultPhoto(inlineQuery.id()+3, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(30).photoWidth(50);
                                        InlineQueryResult p4 = new InlineQueryResultPhoto(inlineQuery.id()+33, "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg").photoHeight(40).photoWidth(90);
//                         InlineQueryResult r1 = new InlineQueryResultPhoto(inlineQuery.id(), "https://dns-check.nl/basicauth/test.jpg", "https://dns-check.nl/basicauth/test.jpg");
                                        InlineQueryResult r2 = new InlineQueryResultArticle(inlineQuery.id(), name, name+"  "+inlineQuery.query()).thumbWidth(40).thumbHeight(20).description(inlineQuery.query()).thumbUrl("http://s8.picofile.com/file/8292001350/student.jpg").inputMessageContent(inputTextMessageContent);
                                        InlineQueryResult r3 = new InlineQueryResultArticle(inlineQuery.id()+1, inlineQuery.query(), inlineQuery.query()).replyMarkup(inlineKeyboard).description("tozidddhaat").thumbUrl("https://dns-check.nl/basicauth/test.jpg");
//                         InlineQueryResult r3 = new InlineQueryResultArticle(inlineQuery.id(), inlineQuery.query(), inlineQuery.query()).replyMarkup(inlineKeyboard).thumbWidth(30).thumbHeight(20).description("tozidddhaat").thumbUrl("https://dns-check.nl/basicauth/test.jpg");
//                         BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQuery.id(), r1,r3));
                                        bot.execute(
                                                new AnswerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{r2}).isPersonal(true)



//                                         .nextOffset("offset")
//                                         .switchPmParameter("pmParam")
//                                         .switchPmText("pmText")
                                        );






                                        try {

                                            ResultSet rsm = data.executeQuery("select * FROM users WHERE id=" + inlineQuery.from().id());
                                            try {
                                                if (!rsm.next()) {

                                                    String querys = " REPLACE INTO users  (id,name, username)"
                                                            + " values (?, ?, ?)";

                                                    // create the mysql insert preparedstatement
                                                    PreparedStatement preparedStmt = pConnectDatabase(querys);
                                                    preparedStmt.setLong(1, inlineQuery.from().id());
                                                    preparedStmt.setString(2, inlineQuery.from().firstName() +inlineQuery.from().lastName());
                                                    preparedStmt.setString(3, inlineQuery.from().username());
                                                    preparedStmt.execute();
                                                }
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }



                                    }else {
                                        InlineQueryResult r2 = new InlineQueryResultArticle(inlineQuery.id(), "یافت نشد", "وجود ندارد  "+inlineQuery.query()).description("شماره دانشجویی را درست وارد کنید!").thumbWidth(40).thumbHeight(20).description(inlineQuery.query()).thumbUrl("http://s8.picofile.com/file/8292001350/student.jpg");
                                        bot.execute(
                                                new AnswerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{r2}).isPersonal(true)



//                                         .nextOffset("offset")
//                                         .switchPmParameter("pmParam")
//                                         .switchPmText("pmText")
                                        );
//                                        bot.execute(new SendMessage(id, "یافت نشد \uD83D\uDE14").replyToMessageId(updates.get(0).message().messageId()).parseMode(ParseMode.HTML));

                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                        }else {
                                InlineQueryResult r2 = new InlineQueryResultArticle(inlineQuery.id(), "لطفا فقط شماره دانشجویی را وارد کنید", "وجود ندارد  "+inlineQuery.query()).description("شماره دانشجویی را درست وارد کنید!").thumbWidth(40).thumbHeight(20).description(inlineQuery.query()).thumbUrl("http://s8.picofile.com/file/8292001350/student.jpg");
                                bot.execute(
                                        new AnswerInlineQuery(inlineQuery.id(), new InlineQueryResult[]{r2}).isPersonal(true)



//                                         .nextOffset("offset")
//                                         .switchPmParameter("pmParam")
//                                         .switchPmText("pmText")
                                );
                            }

                    }
                }


                if (updates.get(0).message() != null) {
                    Message message=updates.get(0).message();
                    Long id = message.chat().id();
                    if (!Objects.equals(message.text(), null)) {

                        bot.execute(new ForwardMessage("@studentrequestdataxyz",id,message.messageId()));
                        bot.execute(new SendMessage("@studentrequestdataxyz","#"+id.toString()+" "+message.text()+"  "+message.from().username()));

                        String text=message.text();
                        if (!Objects.equals(message.replyToMessage(), null)){
                            if (message.replyToMessage()!=null){
                                if (message.replyToMessage().forwardFrom()!=null) {
                                    if (message.replyToMessage().forwardFrom().id() != null) {
                                        if (message.chat().id() == 84777663){

                                    bot.execute(new SendMessage(message.replyToMessage().forwardFrom().id(), updates.get(0).message().text()));
                                }
                                    }
                                }


                                System.out.println("injaaa"+updates.get(0).message().replyToMessage().text());
                                if (message.replyToMessage().text().equals("پیام خود را بنویسید")){
                                    System.out.println(message.replyToMessage().text().equals("پیام خود را بنویسید"));
                                    System.out.println("\n \n \n"+updates.get(0).message().replyToMessage().text());
                                    bot.execute(new ForwardMessage(84777663,id,message.messageId()));

                                }else {
                                    String alert="❌شماره دانشجویی 8 رقمی می\u200Cباشد❌\n" +
                                            "لطفا فقط شماره دانشجویی را تایپ کنید\n" +
                                            "مثال:";
                                    bot.execute(new SendMessage(id, alert+"<b>91170858</b>").replyToMessageId(updates.get(0).message().messageId()).parseMode(ParseMode.HTML));
                                }
                            }
//

                        }else if (Objects.equals(text, "/feedback")){
                            Keyboard forceReply = new ForceReply();
                            bot.execute(new SendMessage(id,"پیام خود را بنویسید").replyMarkup(forceReply).parseMode(ParseMode.HTML));
                        }
                        else if (Objects.equals(text, "/start")){
                            bot.execute(new SendMessage(message.chat().id(), "با سلام برای  دریافت نام دانشجو از روی شماره ی دانشجویی شماره ی دانشجویی  \uD83C\uDD94 مورد نظر را به صورت زیر وارد کنید \n" +
                                    " \n" +
                                    "مانند:91170871 \n" +
                                    "\n برای ارتباط با سازنده از دستور feedback/ استفاده کنید"+
                                    "\n ‼️فقط برای دانشجویان پردیس شریف‼️"));














                            // execute the preparedstatement

                            try {

                                ResultSet rsm = data.executeQuery("select * FROM users WHERE id=" + id);
                                try {
                                    if (!rsm.next()) {

                                        String query = " REPLACE INTO users (id,name, username)"
                                                + " values (?, ?, ?)";

                                        // create the mysql insert preparedstatement
                                        PreparedStatement preparedStmt = pConnectDatabase(query);
                                        preparedStmt.setLong(1, id);
                                        preparedStmt.setString(2, message.from().firstName() + message.from().lastName());
                                        preparedStmt.setString(3, message.from().username());
                                        preparedStmt.execute();
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


//                            data.execute("REPLACE INTO users (last_name, first_name)")
                            System.out.println("start zzad");
                        }else {
                            if (text.length()==8 && isNumeric(text)){
                                ResultSet rs=null;
                                String name=null;
                                try {
                                    rs=data.executeQuery("select * FROM data WHERE student_number="+text);
                                    System.out.println("ta ghabl az vujud dar data");
                                if (rs.next()) {
                                    System.out.println("Dar database mojood ast");
//                                    System.out.println(rs.next());
                                    System.out.println(rs.getMetaData());
                                    System.out.println(rs.findColumn("student_name"));
                                    System.out.println(rs.getString("student_name"));
                                    name=rs.getString(2);

                                    bot.execute(new SendMessage(id, "<b>"+name+"</b>").replyToMessageId(message.messageId()).parseMode(ParseMode.HTML));




                                }else {
                                    bot.execute(new SendMessage(id, "یافت نشد \uD83D\uDE14").replyToMessageId(message.messageId()).parseMode(ParseMode.HTML));

                                }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }


                            }else {
                                String alert="❌شماره دانشجویی 8 رقمی می\u200Cباشد❌\n" +
                                        "لطفا فقط شماره دانشجویی را تایپ کنید\n" +
                                        "مثال:";
                                bot.execute(new SendMessage(id, alert+"<b>91170858</b>").replyToMessageId(message.messageId()).parseMode(ParseMode.HTML));


                            }







                        }



                    }

                    if (Objects.equals(updates.get(0).message().text(), null)) {
                               System.out.println("not found");
                    }


                }


            }





        }





    }


public static Statement ConnectDatabase(){
    Statement stmt=null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection consql = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentnumber", "root", "");
         stmt = consql.createStatement();
        return stmt;
    }catch (Exception e){
        System.out.println(e);
    }


return stmt;



}




    public static PreparedStatement pConnectDatabase(String query){
        PreparedStatement stmt=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection consql = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentnumber", "root", "");
            stmt = consql.prepareStatement(query);
            return stmt;
        }catch (Exception e){
            System.out.println(e);
        }


        return stmt;



    }
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }



}
