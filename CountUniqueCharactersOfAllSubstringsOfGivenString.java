// Count Unique Characters of All Substrings of a Given String

class CountUniqueCharactersOfAllSubstringsOfGivenString {
    public int uniqueLetterString(String s) {
        
	int[] lastSeenCharIndexPositions = new int[26]; // cover all the letters of the alphabet
        Arrays.fill(lastSeenCharIndexPositions, -1); 
        
        int[] charOccurrenceCounter = new int[26]; // Count the number of times a letter in the alphabet occurs
        Arrays.fill(charOccurrenceCounter, -1);
		
	int count = 0; 
        int res = 0;
	
	for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i) - 'A'; // All characters are uppercase
            int lastVisitedCharValue = lastSeenCharIndexPositions[charValue];
            int preLastVisitedCharValue = charOccurrenceCounter[charValue];
			
            // -- double minus becomes a plus.  Ingenious code
            count += i - lastVisitedCharValue - lastVisitedCharValue + preLastVisitedCharValue;     
            charOccurrenceCounter[charValue] = lastSeenCharIndexPositions[charValue];
            lastSeenCharIndexPositions[charValue] = i;
            res += count;   
	}        
	return res;
    }
}
