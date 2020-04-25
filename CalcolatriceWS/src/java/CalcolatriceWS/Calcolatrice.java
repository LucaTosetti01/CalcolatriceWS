/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalcolatriceWS;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * REST Web Service
 *
 * @author Luca
 */
@ApplicationPath("/")
@Path("calcolatrice")
public class Calcolatrice extends Application{

    public Calcolatrice() {
        super();
    }

    @GET
    @Produces("text/xml")
    @Path("{operation}")
    public String getResult (@PathParam(value="operation") String operation, @QueryParam("X") double x, @QueryParam("Y") double y) {
        double r;
        if(operation.equalsIgnoreCase("ADD")) {
            r= x+ y;
        } else if (operation.equalsIgnoreCase("SUB")) {
            r=x-y;
        } else if (operation.equalsIgnoreCase("MUL")) {
            r=x*y;
        } else if (operation.equalsIgnoreCase("DIV")) {
            if(y!= 0.0) {
                r=x/y;
            } else {
                throw new WebApplicationException(400); //bad request
            }
        } else {
            throw new WebApplicationException(400); // bad request
        }
        return "<result>"+Double.toString(r)+"</result>";
    }
}
