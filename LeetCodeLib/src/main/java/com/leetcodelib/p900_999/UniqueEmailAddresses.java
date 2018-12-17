package com.leetcodelib.p900_999;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * <p>
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 除了小写字母，这些电子邮件还可能包含 ',' 或 '+'。
 * <p>
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * <p>
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
 */
public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int i = numUniqueEmails(strings);
        System.out.println(i);
    }


    /**
     * 将每个元素,拆开两部分来看,地址只要文本对不上就是一个地址,所以当一个key,名字部分,先将.和@用符合规则的方式过滤掉,然后再用set去重就行了
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> setMap = new HashMap<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String addr = split[1];
            String head = split[0];
            if (head.contains("+")) {
                head = head.substring(0, head.indexOf("+"));
            }
            head = head.replace(".", "");

            //根据相同地址,判断所在的收件人存不存在
            Set<String> strings = setMap.get(addr);
            if (strings == null) {
                strings = new HashSet<>();
                setMap.put(addr, strings);
            }
            strings.add(head);


        }

        int count = 0;
        for (String s : setMap.keySet()) {
            Set<String> strings = setMap.get(s);
            count+= strings.size();
        }
        return count;
    }

}
