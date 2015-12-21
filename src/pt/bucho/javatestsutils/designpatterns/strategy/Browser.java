package pt.bucho.javatestsutils.designpatterns.strategy;

public class Browser {

	WebProtocol browsingProtocol;
	
	public Browser(WebProtocol protocol){
		this.browsingProtocol = protocol;
	}
	
	public String browse(String url){
		return browsingProtocol.execute(url);
	}
	
	public WebProtocol getProtocol(){
		return browsingProtocol;
	}
	
	public void setProtocol(WebProtocol protocol){
		this.browsingProtocol = protocol;
	}
}
