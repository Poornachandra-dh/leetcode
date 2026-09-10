import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < words.length) {

            // Find how many words can fit in this line
            int j = i;
            int wordsLength = 0;

            while (j < words.length &&
                   wordsLength + words[j].length() + (j - i) <= maxWidth) {

                wordsLength += words[j].length();
                j++;
            }

            int wordCount = j - i;

            // Last line or only one word
            if (j == words.length || wordCount == 1) {

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {
                    if (k > i) {
                        line.append(" ");
                    }

                    line.append(words[k]);
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

                result.add(line.toString());
            }

            // Normal fully-justified line
            else {

                // Total spaces required
                int totalSpaces = maxWidth - wordsLength;

                // Number of gaps between words
                int gaps = wordCount - 1;

                // Minimum spaces per gap
                int spacesPerGap = totalSpaces / gaps;

                // Extra spaces that need to go to the left
                int extraSpaces = totalSpaces % gaps;

                StringBuilder line = new StringBuilder();

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        // Give first 'extraSpaces' gaps one additional space
                        int spaces = spacesPerGap;

                        if (k - i < extraSpaces) {
                            spaces++;
                        }

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }

                result.add(line.toString());
            }

            i = j;
        }

        return result;
    }
}