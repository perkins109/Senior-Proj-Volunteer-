package backend;
import static spark.Spark.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;

import spark.Route;





public class Spark 
{
	
	private JsonUtil json = new JsonUtil();
	private static EventPOJO pojo = new EventPOJO();
	
	 
	 
	public static void main(String[] args) throws SQLException, Exception 
	{
		DBConnector db = new DBConnector("voluntold");
		Users user = new Users(db);
		Events event = new Events(db);
		
	
		
		JsonUtil json = new JsonUtil();
		Gson gson = new Gson();
		
		//validate username and PW
		get("/user/:userName/:password",  (request, response) -> {
			return gson.toJson(user.userValidate(request.params(":userName"), request.params(":password")));
		});  
		
		//Make a new user
		get("/makeuser/:userName/:password/:email/:location/:phone/:sex",  (request, response) -> {
			return gson.toJson(user.addUser(request.params(":userName"), request.params(":password"), request.params(":email"),
					request.params(":location"), request.params(":phone"), request.params(":sex") ));
		});  
		
		//search for events by name
		get("/events/search/name/:eventName",  (request, response) -> {
			return json.convertToJSON(event.nameSearch(request.params(":eventName")), "events");
		});
		
		//search for events by date
		get("/events/search/date/:yyyy-mm-dd",  (request, response) -> {
			return json.convertToJSON(event.dateSearch(request.params(":yyyy-mm-dd")), "events");
		}); 
		
		//retrive user info by user name, returns location, email, phone,
		get("/user/:userName",  (request, response) -> {
			return json.convertToJSON(user.getUser(request.params(":userName")), "user");
		});
		
		//TODO Get user events attended
		/*get("/user/userName",  (request, response) -> {
			return json.convertToJSON(event.dateSearch(request.params("userName")), "events");
		});*/
		
		//TODO Get user events created
		/*get("/user/userName",  (request, response) -> {
			return json.convertToJSON(event.dateSearch(request.params("userName")), "events");
		});*/
		
		//TODO make user profile editable should use PUT
		/*put("/user/userName",  (request, response) -> {
			return json.convertToJSON(event.dateSearch(request.params("userName")), "events");
		});*/
		
		//Change the users password
		get("/user/changePassword/:userName/:currentPassword/:newPassword",  (request, response) -> {
			return gson.toJson(user.changePw(request.params(":userName"),request.params(":currentPassword"), request.params(":newPassword")));
		});
		
		//Increases an events attendace counter by 1
		get("/events/attend/:eventID",  (request, response) -> {
			return gson.toJson(event.attend(request.params(":eventID")));
			});
		
		//Post an event and save it the the database
		post("/add/event", (request, response) -> {
			System.out.println("I got here");
			pojo = gson.fromJson(request.body(), EventPOJO.class);
			System.out.println("and here");
			event.add(pojo);
			
            return "The event has been added";
		});
		
		
        
	}
	
	

	
		
	
}
