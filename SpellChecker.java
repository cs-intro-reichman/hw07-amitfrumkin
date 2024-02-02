
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction); 
	}

	public static String tail(String str) {

		String tail = str.substring(1) ;
		
		return tail ;
	}

	public static int levenshtein(String word1, String word2) {

		String word1Low = word1.toLowerCase() ;
		String word2Low = word2.toLowerCase() ;

		if (word2Low.length() == 0){
			return word1Low.length() ;
		}
		if (word1Low.length() == 0){
			return word2Low.length() ;
		}
		if (word1Low.substring(0,1).equals(word2Low.substring(0,1))){
			return levenshtein(tail(word1Low), tail(word2Low)) ; 
		}
		else{
			int first = levenshtein(tail(word1Low),word2Low);
			int second = levenshtein(word1Low,tail(word2Low));
			int third = levenshtein(tail(word1Low),tail(word2Low));

			int minOfThree = Math.min(Math.min(first,second ), third) ; 
			return 1 + minOfThree ;
			
		}
		
		
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < 3000; i++) {
			dictionary [i] = in.readLine() ;
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {

		String wordLow = word.toLowerCase() ;
		String mostSimillar = dictionary[0] ;


		for (int i = 0; i < 3000 ; i++) {
			int distance = levenshtein(dictionary[i],wordLow);
			if (distance <= threshold && distance < levenshtein(wordLow,mostSimillar) ){
				mostSimillar = dictionary[i];
			}

		}
		return mostSimillar ; 
	}
}

