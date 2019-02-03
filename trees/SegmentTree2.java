package trees;

class SegmentTree2 {

  public static void main(String[] args) {

    int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16 };
    int[] st = new int[2 * arr.length - 1];
    int sum = buildST(arr, st, 0, 0, arr.length - 1);
    System.out.println(getSum(st, 0, 0, arr.length - 1, 6, 7));
    updateST(st, 0, 0, arr.length - 1, 7, 2);
    System.out.println(getSum(st, 0, 0, arr.length - 1, 6, 7));

  }

  public static int getMid(int l, int r) {
    return (l + r) / 2;
  }

  public static int buildST(int[] arr, int[] st, int index, int l, int r) {
    if (l >= r) {
      st[index] = arr[l];
      return st[index];
    }

    int mid = getMid(l, r);
    st[index] = buildST(arr, st, 2 * index + 1, l, mid) + buildST(arr, st, 2 * index + 2, mid + 1, r);
    return st[index];
  }

  public static int getSum(int[] st, int index, int l, int r, int q_l, int q_r) {
    if (q_l <= l && q_r >= r)
      return st[index];
    if (q_l > r || q_r < l)
      return 0;

    int mid = getMid(l, r);
    return getSum(st, 2 * index + 1, l, mid, q_l, q_r) + getSum(st, 2 * index + 2, mid + 1, r, q_l, q_r);
  }

  public static void updateST(int[] st, int index, int l, int r, int u_index, int diff) {

    if (u_index < l || u_index > r)
      return;
    st[index] = st[index] + diff;
    int mid = getMid(l, r);
    if (l != r) {
      updateST(st, 2 * index + 1, l, mid, u_index, diff);
      updateST(st, 2 * index + 2, mid + 1, r, u_index, diff);
    }

  }
}