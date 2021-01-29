二分查找法: 基础框架
  1.  左闭右开区间
            int left = 0;
            int right = nums.length;//注意这个值
            while (left < right) {//注意符号没有=
                int mid = left + (right - left) / 2;//使用减法防止数字过大溢出
                if (target < nums[mid]) {
                    right = mid;//开区间直接=
                } else if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
   2.  左闭右闭区间
              int left = 0;
              int right = nums.length - 1;//从最后一个索引开始
              while (left <= right) {//有=
                  int mid = left + (right - left) / 2;
                  if (target > nums[mid]) {
                      left = mid + 1;
                  } else if (target < nums[mid]) {
                      right = mid - 1;//因为是闭区间所以-1 否侧会重复
                  } else {
                      return mid;
                  }
              }
              return right + 1;
滑动窗口问题: 就是特殊的双指针   一般用于数组  字符串
        int left = 0, right = 0;
        //需要的数据
                Map<Character, Integer> need = new HashMap<>();
        //        窗口数据
                Map<Character, Integer> window = new HashMap<>();
                for (int i = 0; i < s1.length(); i++) {
                    char c = s1.charAt(i);
                    need.put(c, need.getOrDefault(c, 0) + 1);
                }

                int left = 0, right = 0, valid = 0;
                while (right < s2.length()) {
                    char c = s2.charAt(right);
                    //窗口内数据更新  根据实际实现
                    /*
                    .....
                    */

                    right++;

                    //是否收缩 判断条件根据实际情况
                    while (right - left >= s1.length()) {

                        char d = s2.charAt(left);
                        left++;
                        //窗口数据更新  根据实际情况
                        /*
                        ......
                        */
                    }
                }

   考虑:
  1、当移动  right  扩⼤窗⼝，即加⼊字符时，应该更新哪些数据？
  2、什么条件下，窗⼝应该暂停扩⼤，开始移动  left  缩⼩窗⼝？
  3、当移动  left  缩⼩窗⼝，即移出字符时，应该更新哪些数据？
  4、我们要的结果应该在扩⼤窗⼝时还是缩⼩窗⼝时进⾏更新？

  反转问题:
  普通反转很简单  多考虑一下局部反转+整体反转  可能会有意想不到的效果