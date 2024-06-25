import java.io.*;

public class PredefinedField implements Field {

	public PredefinedField(String label, String... prefefinedValues) {
		this.label = label;
		this.predefinedValues = prefefinedValues;
	}

	public void askUser() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		boolean isValid;
		do {
			isValid = false;
			try {
				System.out.print(label + ": ");
				value = console.readLine();

				for (String each : predefinedValues) {
					if (value.toLowerCase().equals(each.toLowerCase())) {
						isValid = true;
						break;
					}
				}
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!isValid);
	}

	public String getValue() {
		return value;
	}

	private String label;
	private String[] predefinedValues;
	private String value;
}
