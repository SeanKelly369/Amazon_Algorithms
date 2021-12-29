// Count Unique Characters of All Substrings of a Given String

class CountUniqueCharactersOfAllSubstringsOfGivenString {
    public int uniqueLetterString(String s) {
        
	int[] lastSeen = new int[26]; // cover all the letters of the alphabet
        Arrays.fill(lastSeen, -1);
        
        int[] preLastSeen = new int[26];
        Arrays.fill(preLastSeen, -1);
		
	int count = 0; 
        int res = 0;
	
	for (int i = 0; i < s.length(); i++) {
            int charValue = s.charAt(i) - 'A'; // All characters are uppercase
            int lastVisitedCharValue = lastSeen[charValue];
            int preLastVisitedCharValue = preLastSeen[charValue];
			
            // -- double minus becomes a plus.  Ingenious code
            count += i - lastVisitedCharValue - lastVisitedCharValue + preLastVisitedCharValue;     
            preLastSeen[charValue] = lastSeen[charValue];
            lastSeen[charValue] = i;
            res += count;   
	}        
	return res;
    }
}
