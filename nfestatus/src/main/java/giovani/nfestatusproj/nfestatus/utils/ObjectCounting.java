package giovani.nfestatusproj.nfestatus.utils;

public class ObjectCounting<T> implements Comparable<ObjectCounting<T>> {
	private final T object;
	private Long count;
	
	public ObjectCounting(T object, Long count) {
		this.object = object;
		this.count = count;
	}
	
	public T getObject() {
		return object;
	}
	
	public Long getCount() {
		return count;
	}
	
	public void add(Long addQuantity) {
		this.count += addQuantity;
	}

	@Override
	public int compareTo(ObjectCounting<T> o) {
		if (o.getCount() > this.getCount()) {
			return 1;
		}
		
		else if (o.getCount() < this.getCount()) {
			return -1;
		}
		
		return 0;
	}
}