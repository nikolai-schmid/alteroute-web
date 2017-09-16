package dao;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Contact;
import model.GameParticipation;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-09-16T11:24:35.659Z")
public abstract class GamesApiService {
	public abstract Response readGameParticipationItems(SecurityContext securityContext) throws NotFoundException;
    public abstract Response readGameItems(Integer id,SecurityContext securityContext) throws NotFoundException;
}
