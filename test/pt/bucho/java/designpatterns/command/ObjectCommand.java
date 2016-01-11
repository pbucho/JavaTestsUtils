package pt.bucho.java.designpatterns.command;

public class ObjectCommand implements Command {

	private TestObject tobj;
	
	public ObjectCommand(TestObject tobj){
		this.tobj = tobj;
	}
	
	@Override
	public void activate() {
		tobj.activate();
	}

	@Override
	public void deactivate() {
		tobj.deactivate();
	}

}
