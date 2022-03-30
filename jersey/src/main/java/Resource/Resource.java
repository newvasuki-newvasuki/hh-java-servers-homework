package Resource;

import javax.ws.rs.*;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/counter")
public class Resource {

    private static Counter counter = new Counter();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Counter get(){
        return counter;
    }

    @POST
    public void post(){
        counter.postCounter();
    }
    
    @DELETE
    public void delete(@QueryParam("Subtraction-Value") Integer subtractionValue){
        counter.deleteCounter(subtractionValue);
    }

    @POST
    @Path("/clear")
    public void clear(@CookieParam(value="hh-auth") String cookieHhauthValue){
        if(cookieHhauthValue.length()>10)counter.clearCounter();
    }

}
