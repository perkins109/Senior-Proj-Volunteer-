package backend;

public class EventPOJO 
{
	private String name,
				   status,
				   description,
				   location,
				   date,
				   time,
				   owner,
				   contactemail;

	

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

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
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
		return "EventPOJO [name=" + name + ", status=" + status + ", description=" + description + ", location="
				+ location + ", date=" + date + ", time=" + time + ", owner=" + owner + ", contactEmail=" + contactemail
				+ "]";
	}

}
