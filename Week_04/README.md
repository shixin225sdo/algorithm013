学习笔记
思路：
#### 一.首先确认这个半排序数组的含义
1.数组分为两块，每一块都是有序的
2.一块的最末尾值一定小于另一块的起始值。
故[4,5,6,7,0,1,2]是符合的
故[4,5,6,7,0,10,11]是不符合的
#### 二.二分查找运用
1.正常的二分查找根据每次取中间值，将查询减半
2.此处可根据二分查找的思想，通过取中间值，比较left和right，判断无序属于左区间还是右区间
3.注意循环终止条件是left小于right，若包含等于会死循环；left和right也不是mid+1，因为mid不像正常二分查找会有个判断处理。
4.代码如下
、、、
@Override
public int find(int nums) {
    int left=0;
    int right=nums.length-1;
    while(left<right){
        int mid=left + (right - left) / 2;
        if(nums[left]>=nums[mid]){
            right=mid;
        }
        if(nums[right]<=nums[mid]){
            left=mid;
        }
    }
    return left;
}
、、、
