package leetcode.all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * TODO Time
 */
public class No_0502_IPO {

  public static class Node {

    int prof;
    int need;

    public Node(int p, int n) {
      this.prof = p;
      this.need = n;
    }
  }

  public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    int n = Profits.length;
    List<Node> projs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      projs.add(new Node(Profits[i], Capital[i]));
    }
    Collections.sort(projs, (a, b) -> {
      return a.need - b.need;
    });
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

    int w = W;
    int idx = 0;
    while (k > 0) {
      for (; idx < n && w >= projs.get(idx).need; idx++) {
        pq.add(projs.get(idx).prof);
      }
      if (pq.size() != 0) {
        w += pq.poll();
      } else {
        break;
      }
      k--;
    }
    return w;
  }

  /**
   * Runtime: 30 ms, faster than 73.55% of Java online submissions for IPO.
   *
   * Memory Usage: 45.9 MB, less than 66.67% of Java online submissions for IPO.
   *
   * 0次调试错误，然后成功。借鉴leetcode
   *
   * 错误：
   *
   * 1错：
   *
   * 2错：
   *
   * 一句话反思：
   *
   * 新知识：
   */


  public static void main(String[] args) {
    String expect = "PAHNAPLSIIGYIR";
    int actual = findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});

    System.out.println(actual);
    System.out.println(actual == 4);
  }
}

