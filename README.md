# DataStructuresAndAlgorithms
#### 数据结构与算法的知识点demo，剑指offer题库刷题，以及leetcode的刷题记录
## 剑指offer
### 36. 两个链表的第一个公共节点
问题描述  
输入两个链表，找出它们的第一个公共结点。  
解题思路  
如果两个链表有公共节点，那么最后一个节点必然是公共节点，因此可以从最后一个公共节点向前找：先将俩链表压入栈，然后同时出栈，直到找到第一个公共节点结束。
