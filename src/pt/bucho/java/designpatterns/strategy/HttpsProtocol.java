package pt.bucho.java.designpatterns.strategy;

public class HttpsProtocol implements WebProtocol{

	@Override
	public String execute(String url) {
		return "HTTPS";
	}

}
