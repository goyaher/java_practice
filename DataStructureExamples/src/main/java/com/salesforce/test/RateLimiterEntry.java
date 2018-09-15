package com.salesforce.test;
import java.util.LinkedList;
import java.util.Queue;


/**
 * My understanding of the problem and solution:
 * 
 * Requests are coming from different users and are being put in a GLOBAL queue. 
 * Request is modelled by the "Request" class. Each request has a client Id and request Id. For sake of simplicity each request times out in 20 seconds, i.e it can wait a max of 20 secs and is rendered invalid and discarded.
 * 
 * A Consumer thread is consuming requests from the queue, which multiple clients are putting in requests to the queue. This can be modelled by a consumer and multiple Producer threads.
 * 
 * 
 */

public class RateLimiterEntry
{
	public static void main(String args[])
	{
		Queue<Request> requests = new LinkedList<>(); //all requests are added to the queue;
		
		Client c1 = new Client("1", LicenceType.LOW);
		Client c2 = new Client("2", LicenceType.MEDIUM);
		
		//TODO: 1. Create client (Producer) threads and pass on requests to them and start them to put there stuff in the queue. 
		// Essentially Queue will contains random requests form random clients.
		
		//TODO: 2. Next, start a consumer thread, and pass on the 'requests' queue to it. 
		// At t=t, It will simply read each item and decrement the request's client so far processed size.
		// Once the size reaches the clients threshold, it will block all requests for that client until time t=t+unit
		
	}
}

/**
 * Interface for blocking a user's request.
 * 
 * @author Nitika
 *
 */
interface RateLimiter
{
	void blockRequest(Request request, Client client);
	boolean isUsageLimitCrossed(Client client);
	void block();
}

/**
 * Implementation class for RateLimiter interface
 * 
 * @author Hershit
 *
 */
class MyRateLimiter implements RateLimiter
{
	private static final int CAPACITY = 1000;
	
	public void blockRequest(Request request, Client client)
	{
		if (isUsageLimitCrossed(client))
		{
			block();
		}
	}
	
	public boolean isUsageLimitCrossed(Client client)
	{
		//TODO:
		return true;
	}
	
	public void block()
	{
		//TODO:
	}
}

/**
 * Request POJO
 * 
 * @author Hershit
 */
class Request
{
	private String requestId; //unique Id for the request, can be GUID
	private String clientId; //client Id for this request
	private boolean isTimedOut; //whether the request timed out or not.
	
	public Request(String requestId, String clientId)
	{
		this.requestId = requestId;
		this.clientId = clientId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}

/**
 * 
 * Client class. This model the external user who sends the request.
 * 
 * @author Hershit
 *
 */
class Client
{
	private String clientId;
	private LicenceType licenceType;
	
	public Client (String clientId, LicenceType licenseType)
	{
		this.clientId = clientId;
		this.licenceType = licenseType;
	}
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public LicenceType getLicenceType() {
		return licenceType;
	}
	public void setLicenceType(LicenceType licenceType) {
		this.licenceType = licenceType;
	}
}

/**
 * Enumeration for different License Types
 * 
 * @author Hershit
 *
 */
enum LicenceType
{
	LOW (10), MEDIUM (20), HIGH (30);
	
	private int requestsPerSecond;
	
	private LicenceType(int requestsPerSecond)
	{
		this.requestsPerSecond = requestsPerSecond;
	}
	
	public int getValue()
	{
		return requestsPerSecond;
	}
}