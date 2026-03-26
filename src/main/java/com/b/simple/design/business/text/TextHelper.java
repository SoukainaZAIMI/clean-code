package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		// Vérifie si la chaîne contient moins de 2 caractères
		if (str.length() < 2) {
			return str;
		}

		// Retourne la chaîne avec les deux derniers caractères échangés
		String fixedPart = str.substring(0, str.length() - 2);
		char lastChar = str.charAt(str.length() - 1);
		char secondLastChar = str.charAt(str.length() - 2);
		return fixedPart + lastChar + secondLastChar;
	}

	public String truncateAInFirst2Positions(String str) {
		// Si la chaîne contient 2 caractères ou moins, remplace simplement les 'A'
		if (str.length() <= 2) {
			return str.replace("A", "");
		}

		// Remplace les 'A' dans les 2 premiers caractères et concatène avec le reste de la chaîne
		String firstTwoChars = str.substring(0, 2);
		String firstTwoCharsWithoutA = firstTwoChars.replace("A", "");
		String fixedPart = str.substring(2);
		return firstTwoCharsWithoutA + fixedPart;
	}
}
