import java.util.*;

public class Form {
	
	public void addField(Field field) {
		fields.add(field);
	}

	public void askUser() {
		for (Field field : fields) {
			field.askUser();
			System.out.println(field.getValue());
		}
	}

	private List<Field> fields = new ArrayList<Field>();
}
