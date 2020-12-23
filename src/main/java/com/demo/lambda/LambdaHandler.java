package com.demo.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.demo.lambda.utils.Request;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LambdaHandler implements RequestHandler<Object, Map<String, String>> {

  private static LambdaLogger logger = null;
  @Override
  public Map<String, String> handleRequest(Object input, Context context) {
    logger = context.getLogger();
    logger.log("Inside lambda handler with input "+ input);
    // Map received input to custom Request
    ObjectMapper mapper = new ObjectMapper();
    Request requestPayload;
    Map<String, String> response = new HashMap<>();
    try{
      requestPayload = mapper.readValue(mapper.writeValueAsString(input), Request.class);
      logger.log("Printing Requestpayload "+ requestPayload.toString());

      //Create a sample response
      response.put("greeting", "Hola!! "+requestPayload.getFirstName()+" "+requestPayload.getLastName());
      response.put("status", "OK");
      logger.log("Response built successfully "+ response);
      return response;

    } catch (JsonParseException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.log("Something went wrong while request execution...");
    return response;
  }
}
