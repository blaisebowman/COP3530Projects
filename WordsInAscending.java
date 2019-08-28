//Blaise Bowman, COP3530 Project 4 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*(Display the words in ascending order) Revise the below program,
CountOccurrenceOfWords.java and Rewrite CountOccurenceOfWords.java to display the
words in ascending order of occurrence counts. 
Display in ascending order or occurrence count:
ex: 1 - apple
	1- zoo
	2 - cool
	17 - book
	
*/

public class WordsInAscending {


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
					if (key.length() > 0 && Character.isLetter(key.charAt(0))) {
						if (!map.containsKey(key)) { /*-if the key is NOT already in the Map */
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
			// GetS key and value from each entry
			
			List<wordOccurence> words = new ArrayList<>();
			for (Map.Entry<String, Integer> entry : entrySet){
				wordOccurence a = new wordOccurence();
				words.add(a);
				a.word = entry.getKey();
				a.count = entry.getValue();
			}
			
			Collections.sort(words);
			
			for (int i = 0; i < words.size(); i++) {
				System.out.print(words.get(i).count);
				System.out.print('\t' + words.get(i).word);
				System.out.print('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	static class wordOccurence implements Comparable<wordOccurence> {
		String word; // first field
		Integer count; // second field
		
		@Override
	    public int compareTo(wordOccurence words){
			return count.compareTo(words.count);
	    }

	}


}
