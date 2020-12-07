import java.util.ArrayList;
import java.util.List;

public class BoxDemoArrayList {
	public static<U> void addBox(U u,List<Box<U>> boxes) {
		Box<U> box = new Box<U>(u);
	    box.set(u);
	    boxes.add(box);
	}
	 public static <U> void outputBoxes(List<Box<U>> boxes) {
		    int counter = 0;
		    for (Box<U> box: boxes) {
		      U boxContents = box.get();
		      System.out.println("Box #" + counter + " contains [" +boxContents.toString() + "]");
		      counter++;
		    }
		  }

	public static void main(String[] args) {
		 List<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
		 BoxDemoArrayList.<Integer>addBox(10, listOfIntegerBoxes);
		 
		 BoxDemoArrayList.addBox(Integer.valueOf(20), listOfIntegerBoxes);
		 BoxDemoArrayList.addBox(Integer.valueOf(30), listOfIntegerBoxes);
		 BoxDemoArrayList.outputBoxes(listOfIntegerBoxes);

	}

}
