package net.rishiz.rxjavaretrofitpoc.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseDTO implements Serializable {

	@SerializedName("count")
	private int count;

	@SerializedName("entries")
	private List<EntriesDTO> entries;

	public int getCount(){
		return count;
	}

	public List<EntriesDTO> getEntries(){
		return entries;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"count = '" + count + '\'' + 
			",entries = '" + entries + '\'' + 
			"}";
		}
}