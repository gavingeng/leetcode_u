##4sum
```

基本的ksum逻辑，排序、左右夹逼
4sum中遇到的问题:
1. 本来想通过一层i的循环来做处理，结果无法实现，采用i,j两层循环来处理;
2. 重复数的判断，处理了半天，在每种case中处理完，新的case就会有问题，
   参考了https://soulmachine.gitbooks.io/algorithm-essentials/java/linear-list/array/4sum.html
   在相等的判断后，分别k++ m-- ,再做一次重复判断,这样来处理

link
https://leetcode.com/problems/4sum/description/


```