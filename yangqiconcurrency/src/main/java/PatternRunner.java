import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternRunner {
    public static void main(String[] args) {
       // while(true){

            foo2();
        //}

    }

    private static void foo2() {
        List<String> passwordKeyList = new ArrayList<>();

        String reflowPlanBReplaceRegexs = "";


        Pattern p = Pattern.compile(reflowPlanBReplaceRegexs);
        Matcher matcher = p.matcher("abc");
        String raw = matcher.replaceAll("");
        System.out.println(raw);

        String reflowPlanBFindRegexs = "b5}";

        Pattern p1 = Pattern.compile(reflowPlanBFindRegexs);
        Matcher matcher1 = p1.matcher(raw);
        while(matcher1.find()) {
            String passwordKey = matcher1.group();
            if (passwordKey != null) {
                passwordKeyList.add(passwordKey);
            }
        }
    }

    private static void foo1() {
        List<String> passwordKeyList = new ArrayList<>();

        Pattern p = Pattern.compile("xx");
        Matcher matcher = p.matcher("abc");
        while (matcher.find()) {
            String passwordKey = matcher.group(1);
            if (passwordKey != null) {
                passwordKeyList.add(passwordKey);
            }
        }
    }


}
