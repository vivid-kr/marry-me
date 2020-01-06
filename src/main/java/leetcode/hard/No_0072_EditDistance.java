package leetcode.hard;

/**
 * TODO Time
 */
public class No_0072_EditDistance {

  public int minDistance(String word1, String word2) {
    if (word1.length() == 0 || word2.length() == 0) {
      return Math.max(word1.length(), word2.length());
    }
    int dist[][] = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      for (int j = 0; j <= word2.length(); j++) {
        if (i == 0) {
          dist[i][j] = j;
        } else if (j == 0) {
          dist[i][j] = i;
        } else {
          dist[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dist[i - 1][j - 1] : Math.min(
              dist[i - 1][j - 1], Math.min(dist[i - 1][j], dist[i][j - 1])) + 1;
        }
      }
    }
    return dist[word1.length()][word2.length()];
  }

  /**
   * 动态规划的思想。纵轴为word1，横轴为word2. 纵轴向下为删除word1，横行向右为增加word2的字母。如果i,j 位置word12相同，则直接右下，否则+1，为替换。
   *
   * Runtime: 5 ms, faster than 81.38% of Java online submissions for Edit Distance.
   *
   * Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Edit Distance.
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
    No_0072_EditDistance no = new No_0072_EditDistance();
    System.out.println(no.minDistance("horse", "ros"));
    System.out.println(no.minDistance("intention", "execution"));
  }
}

