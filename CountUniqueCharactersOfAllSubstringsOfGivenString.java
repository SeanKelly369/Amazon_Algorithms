// Count Unique Characters of All Substrings of a Given String

class CountUniqueCharactersOfAllSubstringsOfGivenString {
    public int uniqueLetterString(String s) {
        
	int[] lastSeenCharIndexPositions = new int[26]; // cover all the letters of the alphabet
        Arrays.fill(lastSeenCharIndexPositions, -1); 
        
        int[] preLastCharOccurrencePos = new int[26]; // Store the previous last index position where a character appeared, with a minus -1 value
        Arrays.fill(preLastCharOccurrencePos, -1);
		
	int count = 0; 
        int res = 0;
	
	for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i) - 'A'; // All characters are uppercase
            int lastVisitedCharValue = lastSeenCharIndexPositions[charValue];
            int preLastVisitedCharValue = preLastCharOccurrencePos[charValue];
			
            // -- double minus becomes a plus.  Ingenious code
            count += i - lastVisitedCharValue - lastVisitedCharValue + preLastVisitedCharValue;     
            preLastCharOccurrencePos[charValue] = lastSeenCharIndexPositions[charValue];
            lastSeenCharIndexPositions[charValue] = i;
            res += count;   
	}        
	return res;
    }
}
