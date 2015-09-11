package com.eribeiro.projectinterstellar.model;

/**
 * Created by lgpbentes on 03/09/15.
 */
public class Dado {
    String link, data;
    int status;

    public Dado(String link, String data, int status){
        this.link = link;
        this.data = data;
        this.status = status;
    }

    public Dado(){
        this(null, null, 0);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
