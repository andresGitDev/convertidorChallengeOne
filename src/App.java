import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class App {
	public static void main(String[] args) throws Exception {
		Object[] options = { "Convertir Moneda", "Convertir Temperatura", "Convertir Distancias", "Deseo Salir" };
		String choice = (String) JOptionPane.showInputDialog(null, "¿Qué desea hacer?", "Conversor",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		String[] splitChoice = choice.split(" ");
		Integer selectedOption = 0;
		Boolean continueProgram = Boolean.TRUE;

		if (splitChoice[1].equals("Moneda"))
			selectedOption = 0;
		if (splitChoice[1].equals("Temperatura"))
			selectedOption = 1;
		if (splitChoice[1].equals("Distancias"))
			selectedOption = 2;
		if (splitChoice[1].equals("Salir"))
			selectedOption = 3;

		switch (selectedOption) {

		case 0: {

			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			continueProgram = Boolean.TRUE;

			while (continueProgram) {

				String[] divisas = { "ARG a Dolar", "ARG a Euro", "ARG a Real", "ARG a Uruguayo", "ARG a Chileno",
						"Dolar a ARG", "Euro a ARG", "Real a ARG", "Uruguayo a ARG", "Chileno a ARG" };
				String cambio = (String) JOptionPane.showInputDialog(null, "Elija una opción: ", "Conversor de Moneda",
						JOptionPane.QUESTION_MESSAGE, null, divisas, divisas[0]);

				if (cambio == null || cambio == "") {
					continueProgram = Boolean.FALSE;
					JOptionPane.showMessageDialog(null, "Programa Finalizado");
					System.exit(0);
				}

				String input = JOptionPane.showInputDialog(null, "¿Cuánto va a convertir?:");
				double dinero = 0;

				try {
					dinero = Double.parseDouble(input);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Formato no valido");
				}

				double resultado = 0;

				String[] moneis = cambio.split(" a ");
				String moneyFrom = moneis[0].trim();
				String moneyTo = moneis[1].trim();

				double valueDolar = (394);
				double valueEuro = (290);
				double valueReal = (4);
				double valueUru = (5);
				double valueChi = (25);
				double value = 0;

				if (moneyFrom.equals("ARG")) {
					if (moneyTo.equals("Dolar"))
						value = valueDolar;
					if (moneyTo.equals("Euro"))
						value = valueEuro;
					if (moneyTo.equals("Real"))
						value = valueReal;
					if (moneyTo.equals("Uruguayo"))
						value = valueUru;
					if (moneyTo.equals("Chileno"))
						value = valueChi;
					resultado = dinero / value;
				} else {
					if (moneyFrom.equals("Dolar"))
						value = valueDolar;
					if (moneyFrom.equals("Euro"))
						value = valueEuro;
					if (moneyFrom.equals("Real"))
						value = valueReal;
					if (moneyFrom.equals("Uruguayo"))
						value = valueUru;
					if (moneyFrom.equals("Chileno"))
						value = valueChi;
					resultado = dinero * value;
				}

				JOptionPane.showMessageDialog(null,
						dinero + " " + moneyFrom + " son: " + decimalFormat.format(resultado) + " " + moneyTo);

				Integer confirma = JOptionPane.showConfirmDialog(null, "¿Desea continuar haciendo cambios?", "",
						JOptionPane.YES_NO_OPTION);

				if (confirma == JOptionPane.NO_OPTION) {
					continueProgram = Boolean.FALSE;
					System.exit(0);
				}
			}
		}

		case 1: {

			continueProgram = Boolean.TRUE;

			while (continueProgram) {

				String[] grados = { "Celsius a Fahrenheit", "Fahrenheit a Celsius" };
				Integer cambio = JOptionPane.showOptionDialog(null, "Elija una opción: ", "Conversor de Temperatura",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, grados, grados[0]);
				String valorNominal = JOptionPane.showInputDialog(null, "Ingrese valor a convertir");

				double valor = 0;

				try {
					valor = (Double.parseDouble(valorNominal));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Valor no válido");
					System.exit(0);
				}

				double resultado = 0;

				if (cambio == 0) {
					resultado = (valor * 9 / 5) + 32;
					JOptionPane.showMessageDialog(null,
							valor + " Grados Celsius son: " + resultado + " Grados Fahrenheit");
				} else if (cambio == 1) {
					resultado = (valor - 32) * 5 / 9;
					JOptionPane.showMessageDialog(null,
							valor + " Grados Fahrenheit son: " + resultado + " Grados Celsius");
				}

				Integer continuar = JOptionPane.showConfirmDialog(null, "¿Desea seguir usando el programa?", "",
						JOptionPane.YES_NO_OPTION);

				if (continuar == JOptionPane.NO_OPTION) {
					continueProgram = Boolean.FALSE;
					System.exit(0);
				}
			}
		}

		case 2: {

			continueProgram = Boolean.TRUE;

			while (continueProgram) {

				String[] distancia = { "Centimetros a Metros", "Metros a Kilometros", "Kilometros a Millas",
						"Kilometros a Años Luz", "Metros a Centimetros", "Kilometros a Metros", "Millas a Kilometros",
						"Años Luz a Kilometros" };
				Integer cambio = JOptionPane.showOptionDialog(null, "Elija una opción: ", "Conversor de Temperatura",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, distancia, distancia[0]);
				String valorNominal = JOptionPane.showInputDialog(null, "Ingrese valor a convertir");
				double valor = 0;
				try {
					valor = (Double.parseDouble(valorNominal));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Valor no válido");
					System.exit(0);
				}

				double resultado = 0;

				if (cambio == 0) {
					resultado = valor / 100;
					JOptionPane.showMessageDialog(null, valor + " Centimetros son: " + resultado + " Metros");
				} else if (cambio == 1) {
					resultado = valor / 1000;
					JOptionPane.showMessageDialog(null, valor + " Metros son: " + resultado + " Kilometros");
				} else if (cambio == 2) {
					resultado = valor * 0.621371;
					JOptionPane.showMessageDialog(null, valor + " Kilometros son: " + resultado + " Millas");
				} else if (cambio == 3) {
					resultado = valor * 0.00000000000010570;
					JOptionPane.showMessageDialog(null, valor + " Kilometros son: " + resultado + " Años Luz");
				} else if (cambio == 4) {
					resultado = valor * 100;
					JOptionPane.showMessageDialog(null, valor + " Metros son: " + resultado + " Centimetros");
				} else if (cambio == 5) {
					resultado = valor * 1000;
					JOptionPane.showMessageDialog(null, valor + " Kilometros son: " + resultado + " Metros");
				} else if (cambio == 6) {
					resultado = valor * 1.609344;
					JOptionPane.showMessageDialog(null, valor + " Millas son: " + resultado + " kilometros");
				} else if (cambio == 7) {
					resultado = valor / 0.00000000000010570;
					JOptionPane.showMessageDialog(null, valor + " Años Luz son: " + resultado + " Kilometros");
				}

				Integer continuar = JOptionPane.showConfirmDialog(null, "¿Desea seguir usando el programa?", "",
						JOptionPane.YES_NO_OPTION);

				if (continuar == JOptionPane.NO_OPTION) {
					continueProgram = Boolean.FALSE;
					System.exit(0);
				}

			}

		}

		case 3: {

			System.exit(0);
			break;

		}
		}

	}
}
