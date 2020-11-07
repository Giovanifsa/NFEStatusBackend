CREATE TABLE NFEStatusSnapshot (
	idNFEStatusSnapshot 			BIGINT 		NOT NULL AUTO_INCREMENT PRIMARY KEY,
	captureMoment 					TIMESTAMP 	NOT NULL,
	authorizer 						BIGINT 		NOT NULL,
	nfeStatusAuthorization4 		BIGINT 		NOT NULL,
	nfeStatusAuthorization4Return 	BIGINT 		NOT NULL,
	nfeStatusInutilisation4 		BIGINT 		NOT NULL,
	nfeStatusProtocol4Query 		BIGINT 		NOT NULL,
	nfeStatusService4Status 		BIGINT 		NOT NULL,
	averageTimeMilis 				BIGINT 		NULL,
	nfeStatusRegister4Query 		BIGINT 		NOT NULL,
	nfeStatusEvent4Reception 		BIGINT 		NOT NULL
);