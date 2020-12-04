package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Time
 */
public class No_0133_CloneGraph {

  static class Node {

    public int val;
    public List<Node> neighbors;

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public void addNeighbors(Node... nodes) {
      neighbors.addAll(Arrays.asList(nodes));
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(String.format("{%d}-[", val));
      for (Node neighbor : neighbors) {
        sb.append(neighbor.val).append(",");
      }
      sb.append("]");
      return sb.toString();
    }
  }

  public Node cloneGraph(Node node) {
    if(node == null)
      return null;
    Map<Node, Node> nodeMap = new HashMap<>();
    cloneGraphSub(node, nodeMap);
    return nodeMap.get(node);
  }

  private void cloneGraphSub(Node node, Map<Node, Node> nodeMap) {
    // add node
    Node copyNode = new Node(node.val, new ArrayList<>());
    nodeMap.put(node, copyNode);
    for (Node neighbor : node.neighbors) {
      if (!nodeMap.containsKey(neighbor)) {
        cloneGraphSub(neighbor, nodeMap);
      }
      copyNode.neighbors.add(nodeMap.get(neighbor));
    }
  }

  /**
   * Runtime:
   *
   * Memory Usage:
   *
   * 次调试错误，然后成功。
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
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    n1.addNeighbors(n2,n4);
    n2.addNeighbors(n1,n3);
    n3.addNeighbors(n2,n4);
    n4.addNeighbors(n1,n3);

    Node res = (new No_0133_CloneGraph()).cloneGraph(n1);
    System.out.println(res);
  }
}

