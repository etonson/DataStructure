package stack.applications;
import static java.lang.System.*;

//老鼠走迷宮
public class MouseWalkingMaze {
 public static void main(String[] args) {
  //二維陣列，「1」表示牆，無路；「0」表示可行走的路
		int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			   	 { 1, 0, 1, 0, 1, 0, 0, 0, 0, 1 },
			     { 1, 0, 1, 0, 1, 0, 1, 1, 0, 1 }, 
			     { 1, 0, 1, 0, 1, 0, 1, 1, 0, 1 }, 
			     { 1, 0, 1, 0, 0, 0, 1, 1, 0, 1 },
			     { 1, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, 
			     { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    out.println("老鼠走迷宮的路徑");
    findPath(maze, 1, 1);
    System.out.println(findPath(maze, 1, 1));
    Visited(maze);
 }

//定義靜態方法，輸出陣列內容
 public static void Visited(int[][] ary){
    for(int j = 0; j < ary.length; j++){
       for(int k = 0; k < ary[j].length; k++)
          out.printf("%3d", ary[j][k]);
       out.println();
    }
 }

 //定義靜態方法FindPath()，老鼠走迷宮的路徑
 public static boolean findPath(int[][] ary, int X, int Y){
    //記錄移動的座標X, Y
    out.printf("移動，X = %d, Y = %d%n", X, Y);
    //輸出迷宮(二維陣列)
    Visited(ary);
    out.println("--------------------------------");

	// 超出二維陣列範圍或陣列的元素為1的話予以忽略
	if (X >= 7 || Y >= 10) {
		return false;
	}

	if (ary[X][Y] == 1) {
		return false;
	}

	// 將可行走過的路以「2」標示
	if (ary[X][Y] == 0) {
		ary[X][Y] = 2;
	}
	if (ary[X][Y] == 2 && (X ==  6 && Y == 8)) {
		return true;
	}
	// 向左
	// 開始位置(X = 1, Y = 1)，結束位置(X = 5, Y = 8)取得可走路徑
	if (Y < 8 && ary[X][Y + 1] == 0) {
		// 向右
		if (findPath(ary, X, Y + 1)) {
			out.printf("移動，X = %d, Y = %d%n", X, Y+1);
			return true;
		}
	}
	
	if (X < 5 && ary[X + 1][Y] == 0)
		// 向下
		if (findPath(ary, X + 1, Y)) {
			out.printf("移動，X = %d, Y = %d%n", X+1, Y);
			return true;
		}

	if (Y > 0 && ary[X][Y - 1] == 0)
		// 向左
		if (findPath(ary, X, Y - 1)) {
			out.printf("移動，X = %d, Y = %d%n", X, Y-1);
			return true;
		}

	if (X > 0 && ary[X - 1][Y] == 0)
		// 向上
		if (findPath(ary, X - 1, Y)) {
			out.printf("移動，X = %d, Y = %d%n", X-1, Y);
			return true;
		}
	return false;
 }
}
