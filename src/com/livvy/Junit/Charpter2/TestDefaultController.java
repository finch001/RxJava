package com.livvy.Junit.Charpter2;

import com.livvy.Junit.Charpter2.DefaultController.DefaultController;
import com.livvy.Junit.Charpter2.DefaultController.ErrorResponse;
import com.livvy.Junit.Charpter2.Interface.Request;
import com.livvy.Junit.Charpter2.Interface.RequestHandler;
import com.livvy.Junit.Charpter2.Interface.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class TestDefaultController {
    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    @Before
    public void instantiate() throws Exception {
        request = new SampleRequest();
        handler = new SampleHandler();
        controller = new DefaultController();
    }
//
//    @Test
//    public void testMethod() {
//        throw new RuntimeException("implement me");
//    }

    private class SampleRequest implements Request {
        public String getName() {
            return "Test";
        }
    }

    private class SampleHandler implements RequestHandler {
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
        private static final String NAME = "Test";

        @Override
        public String getName() {
            return NAME;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            if (obj instanceof SampleResponse) {
                result = ((SampleResponse) obj).getName().equals(getName());
            }
            return result;
        }

        @Override
        public int hashCode() {
            return NAME.hashCode();
        }
    }

    private class SampleExceptionHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }

    @Test
    public void testAddHandler() {

        controller.addHandler(request, handler);
        RequestHandler handler2 = controller.getHandler(request);
        Assert.assertNotNull("", handler);
        Assert.assertNotNull("", handler2);
        Assert.assertSame("this handler is the same with handler2", handler, handler2);
    }

    @Test
    public void testMethodNull() {
        Request request = new SampleRequest();
        Assert.assertNotNull("this object must no null", request);
    }

    @Test
    public void testProcessRequest() {
        Response response = controller.processRequest(request);

        Assert.assertNotNull("must return no null response", response);
        Assert.assertEquals(new SampleResponse(), response);
    }

    @Test
    public void testProcessRequestErrorResponse() {
        SampleRequest sampleRequest = new SampleRequest();
        SampleExceptionHandler sampleExceptionHandler = new SampleExceptionHandler();

        controller.addHandler(sampleRequest, sampleExceptionHandler);

        Response response = controller.processRequest(sampleRequest);
        Assert.assertNotNull("Must not return a null object", response);
        Assert.assertEquals(ErrorResponse.class, response.getClass());

    }
    //这也是一个判断注视
    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest();

        //The following line is supposed to throw a RuntimeException
        controller.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();

        // The following line is supposed to throw a RuntimeException
        controller.addHandler(request, handler);
    }

}
