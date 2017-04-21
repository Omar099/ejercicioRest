package com.sistemas.omarin.contactos.restApi;

import retrofit2.http.GET;

/**
 * Created by Sistemas on 20/04/2017.
 */

public interface iEndPointsApi {

    @GET(ConstantesRest)
    getContactoReciente();
}
