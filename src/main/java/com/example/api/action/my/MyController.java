package com.example.api.action.my;

import com.example.api.common.logger.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MyController {

  private static final Logger logger = Logger.getLogger(MyController.class.getSimpleName());

  @Autowired private MyService service;

  /**
   * e.g. /api/my/2
   *
   * @param dataId
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @GetMapping({"/api/my/{dataId}"})
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String execute(
      @PathVariable("dataId") int dataId, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    MyForm form = new MyForm(dataId, request, response);
    try {
      return service.execute(form);
    } catch (Exception e) {
      logger.error("failed to execute service", e);
      throw e;
    }
  }

  /**
   * test e.g. /api/test/hello?sub_message=spring
   *
   * @param mainMessage
   * @param subMessage
   * @param request
   * @param response
   * @return
   * @throws Exception
   */
  @GetMapping({"/api/test/{main_message}"})
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public String test(
      @PathVariable("main_message") String mainMessage,
      @RequestParam(value = "sub", defaultValue = "world") String subMessage,
      HttpServletRequest request,
      HttpServletResponse response)
      throws Exception {
    System.out.println("sub message -> " + subMessage);
    return mainMessage + " " + subMessage;
  }
}
