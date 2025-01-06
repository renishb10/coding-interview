package javaa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * LeetCode: #187 The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C',
 * 'G', and 'T'. For example, "ACGAATTCCG" is a DNA sequence. When studying DNA, it is useful to
 * identify repeated sequences within the DNA. Given a string s that represents a DNA sequence,
 * return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * You may return the answer in any order. Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" Output:
 * ["AAAAACCCCC","CCCCCAAAAA"]
 */
public class RepeatedDNASequence {
    private static String[] findRepeatedDNASequence(String s) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
            if (set.contains(subString)) {
                list.add(subString);
            } else {
                set.add(subString);
            }
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String res = Arrays.toString(findRepeatedDNASequence("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(res);
    }
}
