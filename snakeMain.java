package snake;

import java.util.ArrayList;
import java.util.Iterator;

import TreeSet.intCompare;

public class snakeMain {
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;

	// ˼·����¼��ͷ��ͷ���������״̬,����Ҫȷ����ͷ�˶�����
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

	// �����жϵ�ǰ�����統ǰ����������������ת��
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

	// �жϵڶ��ĵ㵽��һ����ķ���
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
	
	//��ײ���
	private static boolean checkBump(ArrayList<Integer[]> arrayList) {
		Integer[] integers = arrayList.get(0);
		//����Ƿ�ҧ������
		ArrayList<Integer []> tmpArrayList=arrayList;
		tmpArrayList.remove(0);
		if(tmpArrayList.contains(integers)){
			return true;
		}
		//����Ƿ�ײ��ǽ������ǽ30��10��
		if(integers[0]>=30||integers[0]<=0||integers[1]<=0||integers[1]>=10){
			return true;
		}
		return false;
	}
}
