package com.example.api.action.my;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MyForm {

  private final int dataId;
  private final HttpServletRequest request;
  private final HttpServletResponse response;

  private boolean isSuccess = true;

  public void setErrorStatusCode(int statusCode) throws IOException {
    response.sendError(statusCode);
  }
}
