package com.main;

import com.domain.ListNode;
import com.domain.TreeNode;
import com.easy.*;
import com.tool.CreateTreeByLayerOrder;
import com.tool.TreeOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProblemInput {
    @Test
    public void e168(){
        E168_ExcelSheetColumnTitle e = new E168_ExcelSheetColumnTitle();
        int[] arr = {1, 2, 26, 27, 28, 52, 53, 54, 701, 702};
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " = " + e.convertToTitle(arr[i]));
        }
    }

    @Test
    public void e155(){
        E155_MinStack minStack = new E155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min2 = minStack.getMin();
        System.out.println("min="+min+"; top="+top+"; min2="+min2);
    }

    @Test
    public void e141(){
        int[] arr = {3, 2, 0, -4};
        int pos = 1;
        ListNode headNode = new ListNode(arr[0]);
        ListNode head = headNode;
        ListNode pre = headNode;
        for(int i = 1; i < arr.length; i++){
            ListNode listNode = new ListNode(arr[i]);
            headNode.next = listNode;
            headNode = listNode;
        }

        int count = 0;
        while(pre != null){
            if(count == pos){
                headNode.next = pre;
                break;
            }
            pre = pre.next;
            count ++;
        }

        E141_LinkedListCycle e = new E141_LinkedListCycle();
        System.out.println(e.hasCycle(head));

    }

    @Test
    public void e136(){
        int[] arr = {1, 1, 2, 3, 4, 2, 2, 3, 4};
        E136_SingleNumber e = new E136_SingleNumber();
        System.out.println(e.singleNumber(arr));
    }

    @Test
    public void e125(){
        String[] str = {"A man, a plan, a canal: Panama","race a car", "rA1221Ar", "abb"};
        E125_ValidPalindrome e125 = new E125_ValidPalindrome();
        for(int i = 0; i < str.length; i++){
            System.out.println(e125.isPalindrome(str[i]));
        }
    }

    @Test
    public void e121(){
        int[] arr1 = {7,1,5,3,6,4};
        int[] arr2 = {7,6,4,3,1};
        int[] arr3 = {7,6,4,3,1,9,0,11};
        E121_BestTimeToBuyAndSellStock e = new E121_BestTimeToBuyAndSellStock();
        E122_BestTimeToBuyAndSellStock2 e2 = new E122_BestTimeToBuyAndSellStock2();
        //System.out.println(e.maxProfit(arr3));
        System.out.println(e2.maxProfit(arr2));
    }

    @Test
    public void e119(){
        E119_PascalsTriangle2 e = new E119_PascalsTriangle2();
        List<Integer> list = e.getRow(5);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();
    }

    @Test
    public void e118(){
        E118_PascalsTriangle e = new E118_PascalsTriangle();
            List<List<Integer>> listTwo = e.generate(5);
            for (List<Integer> list : listTwo) {
                for (Integer value : list) {
                    System.out.print(value+" ");
                }
                System.out.println();
            }
    }

    @Test
    public void e112() {
        String[] arr1 = {"3", "9", "20", "null", "null", "15", "7"};
        String[] arr2 = {"5", "4", "8", "11", "null", "13", "4", "7", "2", "null", "null", "null", "1"};
        int sum = 22;
        TreeNode bt = new TreeNode();
        bt = CreateTreeByLayerOrder.LayerInsert(bt, arr2);
        E112_PathSum e = new E112_PathSum();
        System.out.println(e.hasPathSum(bt, sum));

    }

    @Test
    public void e111(){
        String[] arr1 = {"3", "9", "20", "null", "null", "15", "7"};
        String[] arr2 = {"1", "2", "2", "3", "3", "null", "null", "4", "4"};
        String[] arr3 = {"1","2","2","3","null","null","3","4","null","null","4"};
        String[] arr4 = {"1","2","3","4","5","null","6","7","null","null","null","null","8"};
        String[] arr5 = {"1", "2"};
        TreeNode bt = new TreeNode();
        bt = CreateTreeByLayerOrder.LayerInsert(bt, arr5);
        E111_MinimumDepthOfBinaryTree e = new E111_MinimumDepthOfBinaryTree();
        System.out.println(e.minDepth(bt));
    }

    @Test
    public void e110(){
        String[] arr1 = {"3", "9", "20", "null", "null", "15", "7"};
        String[] arr2 = {"1", "2", "2", "3", "3", "null", "null", "4", "4"};
        String[] arr3 = {"1","2","2","3","null","null","3","4","null","null","4"};
        String[] arr4 = {"1","2","3","4","5","null","6","7","null","null","null","null","8"};
        TreeNode bt = new TreeNode();
        bt = CreateTreeByLayerOrder.LayerInsert(bt, arr4);
        E110_BalancedBinaryTree e = new E110_BalancedBinaryTree();
        System.out.println(e.isBalanced(bt));
    }

    @Test
    public void e108(){
        int[] nums = {-10, -3, 0, 5, 9};
        E108_ConvertSortedArrayToBinarySearchTree e = new E108_ConvertSortedArrayToBinarySearchTree();
        TreeNode treeNode = e.sortedArrayToBST(nums);
        TreeOrder.preOrder(treeNode);

    }

    @Test
    public void e107(){
        String[] arr1 = {"1", "2", "2", "3", "4", "4", "3"};
        //String[] arr1 = {"1"};
        TreeNode bt = new TreeNode();
        bt = CreateTreeByLayerOrder.LayerInsert(bt, arr1);
        E107_BinaryTreeLevelOrderTraversal2 e = new E107_BinaryTreeLevelOrderTraversal2();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list = e.levelOrderBottom(bt);
        for (List<Integer> l : list) {
            for (Integer i : l) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void e104(){
        //String[] arr1 = {"1", "2", "2", "3", "4", "4", "3"};
        String[] arr1 = {"1"};
        TreeNode bt = new TreeNode();
        bt = CreateTreeByLayerOrder.LayerInsert(bt, arr1);

        E104_MaximumDepthOfBinaryTree e = new E104_MaximumDepthOfBinaryTree();
        System.out.println(e.maxDepth(bt));
    }

    @Test
    public void e101_SymmertricTree(){
        String[] arr1 = {"1", "2", "2", "3", "4", "4", "3"};
        TreeNode bt = new TreeNode();
        bt = CreateTreeByLayerOrder.LayerInsert(bt, arr1);

        E101_SymmetricTree e = new E101_SymmetricTree();
        System.out.println(e.isSymmetric(bt));

    }

    @Test
    public void E100_SameTree(){
/*        String[] arr = {"1", "null", "3", "4", "5"};
        CreateTreeByLayerOrder create = new CreateTreeByLayerOrder();
        TreeNode treeNode = new TreeNode();
        treeNode = create.LayerOrderInsert(treeNode, arr);
        create.LayerOrder(treeNode);*/

        String[] arr1 = {"1", "null", "2"};
        String[] arr2 = {"1", "2"};
        TreeNode bt1 = new TreeNode();
        TreeNode bt2 = new TreeNode();
        bt1 = CreateTreeByLayerOrder.LayerInsert(bt1, arr1);
        bt2 = CreateTreeByLayerOrder.LayerInsert(bt2, arr2);
        E100_SameTree e = new E100_SameTree();
        System.out.println(e.isSameTree(bt1, bt2));

    }

    @Test
    public void testTwoSum(){
        E001_TwoSum ts = new E001_TwoSum();

        int target = 9;
        int[] nums = {2, 7, 11, 15};

        int[] ans = ts.twoSum(nums, target);
        for (int a : ans) {
            System.out.println(a);
        }
    }

    @Test
    public void testReverse(){
        int[] v = {123, 120, -123, 200100};
        E007_ReverseInteger ri = new E007_ReverseInteger();
        for (int i = 0; i < v.length; i++) {
            System.out.println(ri.reverse(v[i]));
        }

    }

    @Test
    public void testRomanInterger(){
        E013_RomanToInteger ri = new E013_RomanToInteger();
        List<String> list = new ArrayList<String>();
        list.add("III");
        list.add("IV");
        list.add("IX");
        list.add("LVIII");
        list.add("MCMXCIV");
        for (String s : list) {
            //System.out.println(ri.romanToInt(s));
        }

        System.out.println(ri.romanToInt("MCMXCIV"));
    }


    @Test
    public void testLongestCommonPrefix(){
        E014_LongestCommonPrefix lcp = new E014_LongestCommonPrefix();
        //String[] strs = {"flower","flow","flight"};
        //String[] strs = {"dog","racecar","car"};
        //String[] strs = {};
        //String[] strs = {"","b"};
        String[] strs = {"aaa","aa","aaa"};
        String ans = lcp.longestCommonPrefix3(strs);
        System.out.println(ans);

    }

    @Test
    public void testValidParentheses(){
        E020_ValidParentheses vp = new E020_ValidParentheses();
        List<String> list = new ArrayList<String>();
        list.add("()");
        list.add("()[]{}");
        list.add("{[]}");
        list.add("{[](){}}");
        list.add("([)]");
        list.add("([)");
        list.add("(");
        list.add("]");
        for (String s : list) {
            System.out.println(vp.isValid(s));
        }
    }


    @Test
    public void testMergeTwoSortedLists(){
        ListNode list1 = null;
        ListNode list2 = null;
        ListNode cur1 = null;
        ListNode cur2 = null;

        list1 = new ListNode(1);
        cur1 = list1;
        cur1.next = new ListNode(2);
        cur1 = cur1.next;
        cur1.next = new ListNode(4);
        cur1 = cur1.next;

        list2 = new ListNode(1);
        cur2 = list2;
        cur2.next = new ListNode(3);
        cur2 = cur2.next;
        cur2.next = new ListNode(4);
        cur2 = cur2.next;




        E021_MergeTwoSortedLists merge = new E021_MergeTwoSortedLists();
        ListNode mlist = merge.mergeTwoLists(list1, list2);
        while(mlist != null){
            System.out.print(mlist.val);
            System.out.print(" -> ");
            mlist = mlist.next;
        }
        System.out.println();

    }

    @Test
    public void testRemoveDuplicates(){
        // int[] nums = {0, 0, 0, 1, 1, 2, 3, 4, 4, 4, 5};
        int[] nums = {};
        E026_RemoveDuplicatesfromSortedArray rd = new E026_RemoveDuplicatesfromSortedArray();
        System.out.println(rd.removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testRemoveElement(){
        // int[] nums = {0, 0, 0, 1, 1, 2, 3, 4, 4, 4, 5};
        // int[] nums = {};
        // int[] nums = {2};
        int[] nums = {1, 2, 1,2, 3, 3, 4, 2};
        E027_RemoveElement re = new E027_RemoveElement();
        System.out.println(re.removeElement2(nums, 2));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    @Test
    public void testImplementStrStr(){
        String str = "hello";
        String needle = "ll";
        E028_ImplementStrStr is = new E028_ImplementStrStr();
        System.out.println(is.strStr(str, needle));

    }

    @Test
    public void Search_Insert_Position(){
        int[] nums = {1, 3, 5, 9};
        int target = 11;
        E035_SearchInsertPosition sip = new E035_SearchInsertPosition();
        System.out.println(sip.searchInsert(nums, target));

    }

    @Test
    public void CountAndSay(){
        E038_CountAndSay cas = new E038_CountAndSay();
        int n = 6;
        System.out.println(cas.countAndSay(n));

    }

    @Test
    public void MaxSubArray(){
        E053_MaxSubArray msa = new E053_MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(msa.maxSubArray(nums));

    }


    @Test
    public void lengthOfLastWord(){
        // String sentence = "Hello World";
        // String sentence = "   ";
        String sentence = " Hello World ";
        E058_LengthOfLastWord lw = new E058_LengthOfLastWord();
        System.out.println(lw.lengthOfLastWord(sentence));
    }

    @Test
    public void lengthPlusOneOfLastWord(){
        E066_PlusOne po = new E066_PlusOne();
        int[] digits = {9, 9, 9};
        int[] nums = po.plusOne(digits);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    @Test
    public void AddBinary(){
        E067_AddBinary ab = new E067_AddBinary();
        System.out.println(ab.addBinary("111000", "1000"));
        System.out.println(ab.addBinary("101111", "10"));
    }

    @Test
    public void sqrtx(){
        E069_SqrtX sx = new E069_SqrtX();
        int[] a = {0, 1, 2, 3, 4, 5, 10, 100, 900, 1000};
        for(int i = 0; i < a.length; i++){
            System.out.println("a = "+a[i]+", sqrt = "+sx.mySqrt(a[i])+";");
        }
    }

    @Test
    public void climbingStairs(){
        E070_ClimbingStairs cs = new E070_ClimbingStairs();
        // int[] a = {1, 2, 3, 4, 5, 10, 100};
        int[] a = {6};
        for(int i = 0; i < a.length; i++){
            System.out.println("a = "+a[i]+", method = "+cs.climbStairs(a[i])+";");
        }
    }

    @Test
    public void testRemoveDuplicatesFromSortedList(){
        ListNode list1 = null;
        ListNode cur1 = null;

        // list1 = new ListNode(1);
        // cur1 = list1;
        // cur1.next = new ListNode(1);
        // cur1 = cur1.next;
        // cur1.next = new ListNode(2);
        // cur1 = cur1.next;
        // cur1.next = new ListNode(3);
        // cur1 = cur1.next;
        // cur1.next = new ListNode(4);
        // cur1 = cur1.next;
        // cur1.next = new ListNode(4);
        // cur1 = cur1.next;
        // cur1.next = new ListNode(4);
        // cur1 = cur1.next;
        // cur1.next = new ListNode(4);
        // cur1 = cur1.next;


        E083_RemoveDuplicatesFromSortedList rd = new E083_RemoveDuplicatesFromSortedList();
        ListNode mlist = rd.deleteDuplicates(list1);
        while(mlist != null){
            System.out.print(mlist.val);
            System.out.print(" ");
            mlist = mlist.next;
        }
        System.out.println();

    }


    @Test
    public void testMergeSortedArray(){
        int[] n1 = {0};
        int[] n2 = {2};
        E088_MergeSortedArray ms = new E088_MergeSortedArray();
        ms.merge(n1, 0, n2, 1);
        for (int i : n1) {
            System.out.print(i + " ");
        }

    }


}













