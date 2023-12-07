package com.service.impl;

import com.dto.LabWorkDto;
import com.dto.LabWorkListDTO;
import com.service.LabWorkService;
import org.jboss.ejb3.annotation.Pool;

import javax.ejb.Stateless;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Pool(value = "labWorkServicePool")
public class LabWorkServiceImpl implements LabWorkService {
    private Client client;
    private final String mainServiceUrl = "http://haproxy:10000";

    public LabWorkDto increaseStepsCount(Integer id, Integer stepsCount) {
        String url = mainServiceUrl + "/labworks/" + id + "/difficulty/increase/" + stepsCount;
        try {
            client = ClientBuilder.newClient();

            Response response = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get();
            LabWorkDto lb = response.readEntity(LabWorkDto.class);

            client.close();
            return lb;

        } catch (ProcessingException e) {
            client.close();
            return null;
        }
    }

    public List<LabWorkDto> makeHardcore(Integer id) {
        String url = mainServiceUrl + "/labworks/discipline/" + id + "/make-hardcore";
        try {
            client = ClientBuilder.newClient();

            LabWorkListDTO response = client.target(url).request(MediaType.APPLICATION_JSON_TYPE).get(LabWorkListDTO.class);
            client.close();

            return response.getLabWorkResponseDtos();

        } catch (ProcessingException e) {
            client.close();
            return null;
        }
    }

}
