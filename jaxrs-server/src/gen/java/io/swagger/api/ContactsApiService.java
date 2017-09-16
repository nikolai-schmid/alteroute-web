package io.swagger.api;

public abstract class GamesApiService {
    public abstract Response contactsGet(SecurityContext securityContext) throws NotFoundException;
    public abstract Response contactsGetById(Integer id,SecurityContext securityContext) throws NotFoundException;
}
