package net.rishiz.rxjavaretrofitpoc.model;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class EntriesDTO implements Serializable {

	@SerializedName("API")
	private String aPI;

	@SerializedName("Description")
	private String description;

	@SerializedName("Auth")
	private String auth;

	@SerializedName("HTTPS")
	private boolean hTTPS;

	@SerializedName("Cors")
	private String cors;

	@SerializedName("Link")
	private String link;

	@SerializedName("Category")
	private String category;

	public String getAPI(){
		return aPI;
	}

	public String getDescription(){
		return description;
	}

	public String getAuth(){
		return auth;
	}

	public boolean isHTTPS(){
		return hTTPS;
	}

	public String getCors(){
		return cors;
	}

	public String getLink(){
		return link;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"EntriesDTO{" + 
			"aPI = '" + aPI + '\'' + 
			",description = '" + description + '\'' + 
			",auth = '" + auth + '\'' + 
			",hTTPS = '" + hTTPS + '\'' + 
			",cors = '" + cors + '\'' + 
			",link = '" + link + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}