package com.eribeiro.projectinterstellar.serverconnection;

/**
 * Created by lgpbentes on 15/09/15.
 */

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import com.eribeiro.projectinterstellar.model.Dado;

import java.io.IOException;
import java.util.ArrayList;

public class HttpConnection {
    public final static String IP = "http://192.168.1.136/lgpbentes/PartePHP/Processo.php";
    public static String getSetDataWeb(String url, String data){

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        String answer = "";

        try{
            ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
            valores.add(new BasicNameValuePair("json", data));

            httpPost.setEntity(new UrlEncodedFormEntity(valores));
            HttpResponse resposta = httpClient.execute(httpPost);
            answer = EntityUtils.toString(resposta.getEntity());
        }
        catch(NullPointerException e){ e.printStackTrace(); }
        catch(ClientProtocolException e){ e.printStackTrace(); }
        catch(IOException e){ e.printStackTrace(); }

        return(answer);
    }

    public static void sendJson(Dado dado){

            String json = generateJSON(dado);
            Log.d("string json", json);
            callServer(json);

    }

    public static String generateJSON(Dado dado){
        JSONObject jo = new JSONObject();

        try {
            jo.put("link", dado.getLink());
            jo.put("data",dado.getData());
            jo.put("status",dado.getStatus());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return (jo.toString());
    }


    //Aqui ele faz a comunicação com o servidor e manda os arquivos
    public static void callServer(final String data) {

        new Thread() {
            public void run() {
                String answer = HttpConnection.getSetDataWeb(IP, data);
                Log.d("Resposta do servidor", answer);
            }
        }.start();
    }
}

