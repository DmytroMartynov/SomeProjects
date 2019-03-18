package com.company;

import java.util.HashSet;
import java.util.Set;

public class HwT6 {
    private static String[] emails =
            {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};

    public static void main(String[] args) {
        int result = numUniqueEmails(emails);
        System.out.println(result);

    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> newEmail = new HashSet<String>();
        for (String email : emails) {
            String finishedEmail = getNewEmail(email);
            newEmail.add(finishedEmail);
        }
        System.out.println(newEmail.toString());
        return newEmail.size();
    }

    private static String getNewEmail(String email) {

        StringBuilder updatedEmail = new StringBuilder();
        String localName = email.split("@")[0];
        String domainName = email.split("@")[1];
        char[] localNameChar = localName.toCharArray();
        for (char c : localNameChar) {
            if (c == '.') {
                continue;
            } else if (c == '+') {
                break;
            }
            updatedEmail.append(c);
        }
        updatedEmail.append("@").append(domainName);
        return updatedEmail.toString();
    }
}

