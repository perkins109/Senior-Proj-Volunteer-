package backend;

public class EventPOJO 
{
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

	

	public String getLat() 
	{
		return lat;
	}

	public void setLat(String lat) 
	{
		this.lat = lat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLng() 
	{
		return lng;
	}

	public void setLng(String lng) 
	{
		this.lng = lng;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	
	{
		this.name = name;
	}

	public String getStatus() 
	{
		return status;
	}

	
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}



	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}

	public String getOwner() 
	{
		return owner;
	}

	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	public String getContactEmail() 
	{
		return contactemail;
	}

	public void setContactEmail(String contactEmail) 
	{
		this.contactemail = contactEmail;
	}
	

	@Override
	public String toString() 
	{
		return "EventPOJO [name=" + name + ", status=" + status + ", description=" + description + ", date=" + date
				+ ", time=" + time + ", owner=" + owner + ", contactemail=" + contactemail + ", lat=" + lat + ", lng="
				+ lng + "]";
	}
	
	

}
