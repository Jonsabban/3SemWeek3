/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanox.rest.quotes;

import com.google.gson.Gson;
import entity.EntityQuote;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static javax.swing.UIManager.put;
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
@Path("quote")
public class Quote {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Quote
     */
    public Quote() {
    }

    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

    /**
     * Retrieves representation of an instance of sanox.rest.quotes.Quote
     *
     * @return an instance of java.lang.String
     */
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getQuote(@PathParam("id") int id) {
        //TODO return proper representation object
        return "Quote nr: " + id + " - " + quotes.get(id);
    }

    @Path("random")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomQuote() {
        Random r = new Random();
        int id = r.nextInt(quotes.size()) + 1;
        return "{\"quote\": \"" + quotes.get(id) + "\"}";
    }

    /**
     * PUT method for updating or creating an instance of Quote
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postQuote(String json) {
        int id = quotes.size() + 1;

        EntityQuote q = new Gson().fromJson(json, EntityQuote.class);
        q.setId(id);
        quotes.put(id, q.getQuote());

        return new Gson().toJson(q);
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String editQuote(String json, @PathParam("id") int id) {

        EntityQuote q = new Gson().fromJson(json, EntityQuote.class);
        q.setId(id);
        quotes.put(id, q.getQuote());

        System.out.println(quotes.get(id));
        return new Gson().toJson(q);
    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteQuote(String json, @PathParam("id") int id) {
        
        String response = "{\"quotes\":\"" + quotes.get(id) + "\"}";
        quotes.remove(id);
        return response;
        
    }
}
