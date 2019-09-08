package title;

public class ArrayTitle {

    /**
     * 只出现一次的数字
     */
    public int singleNumber(int[] nums){
        //异或运算
        int res = 0;
        for(int i = 0; i < nums.length;i++){
            res ^= nums[i];
            System.out.println("合并代码测试");
        }
        return res;
    }

    /**
     * 存在重复
     */
    public boolean containsDuplicate(int[] nums) {
        //方法一：
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;

        //方法二：使用 HashSet
        //方法三：先将数组进行排序，然后对比数组中的前后数据即可
    }

    /**
     * 旋转数组
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int last = 0;
        for (int i = 1; i <= k; i++) {
            last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    /**
     * 买卖股票的最佳时机2
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += (prices[i + 1] - prices[i]);
            }
        }
        return max;
    }

    /**
     * 从排序数组中删除重复项
     */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[r++] = nums[i];
            }
        }

        return r;
    }

}
