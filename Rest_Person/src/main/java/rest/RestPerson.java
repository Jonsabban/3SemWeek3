/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import converter.JSONConverter;
import entity.Person;
import facade.Facade;
import facade.FacadeInterface;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Sanox
 */
@Path("person")
public class RestPerson {

    @Context
    private UriInfo context;

    private FacadeInterface f = new Facade(Persistence.createEntityManagerFactory("PU"));
    
    public RestPerson() {
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonId(@PathParam("id") Long id) {
        
        Person p = f.getPerson(id);
        String json = JSONConverter.getJSONFromPerson(p);
        return json;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putPerson(String json) {
        Person p = JSONConverter.getPersonFromJson(json);
        String response = "add person: " + p.getFirstName();
        f.addPerson(p);
        return response;
    }
    
    @Path("{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postPerson(String json, @PathParam("id") Long id) {
        Person p = f.getPerson(id);
        JSONConverter.getJSONFromPerson(p);
        f.editPerson(p);
        
        return p.getFirstName();
    }
    
    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deletePerson(String json, @PathParam("id") Long id) {
        Person p = f.getPerson(id);
        f.deletePerson(p.getId());
        
        return "removed: " + p.getId();
    }
    
}
