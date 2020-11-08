package giovani.nfestatusproj.nfestatus.utils;

import java.util.ArrayList;
import java.util.List;

public class ObjectCounter<T> {
	private List<ObjectCounting<T>> counter = new ArrayList<>();
	
	public void count(T object, Long addQuantity) {
		int index = counter.indexOf(object);
		
		if (index == -1) {
			counter.add(new ObjectCounting<T>(object, addQuantity));
		}
		
		else {
			counter.get(index).add(addQuantity);
		}
	}
	
	public ObjectCounting<T> getMostCounted() {
		return counter.stream()
				.sorted()
				.findFirst().orElse(null);
	}
}
