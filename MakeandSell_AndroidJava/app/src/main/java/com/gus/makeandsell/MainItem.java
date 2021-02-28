package com.gus.makeandsell;

class MainItem {

    private final int imgId;
    private final int textId;
    private final int colorValue;
    private final int id;

    MainItem(int id, int imgId, int textId, int colorValue ) {
        this.id = id;
        this.imgId = imgId;
        this.textId = textId;
        this.colorValue = colorValue;
    }

    public int getId() {
        return id;
    }

    public int getImgId() {
        return imgId;
    }

    public int getTextId() {
        return textId;
    }

    public int getColorValue() {
        return colorValue;
    }
}
