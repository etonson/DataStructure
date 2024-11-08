package binaryTree;

import org.apache.commons.lang3.StringUtils;

/*
  @author : eton.lin
  @description TODO
  @date 2024-07-23 上午 12:19
*/
public class Test {
    public static void main(String[] args) {
        String str1 = "經常見到使用「惠請」一詞，" +
                "如「惠請惠會」、「惠請查照」.." +
                "本意在於請受文者協助；但字面意思成" +
                "了「惠予請求」，義理不通，宜戒用之。";
        System.out.println(unCommonChineseCharacterFilter(str1));
    }

    public static String unCommonChineseCharacterFilter(String inputString) {
        if (StringUtils.isNotBlank(inputString) || StringUtils.isNotEmpty(inputString)) {
            StringBuilder resultStr = new StringBuilder();
            inputString = transferSpecialPunctuationMarks(inputString);
            String[] tr = inputString.split("");
            for (String ch : tr) {
                if (isCommonChineseCharacter(ch)) {
                    resultStr.append(ch);
                } else {
                    resultStr.append("?");
                }
            }
            return resultStr.toString();
        } else {
            return "";
        }
    }

    /*
     * 特定全形符號轉半形(ex:…)
     * */
    private static String transferSpecialPunctuationMarks(String input) {
        if (StringUtils.isNotEmpty(input) || StringUtils.isNotBlank(input)) {
            if (input.contains("…")) {
                return input.replaceAll("…", "...");
            } else {
                return input;
            }
        } else {
            return "";
        }
    }

    private static boolean isCommonChineseCharacter(String input) {
        String regEx = "[a-zA-Z0-9\\p{P}|\\p{S}|\\p{Z}]";
        if (input.matches(regEx)) {
            return true;
        } else {
            char[] ch = input.toCharArray();
            return (ch[0] >= 0x4E00 && ch[0] <= 0x9FFF);
        }
    }
}
