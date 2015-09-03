package com.glitterlabs.gridimagesearch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class ImageResult implements Serializable {

    private static final long serialVersionUID = -203940993949039L;
    public String fullUrl;
    public String thumbUrl;
    public String title;

    public ImageResult(JSONObject json) {

        try {
            this.thumbUrl = (String) json.get("tbUrl");
            this.fullUrl = (String) json.get("url");
            this.title = (String) json.get("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ImageResult> fromJsonArray(JSONArray array) {

        ArrayList<ImageResult> results = new ArrayList<ImageResult>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new ImageResult(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

}
