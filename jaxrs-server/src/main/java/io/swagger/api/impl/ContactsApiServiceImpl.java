package io.swagger.api.impl;

 import io.swagger.api.*;

 import io.swagger.model.Contact;
 import java.util.*;
 import io.swagger.api.NotFoundException;

 import javax.ws.rs.core.Response;
 import javax.ws.rs.core.SecurityContext;

 @javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2015-11-24T21:54:11.648Z")
 public class ContactsApiServiceImpl extends ContactsApiService {

     private ArrayList<Contact> loadContacts()
     {
         ArrayList<Contact> list = new ArrayList<Contact>();
         list.add(new Contact(1, "Barney Poland", "barney@contoso.com"));
         list.add(new Contact(2, "Lacy Barrera", "lacy@contoso.com"));
         list.add(new Contact(3, "Lora Riggs", "lora@contoso.com"));
         return list;
     }

     @Override
     public Response contactsGet(SecurityContext securityContext)
     throws NotFoundException {
         ArrayList<Contact> list = loadContacts();
         return Response.ok().entity(list).build();
         }

     @Override
     public Response contactsGetById(Integer id, SecurityContext securityContext)
     throws NotFoundException {
         ArrayList<Contact> list = loadContacts();
         Contact ret = null;

         for(int i=0; i<list.size(); i++)
         {
             if(list.get(i).getId() == id)
                 {
                     ret = list.get(i);
                 }
         }
         return Response.ok().entity(ret).build();
     }
 }