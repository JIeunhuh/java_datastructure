package chap9_트리;

/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}

	public TreeNode(int data) {
		LeftChild = RightChild = null;
		this.data = data;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) { // node를 제거할때 마지막 leaf node?를 찾기 위함 ; 해당 리프노드를 제거할 노드에 대체 하기 위해서?
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) { // 리프노드 인지 확인(더이상 이어지는 노드가 없는지)
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() { // 중위순회
		inorder(root);
	}

	void preorder() { // 선위순회
		preorder(root);
	}

	void postorder() {// 후위순회
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode nd = new TreeNode(x);
		TreeNode p = root; // 현재 노드 ; root에서 내려감
		TreeNode q = null; // 이전노드?
		if (p == null) { // root == null일때 p값은 nd
			p = nd;
			return true;
		}
//		while (p != null) { // p가 !null일때
//			if (x < p.data) { // x가 p.data보다 작을때 -> 왼쪽노드로 내려감 ; p==root니까 root값을 기준으로 작은 값은 다 왼쪽, 큰 값은 오른쪽으로 감
//				q = p;
//				p = p.LeftChild;
//				return true;
//			} else if (x > p.data) { // x가 p.data보다 큰 경우
//				q = p;
//				p = p.RightChild;
//				return true;
//			}
//		}
//		return false;
//	} -> return문이 잘못됨 ; 각각 if블록내에 실행되고 있어서 if블록에서 실행되면 함수가 즉시 종료됨 -> while문 빠져나와서 실행
		while (p != null) {
			if (x < p.data) {
				q = p;
				p = p.LeftChild;
			} else if (x > p.data) {
				q = p;
				p = p.RightChild;
			} else {
				return false;
			}
		}
		if(x<q.data)
			q.LeftChild = nd;
		else
			q.RightChild = nd;
	}

	boolean delete(int num) { // node 삭제
		TreeNode p = root;
		TreeNode q = null;
		if (p != null) {// p가 null이 아닐때

		}
		return false;
	}

	boolean search(int num) { // node 존재 유무 검색
		return false;
	}
}

public class Chap9_Test_BinaryTreeInt {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		// TreeNode nd = new TreeNode();
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
					System.out.println("data insert");
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}
