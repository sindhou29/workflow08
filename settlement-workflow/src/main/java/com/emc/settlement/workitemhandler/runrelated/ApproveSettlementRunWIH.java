package com.emc.settlement.workitemhandler.runrelated;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import com.emc.drcap.penalty.model.bc.am.common.PenaltyService_Service;
import com.emc.settlement.backend.runrelated.ApproveSettlementRun;
import com.emc.settlement.config.ContextInitializer;
import com.emc.settlement.model.backend.exceptions.AuthorisationException;
import com.emc.settlement.model.backend.pojo.SettlementRunInfo;
import com.emc.settlement.model.backend.service.task.runrelated.ApproveSettlementRunTask;

//@Component
public class ApproveSettlementRunWIH implements WorkItemHandler {
	private static final Logger logger = Logger.getLogger(ApproveSettlementRunWIH.class);


	/*@Autowired
	private SaveMSSLMeteringFile saveMSSLMeteringFile;*/

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		logger.info("START === WorkItemHandler : ApproveSettlementRunWIH");
		Map<String, Object> variableMap = new HashMap<String, Object>();

		String operationPath = (String) workItem.getParameter("Operation");
		String authorisation = (String) workItem.getParameter("authorisation");
		String packageId = (String) workItem.getParameter("packageId");
		String username = (String) workItem.getParameter("username");
		SettlementRunInfo runInfo = (SettlementRunInfo) workItem.getParameter("runInfo");
		AuthorisationException exception = (AuthorisationException) workItem.getParameter("exception");

		variableMap.put("authorisation", authorisation);
		variableMap.put("packageId", packageId);
		variableMap.put("username", username);
		variableMap.put("runInfo", runInfo);
		variableMap.put("exception", exception);
		logger.info("WorkItemHandler : ApproveSettlementRunWIH : variableMap : "+variableMap.toString());
		logger.info("END === WorkItemHandler : ApproveSettlementRunWIH");
		//variableMap = ContextInitializer.getInstance().invokeApproveSettlementRun(variableMap, operationPath);

		//manager.completeWorkItem(workItem.getId(), variableMap);
	}

}
