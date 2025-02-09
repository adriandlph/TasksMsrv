
package com.adriandlph.tasksmsrv.controller;

import com.adriandlph.msrv.data.model.Response;
import com.adriandlph.tasksmsrv.App;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adriandlph
 *
 */
@RestController
@RequestMapping(path = App.BASE_PATH)
public class TasksController {
	
	@RequestMapping(path = "helloWorld")
	public Response<String> helloWorld() {
		return Response.Ok("Hello world!");
	}
	
}
