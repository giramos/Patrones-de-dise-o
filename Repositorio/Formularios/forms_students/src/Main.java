public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new TextField("Nombre"));
		form.addField(new TextField("Apellido"));
		form.addField(new NumericField("Teléfono"));
		form.addField(new PredefinedField("Ciudad", "Santander", "Oviedo", "Cádiz"));

		form.askUser();
	}
}
