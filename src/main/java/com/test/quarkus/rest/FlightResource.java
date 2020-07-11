package com.test.quarkus.rest;

import java.util.Date;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.test.quarkus.model.Flight;

@Path("/flight")
public class FlightResource {

	@GET
	@Path("/search")
	 public Response searchFlights(@QueryParam("fromcity") String fromcity, @QueryParam("tocity") String tocity,@QueryParam("date") Date date) {
	
		System.out.println("From City is :" + fromcity);
		System.out.println("To City is :" + tocity);
		System.out.println("Date is :" + date);
		
		return Response.ok(Flight.list("fromcity",fromcity)).build();
	}
	 
	@POST
	@Path("/add")
	public Response addFlight(Flight flight) {
		flight.persist();
		Jsonb jsonb = JsonbBuilder.create();
		System.out.println("Flight Details are :" + jsonb.toJson(flight));
		return Response.ok(flight).status(201).build();
	}
	
}
