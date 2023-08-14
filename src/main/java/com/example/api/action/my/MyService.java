package com.example.api.action.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.common.data.MyData;
import com.example.api.common.logger.Logger;
import com.google.gson.Gson;

@Service
public class MyService {
  private final Logger logger = Logger.getLogger(MyService.class.getSimpleName());

  @Autowired private MyData myData;

  public String execute(MyForm form) {

    int dataId = form.getDataId();

    MyResult result = new MyResult();
    result.setData(this.myData.getById(dataId));

    String json = new Gson().toJson(result);

    logger.info(json);

    return json;
  }
}
