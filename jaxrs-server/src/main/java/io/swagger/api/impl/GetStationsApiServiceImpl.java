package io.swagger.api.impl;

import com.google.gson.Gson;
import dao.StationDao;
import io.swagger.api.*;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T20:48:32.436Z")
public class GetStationsApiServiceImpl extends GetStationsApiService {
    @Override
    public Response stationsGet(SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        StationDao sd = new StationDao();
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK,
                new Gson().toJson(sd.readStationItems()).toString().replace("\\\"","\""))).build();
    }
}
