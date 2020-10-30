package org.hustlebar.ospec.framework.core;

import io.swagger.v3.oas.models.responses.ApiResponse;
import org.hustlebar.ospec.framework.model.CResponse;
import org.hustlebar.ospec.framework.model.OComponent;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ResponseHandler {
    public Map<String, ApiResponse> handle(OComponent oComponent) {
        return _handle(oComponent);
    }

    private Map<String, ApiResponse> _handle(OComponent oComponent) {
        List<CResponse> cResponses = oComponent.responses();
        if (cResponses == null || cResponses.isEmpty()) {
            return null;
        }

        Map<String, ApiResponse> responses = new HashMap<>();
        for (CResponse cResponse: cResponses) {
            responses.put(cResponse.name(), getResponse(cResponse));
        }
        
        return responses;
    }

    private ApiResponse getResponse(CResponse cResponse) {
        return null;
    }
}
