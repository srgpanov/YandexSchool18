package com.srgpanov.yandexschool18;

public class Page {
    private String clientID;
    private String page;

    public Page(String clientID, String page) {
        this.clientID = clientID;
        this.page = page;
    }

    @Override
    public String toString() {
        return "clientID = " + clientID + " page = " + page;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}