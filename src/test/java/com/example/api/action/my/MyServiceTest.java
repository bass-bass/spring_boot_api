package com.example.api.action.my;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.api.common.data.MyData;
import com.example.api.common.logger.Logger;

public class MyServiceTest {
	@Test
	public void test() {
		// setup MyData mock
		MyData mockData = Mockito.mock(MyData.class);
		Mockito.when(mockData.getById(5)).thenReturn(new MyData.ProcessedData(5, "test"));

		MyService service = new MyService();
		// set field mock of MyService
		ReflectionTestUtils.setField(service, "logger", Mockito.mock(Logger.class), Logger.class);
		ReflectionTestUtils.setField(service, "myData", mockData, MyData.class);

		// setup MyForm mock
		MyForm mockForm = Mockito.mock(MyForm.class);
		Mockito.when(mockForm.getDataId()).thenReturn(5);

		// test MyService.execute
		String result = service.execute(mockForm);
		Assertions.assertEquals("{\"data\":{\"dataId\":5,\"value\":\"test\"}}", result);
	}
}
