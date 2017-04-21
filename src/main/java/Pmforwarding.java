import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.*;

/**
 * Created by parsarec on 3/25/2017.
 */
public class Pmforwarding {

    public SendMessage sendMessage(Update up,long toId){

        return new SendMessage(toId, up.message().text())
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(true)
                .replyToMessageId(1);

    }




    public SendPhoto sendPhoto( String fileID,long toId){
        return new SendPhoto(toId,fileID);
    }


    public SendVoice sendVoice( String fileID, long toId){
        return new SendVoice(toId,fileID);
    }
    public SendAudio sendAudio( String fileID, long toId){
        return new SendAudio(toId,fileID);
    }


    public SendDocument sendDocument(Update up, String fileID, long toId){
        return new SendDocument(toId,fileID);
    }
    public SendSticker sendSticker( String fileID, long toId){
        return new SendSticker(toId,fileID);
    }

}
