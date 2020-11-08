package giovani.nfestatusproj.nfestatus.database.eao.custom;

import java.util.List;

import giovani.nfestatusproj.nfestatus.database.entities.NFEStatusSnapshot;
import giovani.nfestatusproj.nfestatus.database.enums.EnumAuthorizer;
import giovani.nfestatusproj.nfestatus.database.enums.EnumNFEStatus;
import giovani.nfestatusproj.nfestatus.database.enums.EnumService;

public interface CustomNFEStatusSnapshotEAO {
	Long countByAuthorizerAndServiceStatus(EnumAuthorizer authorizer, EnumService service, List<EnumNFEStatus> status);
	
	NFEStatusSnapshot findLatestByAuthorizerAndServiceStatus(EnumAuthorizer authorizer, EnumService service, List<EnumNFEStatus> status);
}
