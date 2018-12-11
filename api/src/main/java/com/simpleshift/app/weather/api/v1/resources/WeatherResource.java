package com.simpleshift.app.weather.api.v1.resources;

//import si.fri.rso.samples.orders.entities.Order;
//import si.fri.rso.samples.orders.services.OrdersBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@ApplicationScoped
@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WeatherResource {

    /*
    @Context
    private UriInfo uriInfo;

    @Inject
    private OrdersBean ordersBean;

    @GET
    public Response getOrders() {

        List<Order> orders = ordersBean.getOrders(uriInfo);

        return Response.ok(orders).build();
    }
    */

    @GET
    public Response getWeather() {
        return Response.status(Response.Status.OK).entity("Vreme je lepo.").build();
    }

    /*
    @POST
    public Response createOrder(Order order) {

        if (order.getTitle() == null || order.getTitle().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            order = ordersBean.createOrder(order);
        }

        if (order.getId() != null) {
            return Response.status(Response.Status.CREATED).entity(order).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity(order).build();
        }
    }

    @PUT
    @Path("{orderId}")
    public Response putOrder(@PathParam("orderId") Integer orderId, Order order) {

        order = ordersBean.putOrder(orderId, order);

        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            if (order.getId() != null)
                return Response.status(Response.Status.OK).entity(order).build();
            else
                return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @PATCH
    @Path("{orderId}/completed")
    public Response orderCompleted(@PathParam("orderId") Integer orderId) {

        Order order = ordersBean.completeOrder(orderId);

        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            if (order.getId() != null)
                return Response.status(Response.Status.OK).entity(order).build();
            else
                return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @DELETE
    @Path("{orderId}")
    public Response deleteCustomer(@PathParam("orderId") String orderId) {

        boolean deleted = ordersBean.deleteOrder(orderId);

        if (deleted) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    */
}