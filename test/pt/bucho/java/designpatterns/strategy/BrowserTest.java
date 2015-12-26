package pt.bucho.java.designpatterns.strategy;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import pt.bucho.java.designpatterns.strategy.Browser;
import pt.bucho.java.designpatterns.strategy.HttpProtocol;
import pt.bucho.java.designpatterns.strategy.HttpsProtocol;
import pt.bucho.java.designpatterns.strategy.WebProtocol;

public class BrowserTest {

	Browser browser;
	WebProtocol wp1, wp2;
	
	String url, httpResponse, httpsResponse;
	boolean executeMethodCalled;
	
	@Before
	public void setUp() throws Exception {
		browser = new Browser(null);
		url = "someURL";
		httpResponse = "Browsed through HTTP";
		httpsResponse = "Browsed through HTTPS";
		executeMethodCalled = false;
	}

	@Test
	public void browseMethodCallsProtocolExecution(){
		wp1 = new HttpProtocol(){
			@Override
			public String execute(String url){
				executeMethodCalled = true;
				return null;
			}
		};
		
		browser.setProtocol(wp1);
		
		browser.browse(url);
		
		assertTrue(executeMethodCalled);
	}
	
	@Test
	public void webProtocolsAreInterchangeable() {
		wp1 = EasyMock.createMock(HttpProtocol.class);
		wp2 = EasyMock.createMock(HttpsProtocol.class);
		
		assertNull(browser.getProtocol());
		
		EasyMock.expect(wp1.execute(url)).andReturn(httpResponse);
		EasyMock.replay(wp1);
		browser.setProtocol(wp1);
		String result1 = browser.browse(url);
		EasyMock.verify(wp1);
		assertEquals(httpResponse, result1);
		
		EasyMock.expect(wp2.execute(url)).andReturn(httpsResponse);
		EasyMock.replay(wp2);
		browser.setProtocol(wp2);
		String result2 = browser.browse(url);
		EasyMock.verify(wp2);
		assertEquals(httpsResponse, result2);
		
	}
	
}
