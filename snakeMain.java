package snake;

import java.util.ArrayList;
import java.util.Iterator;

import TreeSet.intCompare;

public class snakeMain {
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;

	// 思路：记录蛇头蛇头的两个点的状态,其中要确定蛇头运动方向
	public static void main(String[] args) {
		initSnake();
	}

	private static void initSnake() {
		ArrayList<Integer[]> arrayList = new ArrayList();
		int len = 4;
		int headDirection = RIGHT;
		int head2Direction = RIGHT;
		int rearDirection = RIGHT;
		int rear2Direction = RIGHT;
		arrayList.add(new Integer[] { 5, 5 });
		arrayList.add(new Integer[] { 4, 5 });
		arrayList.add(new Integer[] { 3, 5 });
		arrayList.add(new Integer[] { 2, 5 });
		
//		showSnake(arrayList);
//		move(arrayList, RIGHT);
//		showSnake(arrayList);
//		move(arrayList, RIGHT);
//		showSnake(arrayList);
//		move(arrayList, UP);
//		showSnake(arrayList);
//		move(arrayList, LEFT);
//		showSnake(arrayList);
//		move(arrayList, DOWN);
//		showSnake(arrayList);
		
       new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (!checkBump(arrayList)) {
				showSnake(arrayList);
				move(arrayList, RIGHT);
				showSnake(arrayList);
				move(arrayList, RIGHT);
				showSnake(arrayList);
				move(arrayList, RIGHT);
				showSnake(arrayList);
				move(arrayList, RIGHT);
				showSnake(arrayList);
				move(arrayList, UP);
				showSnake(arrayList);
				move(arrayList, UP);
				showSnake(arrayList);
				move(arrayList, UP);
				showSnake(arrayList);
				move(arrayList, LEFT);
				showSnake(arrayList);
				move(arrayList, DOWN);
				showSnake(arrayList);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}).start();
		
		

	}

	// 首先判断当前方向，如当前方向向右则不能向左转向
	private static void move(ArrayList<Integer[]> arrayList, int direction) {
		int currentDirection = judgeMove(arrayList);
		Integer[] integers = arrayList.get(0);
		int size = arrayList.size();
		switch (direction) {
		case RIGHT:
			if (currentDirection != LEFT) {
				arrayList.remove(size - 1);
				arrayList
						.add(0, new Integer[] { integers[0] + 1, integers[1] });
			}else {
				move(arrayList,currentDirection);
			}
			break;
		case LEFT:
			if (currentDirection != RIGHT) {
				arrayList.remove(size - 1);
				arrayList
						.add(0, new Integer[] { integers[0] - 1, integers[1] });
			}
			else {
				move(arrayList,currentDirection);
			}
			break;
		case UP:
			if (currentDirection != DOWN) {
				arrayList.remove(size - 1);
				arrayList
						.add(0, new Integer[] { integers[0], integers[1] + 1 });
			}else {
				move(arrayList,currentDirection);
			}
			break;
		case DOWN:
			if (currentDirection != UP) {
				arrayList.remove(size - 1);
				arrayList
						.add(0, new Integer[] { integers[0], integers[1] - 1 });
			}else {
				move(arrayList,currentDirection);
			}
			break;

		default:
			move(arrayList,currentDirection);
			break;
		}

	}

	// 判断第二的点到第一个点的方向
	private static int judgeMove(ArrayList<Integer[]> arrayList) {
		int size = arrayList.size();
		Integer[] thirdPos = arrayList.get(size - 2);
		Integer[] secondPos = arrayList.get(size - 1);
		int x1 = thirdPos[0];
		int y1 = thirdPos[1];
		int x2 = secondPos[0];
		int y2 = secondPos[1];
		if (x1 == x2 && y1 - y2 == 1) {
			return UP;
		} else if (x1 == x2 && y1 - y2 == -1) {
			return DOWN;
		} else if (y1 == y2 && x1 - x2 == 1) {
			return RIGHT;
		} else if (y1 == y2 && x1 - x2 == -1) {
			return LEFT;
		}
		return 0;

	}

	private static void showSnake(ArrayList<Integer[]> arrayList) {
		Iterator iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Integer[] integers = (Integer[]) iterator.next();
			System.out.print(integers[0] + "," + integers[1] + "  ");
		}
		System.out.println();
	}
	
	//碰撞检测
	private static boolean checkBump(ArrayList<Integer[]> arrayList) {
		Integer[] integers = arrayList.get(0);
		//检测是否咬到蛇身
		ArrayList<Integer []> tmpArrayList=arrayList;
		tmpArrayList.remove(0);
		if(tmpArrayList.contains(integers)){
			return true;
		}
		//检测是否撞到墙，假设墙30宽10高
		if(integers[0]>=30||integers[0]<=0||integers[1]<=0||integers[1]>=10){
			return true;
		}
		return false;
	}
}
