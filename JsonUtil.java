package test.test;
import java.sql.ResultSet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonUtil 
{
	public static JsonObject convertToJSON(ResultSet resultSet)
            throws Exception 
	{
        JsonArray jsonArray = new JsonArray();
        
        while (resultSet.next()) 
        {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JsonObject obj = new JsonObject();
            for (int i = 0; i < total_rows; i++) 
            {
                obj.addProperty(resultSet.getMetaData().getColumnLabel(i + 1)
                        .toLowerCase(),resultSet.getString(i + 1));
                
               
            }
            jsonArray.add(obj);
        }
        
        JsonObject jsonObject = new JsonObject();
        jsonObject .add("arrayName",jsonArray);
        return jsonObject;
    }
}
