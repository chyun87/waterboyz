
public class Testing {

	public Integer findSmallestNumber(Integer[] numbers){
		Integer smallest = null;
		for (int i =0; i<numbers.length; i++){
			if(smallest > numbers[i]) smallest = numbers[i];
		}
		
		return smallest;
	}
	public static void main(String[] args){
		
	}
}
