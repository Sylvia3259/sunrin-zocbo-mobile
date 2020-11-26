package com.example.sunrin_zocbo_mobile;

public class ItemCard {
    private boolean checked;
    private String text;

    public ItemCard(String text) {
        this.checked = false;
        this.text = text;
    }

    public String GetText() {
        return text;
    }

    public void SetText(String text) {
        this.text = text;
    }

    public boolean IsChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
