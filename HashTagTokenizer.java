

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for (int i = 0; i < 3000; i++) {
			dictionary [i] = in.readLine() ;
		}

		return dictionary;
	}

	/*public static void print(String[] arr){
		for (int i = 0; i < arr.length+1; i++) {
			System.out.println(arr[i]);
		}

	}*/

	public static boolean existInDictionary(String word, String []dictionary) {

		for (int i = 0; i < 3000; i++) {
			if(dictionary [i].equals(word))
				return true ; 
			
		}
		return false;
	
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
		String hashtagLowCase = hashtag.toLowerCase() ;

        for (int i = 1; i <= N; i++) {

				if (existInDictionary(hashtagLowCase.substring(0,i),dictionary)){
					String newWord = hashtagLowCase.substring(0,i) ;
					System.out.println (newWord);
					String restWord =  hashtagLowCase.substring(i);
					 if (existInDictionary(restWord, dictionary)) {
						breakHashTag(restWord,dictionary);
					 }
					
					
				}
				
			 			 	
		
        }
			
		
				
				
    }

}
