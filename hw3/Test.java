import java.util.*;

class Test {



	public static void main(String[] args) {
		SListNode obj1 = new SListNode(12345);
		//SListNode cur = obj1;
		SListNode obj2 = new SListNode(123456);

		if(obj1.item.equals(obj2.item)){
    		System.out.println("object1 and object2 are ture in .equal");
		}else {
			System.out.println("object1 and object2 are NOT ture in .equal");
		}
		/**
		 * Make sure you add up obj1.item to the comparison, because obj1.equals(obj2) 	
		 * You compare the reference, no matter what type, what's the value inside obj,
		 * They won't be the same which means always return false. On the contrary, if 
		 * you use expression above, you get correct result as you want.
		 **/
	}

}