/**
 * 
 */
package org.jpwned.core;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.jpwned.model.Breach;
import org.jpwned.model.Paste;
import org.jpwned.utils.Constants;
import org.jpwned.utils.QueryCollector;

/**
 * This class uses <a href="https://haveibeenpwned.com/">https://haveibeenpwned.com</a> APIs 
 * 
 * @author Dariush Moshiri
 *
 * @see <a href="https://haveibeenpwned.com/API/v2">API info</a>
 * 
 * @see <a href="https://haveibeenpwned.com/API/v2#ResponseCodes">Request errors</a> 
 *  
 *
 */
public class JPwned {
	
	private Gson gson;
	private String userAgent;
	
	/**
	 * @param userAgent this request header must be set otherwise any call will result in an HTTP 403 response
	 */
	public JPwned(String userAgent) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
		gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
		this.gson = gsonBuilder.create();
		
		if(userAgent == null || userAgent.isEmpty())
			throw new IllegalArgumentException("User-Agent must not be empty or null");
		
		this.userAgent = userAgent;
	}
	
	/**
	 * 
	 * @param account email that has to be checked
	 * @return the list of breaches for the <code>account</code>
	 * @throws IOException if there is a problem with the request
	 */
	public List<Breach> getAllBreachesForAccount(String account) throws IOException {
		String url = Constants.HOST + Constants.BREACHED_ACCOUNT + "/" + URLEncoder.encode(account, "UTF-8");
		return Arrays.asList(gson.fromJson(getReaderFromConnection(url), Breach[].class));
	}
	
	/**
	 * 
	 * @param account email that has to be checked
	 * @param domain get only the breaches for this <code>domain</code>
	 * @return the list of breaches of the <code>domain</code> for the <code>account</code>
	 * @throws IOException if there is a problem with the request
	 */
	public List<Breach> getAllBreachesForAccount(String account, String domain) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("domain", domain);
		String url = Constants.HOST + Constants.BREACHED_ACCOUNT + "/" + URLEncoder.encode(account, "UTF-8") + generateRequestParams(params);
		return Arrays.asList(gson.fromJson(getReaderFromConnection(url), Breach[].class));
	}
	
	/**
	 * @return all the breaches in the system
	 * @throws IOException if there is a problem with the request
	 */
	public List<Breach> getAllBreachedSites() throws IOException {
		String url = Constants.HOST + Constants.BREACHED_SITES;
		return Arrays.asList(gson.fromJson(getReaderFromConnection(url), Breach[].class));
	}
	
	/**
	 * @param domain get only the breaches for this <code>domain</code>
	 * @return all the breaches of the <code>domain</code>
	 * @throws IOException if there is a problem with the request
	 */
	public List<Breach> getAllBreachedSites(String domain) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("domain", domain);
		String url = Constants.HOST + Constants.BREACHED_SITES + generateRequestParams(params);
		return Arrays.asList(gson.fromJson(getReaderFromConnection(url), Breach[].class));
	}
	
	/**
	 * @param name title of the breach
	 * @return the breach with <code>name</code> as its title
	 * @throws IOException if there is a problem with the request
	 */
	public Breach getBreach(String name) throws IOException {
		String url = Constants.HOST + Constants.BREACH + "/" + name;
		return gson.fromJson(getReaderFromConnection(url), Breach.class);
	}
	
	/**
	 * A "data class" is an attribute of a record compromised in a breach.
	 * @return all the data classes saved in the system ordered alphabetically
	 * @throws IOException
	 */
	public List<String> getAllDataClasses() throws IOException {
		String url = Constants.HOST + Constants.DATA_CLASSES;
		return Arrays.asList(gson.fromJson(getReaderFromConnection(url), String[].class));
	}
	
	/**
	 * @param account email address to be searched for
	 * @return the list of pastes associated with <code>account</code>
	 * @throws IOException
	 */
	public List<Paste> getAllPastesForAccount(String account) throws IOException  {
		String url = Constants.HOST + Constants.PASTES_ACCOUNT + "/" + URLEncoder.encode(account, "UTF-8");
		return Arrays.asList(gson.fromJson(getReaderFromConnection(url), Paste[].class));
	}
	
	private String generateRequestParams(Map<String, String> params) {
		return params.entrySet().stream().collect(new QueryCollector());
	}
	
	private Reader getReaderFromConnection(String url) throws IOException {
		URLConnection connection = new URL(url).openConnection();
		connection.setRequestProperty("User-Agent", userAgent);
		return new BufferedReader(new InputStreamReader(connection.getInputStream()));
	}
	
}
