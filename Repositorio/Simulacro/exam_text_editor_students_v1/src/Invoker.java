import java.io.IOException;

public class Invoker {
	
	public void execute(Command comand) throws IOException {
		comand.execute();
	}
}
