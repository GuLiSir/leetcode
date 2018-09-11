package com.leetcodelib;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/self-dividing-numbers/description/
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        List<Integer> integers = selfDividingNumbers(1, 22);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    /**
     * 分析:
     * 1.自除数不允许包含0,所以在每一次循环的时候,将包含0的数先过滤掉
     * 2.通过条件分析发现,1-9均为自除数(此条件可进行判断,也可不用进行判断,因为后面的判断适用于此情况)
     * 3.以上两个条件剔除之后,剩下的数从个位开始检查,一直用i对个位数取余数,同时每循环一次,将要检查的数/10,
     * 当要检查的数小于10的时候,并且依然能被整除,则该数为自除数
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        out:
        for (int i = left; i <= right; i++) {
            //大于0,并且小于10的整数必然是自除数
//            if (i < 10) {
//                result.add(i);
//                continue;
//            }
            int check = i;
            //检查数字的每一位是否包含0
            while (check / 10 != 0) {
                if (check % 10 == 0) {
                    //过滤掉包含0的数
                    //System.out.println("过滤掉包含0的数:" + i);
                    continue out;
                }
                check /= 10;
            }

            //包含0检查完成,能执行到这里说明每一位都不包含0,都是符合统计条件的数
            //
            int check2 = i;
            while (check2 % 10 != 0) {
                int i1 = check2 % 10;
                if (i % i1 != 0) {
                    continue out;
                } else {
                    if (check2 < 10) {
                        result.add(i);
                    }
                }
                check2 /= 10;
            }

        }
        return result;
    }
}
