package leetcode.all;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * TODO Time
 */
public class No_0874_WalkingRobotSimulation {

  public int robotSim(int[] commands, int[][] obstacles) {
    Map<Integer, TreeSet<Integer>> Xcord = new HashMap<>();
    Map<Integer,TreeSet<Integer>> Ycord = new HashMap<>();
    int max = 0;
    for(int[] pos: obstacles) {
      TreeSet<Integer> setX = Xcord.getOrDefault(pos[0],new TreeSet<>());
      setX.add(pos[1]);
      Xcord.put(pos[0],setX);
      TreeSet<Integer> setY = Ycord.getOrDefault(pos[1],new TreeSet<>());
      setY.add(pos[0]);
      Ycord.put(pos[1],setY);
    }
    int index = 0;
    int x = 0;
    int y = 0;
    for(int d: commands) {
      if(d == -1) {
        index = (index + 1) % 4;
      }else if(d == -2) {
        index = (index + 3) % 4;
      }else {
        switch(index) {
          case 0:
            Integer miny = Xcord.getOrDefault(x,new TreeSet<>()).higher(y);
            if(miny != null) y = Math.min(miny-1,y+d);
            else y = y+d;
            break;
          case 1:
            Integer minx = Ycord.getOrDefault(y,new TreeSet<>()).higher(x);
            if(minx != null) x = Math.min(x+d,minx-1);
            else x = x+d;
            break;
          case 2:
            Integer maxy = Xcord.getOrDefault(x,new TreeSet<>()).lower(y);
            if(maxy != null) y = Math.max(y-d,maxy+1);
            else y = y-d;
            break;
          case 3:
            Integer maxx = Ycord.getOrDefault(y,new TreeSet<>()).lower(x);
            if(maxx != null) x = Math.max(x-d,maxx+1);
            else x = x-d;
            break;
        }
        max = Math.max(max,x*x+y*y);
      }
    }
    return max;
  }

  /**
   * Runtime: Memory Usage:
   *
   * 差评太多 https://leetcode.com/problems/walking-robot-simulation/discuss/180956/Java-Solution-Using-TreeSet
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
    No_0874_WalkingRobotSimulation no = new No_0874_WalkingRobotSimulation();

    System.out.println(no);
  }
}

