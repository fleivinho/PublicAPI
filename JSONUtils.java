package net.wypixel.commons.bukkit.api;

import java.util.List;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.wypixel.commons.bukkit.Commons;
public class JSONUtils {
	  
	/**
	 * @author wypixel
	 */
	
	  public JsonObject json;
	  public JSONUtils(JsonObject json) 
	  {
		  this.json = json;
	  }
	  
	  public JSONUtils fromJson(JsonObject obj) {
		  return new JSONUtils(obj);
	  }

      public JsonObject set(String priority, String change) {
		  JsonObject info = new JsonObject();
		  for(JsonElement t : info.getAsJsonArray()) {
		  if(t.toString() == priority.toLowerCase()) {
		  info.addProperty(t.toString().toLowerCase(), change);
		  } else {
		  info.addProperty(t.toString().toLowerCase(), json.get(t.toString().toLowerCase()).getAsString());
		  }
		  }
		  return info;
	  }
      
      
      public JsonObject set(String priority, boolean change) {
		  JsonObject info = new JsonObject();
		  if(this.json == null) {
			  Commons.getPlugin().getLogger().warning("Arquivo JSON nulo.");
			  return null;
		  }
		  for(Entry<String, JsonElement> t : json.entrySet()) {	
			  
		  if(t.getKey().contains(priority)) {
		  info.addProperty(t.getKey(), change);
		  } else {
		  info.addProperty(t.getKey(), this.json.get(t.getKey()).getAsBoolean());
		  }
		  }
		  return info;
	  }
      
      public JsonObject set(String priority, int change) {
		  JsonObject info = new JsonObject();
		  for(JsonElement t : info.getAsJsonArray()) {
		  if(t.toString() == priority.toLowerCase()) {
		  info.addProperty(t.toString().toLowerCase(), change);
		  } else {
		  info.addProperty(t.toString().toLowerCase(), json.get(t.toString().toLowerCase()).getAsInt());
		  }
		  }
		  return info;
	  }
      
      
      public JsonObject add(String priority, int change) {
		  JsonObject info = new JsonObject();
		  for(JsonElement t : info.getAsJsonArray()) {
		  if(t.toString() == priority.toLowerCase()) {
		  info.addProperty(t.toString().toLowerCase(), json.get(t.toString().toLowerCase()).getAsInt() + change);
		  } else {
		  info.addProperty(t.toString().toLowerCase(), json.get(t.toString().toLowerCase()).getAsInt());
		  }
		  }
		  return info;
	  }
	  
	public static JsonObject createJson(List<String> objects, List<Object> values) {
		  JsonObject info = new JsonObject();
		  for(int i=0; i < objects.size(); i ++)
		  {
		  if (values.get(i) instanceof String) {
		  info.addProperty(objects.get(i), (String)values.get(i));
		  } else if (values.get(i) instanceof Integer) {
		  info.addProperty(objects.get(i), (Integer)values.get(i));
		  } else if (values.get(i) instanceof Boolean) {
			  info.addProperty(objects.get(i), (Boolean)values.get(i));
		  }
		  }  
		  return info;
	}}

