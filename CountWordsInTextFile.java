//Blaise Bowman, COP3530 Project 4 

/*(Count the occurrences of words in a text file)
Rewrite CountOccurrenceOfWords.java to read the text from a text file. The text file is passed
as a command-line argument. Words are delimited by whitespace characters, punctuation
marks (, ; . : ?), quotation marks (' "), and parentheses. Count words in case-insensitive fashion
(e.g., consider Good and good to be the same word). The words must start with a letter. Display
the output in alphabetical order of words, with each word preceded by its occurrence count.*/

//DELIMITERS: (,) (;) (.) (:) (?) (') (") and parentheses ()
//Case IN-sensitive
//Words must start with a letter 


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//Specify the file as a command-line argument in Run Configurations -> Arguments (For Eclipse)
//My file is "basicString.txt" with path "C:\Users\mut50\workspace\Bowman_P4\src\basicString.txt"
//Pass "C:\Users\mut50\workspace\Bowman_P4\src\basicString.txt" as an Argument
//

public class CountWordsInTextFile {

	public static void main(String[] args) {

		try {
			/*- Pass your file as a command line argument, then place your file path in Files.readAllLines(Paths.get("C:/yourfilepath.txt)) */
			List<String> allLines = Files
					.readAllLines(Paths.get("C:/Users/mut50/workspace/Bowman_P4/src/basicString.txt"));
			Map<String, Integer> map = new TreeMap<>();
			for (String line : allLines) { // for each line in the file
				String[] words2 = line.split("[ \n\t\r.,;:!?(){}]"); /*- splits the string(line)by delimiters */
				for (int i = 0; i < words2.length; i++) {
					String key = words2[i].toLowerCase(); /*-The current word, modified to lower case */
					if (key.length() > 0 && Character.isLetter(
							key.charAt(0))) { /*- Ensures the word does NOT start with a number (is a letter) */
						if (!map.containsKey(key)) {/*-if the key is NOT already in the Map */
							map.put(key, 1);
						} else { // if the key IS already in the map
							int value = map.get(key);
							value++; // increments value
							map.put(key, value);
						}
					}
				}
			}

			Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
			// Get key and value from each entry
			for (Map.Entry<String, Integer> entry : entrySet)
				System.out.println(entry.getValue() + "\t" + entry.getKey());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

