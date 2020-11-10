package giovani.nfestatusproj.nfestatus.utils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
	private ListUtils() {
		
	}
	
	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}
	
	public static <T> List<T> paginate(List<T> list, int page, int rows) {
		List<T> paginatedList = new ArrayList<T>();
		
		int offset = page == 0 ? 0 : rows / page;
		int end = (page == 0 ? 1 * rows : page * rows) - 1;
		
		if (offset < list.size()) {
			for (int idx = offset; idx < list.size() && idx < end; idx++) {
				paginatedList.add(list.get(idx));
			}
		}
		
		return paginatedList;
	}
	
	public static <T> T first(List<T> list) {
		if (list != null) {
			return list.stream().findFirst().orElse(null);
		}
		
		return null;
	}
} 
