package com.example.sunrin_zocbo_mobile;

import android.util.Log;

public class ItemCard {
    private boolean checked;
    private String text;
    private String filename;

    public ItemCard(Item item) {
        this.checked = false;
        this.text = item.getSubject();
        this.filename = item.getFilename();
    }

    public boolean IsChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String GetText() {
        return text;
    }

    public void SetText(String text) {
        this.text = text;
    }

    public String getFilename() {
        return filename;
    }
}
