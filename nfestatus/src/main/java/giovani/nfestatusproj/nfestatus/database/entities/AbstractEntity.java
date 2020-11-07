package giovani.nfestatusproj.nfestatus.database.entities;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1533692970612977860L;

	@Override
	public boolean equals(Object obj) {
		var superclass = getClass();
		
		if (obj != null) {
			if (superclass.isInstance(obj)) {
				AbstractEntity objEntity = (AbstractEntity) obj;
				
				return objEntity.getId().equals(getId());
			}
		}
		
		return false;
	}
	
	public abstract Long getId();
}
