package giovani.nfestatusproj.nfestatus.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import giovani.nfestatusproj.nfestatus.services.DownloadNFEStatusSnapshotService;

@Component
public class DownloadNFEStatusJob {
	private static final long FIVE_MINUTES = 300000L;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DownloadNFEStatusSnapshotService downloadNFEStatusSnapshotService;
	
	@Scheduled(fixedRate = FIVE_MINUTES, initialDelay = 0)
	public void downloadNFEStatus() {
		logger.info("Running DownloadNFEStatusJob...");
		
		downloadNFEStatusSnapshotService.downloadNFEStatus();
		
		logger.info("DownloadNFEStatusJob has finished.");
	}
}
