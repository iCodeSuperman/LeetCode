package WeeklyMatches.Day2021_0718;

import org.junit.Test;

/**
 * 5161. 可以输入的最大单词数
 * @author icodeboy
 */
public class Q001 {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int len = words.length;
        int count = len;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            for (int j = 0; j < brokenLetters.length(); j++) {
                String sub = brokenLetters.substring(j, j + 1);
                if(word.contains(sub)){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void t(){
        String words = "leet code";
        String broken = "e";
        System.out.println(this.canBeTypedWords(words, broken));
    }

}
