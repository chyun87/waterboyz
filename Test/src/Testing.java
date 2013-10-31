
public class Testing {

	public Integer findSmallestNumber(Integer[] numbers){
		Integer smallest = null;
		for (int i =0; i<numbers.length; i++){
			if(smallest > numbers[i]) smallest = numbers[i];
		}
		
		return smallest;
	}
	public static void main(String[] args){
		
		System.out.println("Hello World");
		
		//Code revision added:
		
		System.out.println("2nd iphone");
		
	}
	
	//Add method here
	public void testMethod(){
		//More code here
	}
}
