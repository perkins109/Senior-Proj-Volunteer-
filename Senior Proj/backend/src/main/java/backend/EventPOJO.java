package backend;

public class EventPOJO 
{
	//Declares values for event objects
	private String name,
				   status,
				   description,
				   date,
				   time,
				   owner,
				   contactemail,
				   lat,
				   address,
				   lng;

	
	//Returns event latitude value
	public String getLat() 
	{
		return lat;
	}

	//Sets event latitude field
	public void setLat(String lat) 
	{
		this.lat = lat;
	}

	//Returns event address value
	public String getAddress() {
		return address;
	}

	//Sets event address field
	public void setAddress(String address) {
		this.address = address;
	}

	//Returns event longitude value
	public String getLng() 
	{
		return lng;
	}

	//Sets event longitude field
	public void setLng(String lng) 
	{
		this.lng = lng;
	}

	//Returns event name value
	public String getName() 
	{
		return name;
	}

	//Sets event name field
	public void setName(String name)
	
	{
		this.name = name;
	}

	//Returns event status value
	public String getStatus() 
	{
		return status;
	}

	//Sets event status field
	public void setStatus(String status) 
	{
		this.status = status;
	}

	//Returns event description value
	public String getDescription() 
	{
		return description;
	}

	//Sets event description field
	public void setDescription(String description) 
	{
		this.description = description;
	}

	//Returns event date value
	public String getDate() 
	{
		return date;
	}

	//Sets event date field
	public void setDate(String date) 
	{
		this.date = date;
	}

	//Returns event time value
	public String getTime() 
	{
		return time;
	}

	//Sets event time field
	public void setTime(String time) 
	{
		this.time = time;
	}

	//Returns event owner value
	public String getOwner() 
	{
		return owner;
	}

	//Sets event owner field
	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	//Returns event contact email value
	public String getContactEmail() 
	{
		return contactemail;
	}

	//Sets event contact email field
	public void setContactEmail(String contactEmail) 
	{
		this.contactemail = contactEmail;
	}
	
	/*
	Method override for the toString method
	Concatenates name, status, description, date, time, owner, contact email, latitude, and longitude into one String.
	*/
	@Override
	public String toString() 
	{
		return "EventPOJO [name=" + name + ", status=" + status + ", description=" + description + ", date=" + date
				+ ", time=" + time + ", owner=" + owner + ", contactemail=" + contactemail + ", lat=" + lat + ", lng="
				+ lng + "]";
	}
}
