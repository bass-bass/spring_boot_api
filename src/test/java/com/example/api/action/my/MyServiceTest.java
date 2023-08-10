package com.example.api.action.my;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.example.api.common.data.MyData;

public class MyServiceTest {
	@Test
	public void test() {
		MyData mockData = Mockito.mock(MyData.class);
		Mockito.when(mockData.getById(5)).thenReturn(new MyData.ProcessedData(5, "test"));
		MyService service = new MyService();
		ReflectionTestUtils.setField(service, "myData", mockData, MyData.class);
		MyForm mockForm = Mockito.mock(MyForm.class);
		Mockito.when(mockForm.getDataId()).thenReturn(5);
		String result = service.execute(mockForm);
		System.out.println(result);
	}
}
