import com.google.common.base.Stopwatch;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        Stopwatch.createStarted();
        System.out.println(validEmailCount(emails));
        System.out.println();
    }

    public static int validEmailCount(String[] emails) {
        HashSet<String> seen = new HashSet<>();
        boolean addLetter;
        boolean domain;
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            addLetter = true;
            domain = false;
            for (int i = 0; i < email.length(); i++) {
                switch (email.charAt(i)) {
                    case '+':
                        addLetter = false;
                        break;
                    case '.':
                        if (!domain) {
                            break;
                        }
                    case '@':
                        addLetter = true;
                        domain = true;
                    default:
                        if (addLetter) {
                            sb.append(email.charAt(i));
                        }
                }
            }
            seen.add(sb.toString());
        }
        return seen.size();
    }
}
