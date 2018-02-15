# SimpleRest
simple rest api for shopping list

REST ENDPOINTS :

method	path          description				                    body parameters(JSON) 

GET     items/all     return all the items in the list	    --------------------------------------

GET	    items/{id}	  return item with specific id		      --------------------------------------

POST	  items		      create item of given id and gives	    itemId,itemName,itemPrice,itemQuantity
			                error if the item exists

PUT	    items/{id}	  update item of given id and gives	    itemName,itemPrice,itemQuantity
			                error if the item does not exists

DELETE 	items/{id}	  delete item of given id			          ---------------------------------------
