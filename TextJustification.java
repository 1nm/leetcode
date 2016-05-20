public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int currentWidth = 0;
            int j = i;
            while (j < words.length) {
                if (currentWidth == 0) {
                    currentWidth = words[j].length(); // single word width is gauranteed not exceeding maxWidth
                } else if (currentWidth + 1 + words[j].length() <= maxWidth) { // at least one space between words
                    currentWidth += words[j].length() + 1;
                } else
                    break;
                j ++;
            }
            result.add(pack(words, i, j, maxWidth));
            i = j;
        }
        return result;
    }

    private String pack(String[] words, int start, int end, int width) {
        StringBuilder sb = new StringBuilder();
        int wordCount = end - start;
        if (wordCount == 1) {
            sb.append(words[start]);
            for (int i = 0; i < width - words[start].length(); ++ i)
                sb.append(' ');
            return sb.toString();
        }
        if (end == words.length) { // last line
            for (int i = start; i < end; ++ i) {
                sb.append(words[i]);
                if (i < end - 1)
                    sb.append(' ');
            }
            while (sb.length() < width)
                sb.append(' ');
            return sb.toString();
        }
        int spaces = width;
        for (int i = start; i < end; ++ i) {
            spaces -= words[i].length();
        }
        int[] spaceWidth = new int[wordCount - 1];
        int i = 0;
        while (spaces > 0) {
            spaceWidth[i]++;
            spaces--;
            i++;
            if (i == spaceWidth.length) i = 0;
        }
        for (i = start; i < end; ++ i) {
            sb.append(words[i]);
            if (i < end - 1)
                for (int j = 0; j < spaceWidth[i - start]; ++ j)
                    sb.append(' ');
        }
        return sb.toString();
    }
}
