package com.sistemas.omarin.restpruebaspaises.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.sistemas.omarin.restpruebaspaises.JsonKeys;
import com.sistemas.omarin.restpruebaspaises.Model.Pais;
import com.sistemas.omarin.restpruebaspaises.Model.PaisResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Sistemas on 19/04/2017.
 */

public class Paisdeserializador implements JsonDeserializer<PaisResponse>{

    @Override
    public PaisResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PaisResponse paisResponse = gson.fromJson(json,PaisResponse.class);

        JsonArray paisResponseResult = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        //JsonObject paisResponseRoot = json.getAsJsonArray().getAsJsonObject();

        return null;
    }

    private ArrayList<Pais> deserializadorArregloJsonResult (JsonArray paisResponseResult){
        ArrayList<Pais> paises = new ArrayList<>();
        for (int i = 0 ; i< paisResponseResult.size();i++ ){
            JsonObject paisResponseUnitario = paisResponseResult.get(i).getAsJsonObject();
            String nombre = paisResponseUnitario.get(JsonKeys.PAIS_NAME).getAsString();
            String code2 = paisResponseUnitario.get(JsonKeys.ALFA2).getAsString();
            String code3 = paisResponseUnitario.get(JsonKeys.ALFA3).getAsString();
        }
    }

}
