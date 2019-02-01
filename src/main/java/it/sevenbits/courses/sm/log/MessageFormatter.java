package it.sevenbits.courses.sm.log;

import java.util.HashMap;
import java.util.Map;

public class MessageFormatter {

    private Map<String, String> map;

    public MessageFormatter() {
        map = new HashMap<>();
        map.put("MESSAGE", "Part of message: %1$s");
        map.put("TRASH", "Trash received");
        map.put("MESSAGE_START", "Message creating started");
        map.put("MESSAGE_FINISH", "Message creating finished");
    }

    public String getStringFormatByType(String type){

        if (map.keySet().contains(type)) {
            return map.get(type);
        } else {
            return "Unknown package type";
        }
    }
}
