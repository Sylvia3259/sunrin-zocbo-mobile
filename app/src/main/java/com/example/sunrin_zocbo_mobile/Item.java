package com.example.sunrin_zocbo_mobile;

import java.util.Map;

public class Item {
    private String subject;
    private String filename;

    public Item(Map<String, Object> data) {
        this.subject = data.get("subject").toString();
        this.filename = data.get("path").toString() + data.get("filename").toString();;
    }

    public String getSubject() {
        return subject;
    }

    public String getFilename() {
        return filename;
    }
}
