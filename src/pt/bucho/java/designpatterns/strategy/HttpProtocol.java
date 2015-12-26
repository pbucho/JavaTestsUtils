package pt.bucho.java.designpatterns.strategy;

public class HttpProtocol implements WebProtocol{

	@Override
	public String execute(String url) {
		return "HTTP";
	}

}
