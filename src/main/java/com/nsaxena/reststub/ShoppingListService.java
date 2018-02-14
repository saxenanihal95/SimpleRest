package com.nsaxena.reststub;

import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jersey.repackaged.com.google.common.collect.Lists;

@Path("/items")
public class ShoppingListService {
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItems()
	{
		List<ShoppingList> items=ShoppingListDB.getAll();
		if(items.isEmpty())
		{
			return Response.noContent().build();
		}
		GenericEntity<List<ShoppingList>> entity = 
	            new GenericEntity<List<ShoppingList>>(Lists.newArrayList(items)) {};
	    return Response.ok(entity).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getItem(@PathParam("id") int id)
	{
		ShoppingList item=ShoppingListDB.getbyId(id);
		if(id  < 0){
	        return Response.noContent().build();
	    }
		GenericEntity<ShoppingList> entity = 
	            new GenericEntity<ShoppingList>(item,ShoppingList.class);
	    return Response.ok(entity).build();
	}
	
	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee( ShoppingList item ) throws URISyntaxException
	{
	    if(item == null){
	        return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_BODY).build();
	    }
	     
	    if(item.getItemName() == null) {
	        return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_NAME).build();
	    }else if(item.getItemPrice()==null){
	    	return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_PRICE).build();
	    }else if(item.getItemQuantity()==null){
	    	return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_NAME).build();
	    }
	    boolean createdItem=ShoppingListDB.create(item); 
	    if(createdItem)
	    {
	    	return Response.ok().entity(ShoppingListDB.SUCCESS_CREATED).build();
	    }else {
	    	return Response.status(400).entity(ShoppingListDB.ERROR_ALREADY_EXISTS).build();
	    }
	    
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployeeById(@PathParam("id") Integer id, ShoppingList item)
	{
	     
		if(item == null){
	        return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_BODY).build();
	    }
	     
	    if(item.getItemName() == null) {
	        return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_NAME).build();
	    }else if(item.getItemPrice()==null){
	    	return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_PRICE).build();
	    }else if(item.getItemQuantity()==null){
	    	return Response.status(400).entity(ShoppingListDB.ERROR_EMPTY_NAME).build();
	    }
	    
	    boolean updatedItem=ShoppingListDB.create(item); 
	    if(updatedItem)
	    {
	    	return Response.ok().entity(ShoppingListDB.SUCCESS_UPDATED).build();
	    }else {
	    	return Response.status(400).entity(ShoppingListDB.ERROR_DOES_NOT_EXISTS).build();
	    }
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployeeById(@PathParam("id") Integer id)
	{
	     
	    boolean deletedItem=ShoppingListDB.remove(id); 
	    if(deletedItem)
	    {
	    	return Response.ok().entity(ShoppingListDB.SUCCESS_DELETED).build();
	    }else {
	    	return Response.status(400).entity(ShoppingListDB.ERROR_DOES_NOT_EXISTS).build();
	    }
	}
}
