b vg# Algorithm_Practice
# 다시 시작하는 알고리즘 공부 
다양한 알고리즘 풀이 / Solving to algorithm problem

사용하는 알고리즘 풀이 사이트 목록
==================================

https://www.acmicpc.net/ : 백준   
https://programmers.co.kr/ : 프로그래머스  
https://leetcode.com/ : LeetCode   


***
**네트워크(프로그래머스 문제)**

**[소스 보러가기](https://github.com/leeking68/Algorithm_Practice/blob/master/programmers/DFSBFS_Network.java)**  
**[문제 보러가기](https://programmers.co.kr/learn/courses/30/lessons/43162)**

---

**사용한 알고리즘 및 자료구조**  
DFS/BFS, 그래프

**풀이**

간단한 DFS/BFS 문제이다. 문제를 푸는데 20분도 안 걸렸다. 이번에는 DFS를 이용해서 해당 문제를 풀었다. 이 문제를 읽고 생각을 했던 것은 2차원 배열에서 (n,n) 칸들을 기준으로 좌우 대칭이 된다는 것이다. 또한 각각의 값들이 연결관계를 표현했다. 따라서 처음에 탐색할 때는 1/2만 탐색을 하고 DFS 를 사용할 때는 연결관계를 기준으로 탐색을 하면 된다. 보통의 DFS 문제는 ‘상하좌우’로 움직이면서 문제를 해결했지만, 해당 문제는 배열의 값들이 내포하고 있는 연결관계를 이용해서 DFS 함수를 구현했다.

1.  초기화
2.  문제에 해당하는 조건( 배열의 값 : 1 && 아직 탐색하지 않은 칸) 찾기 ,조건을 찾을 때 마다 answer++
3.  조건 찾고 나서 DFS 함수를 이용해 연결관계를 따라 영역표시하기
4.  다시 2-3번 반복
5.  Answer 출력

간단한 DFS 문제이다. 실제로 삼성 시험을 봤던 사람들에게는 매우 쉬웠을 거라 생각한다. 다만 이것을 어떻게 해야 더 효율적으로 구현할 수 있을까 고민해보았다. 간단한 문제라 특별하게 적용할 것은 없었으나, 그래도 고민 해보면 좋을 것이다.
