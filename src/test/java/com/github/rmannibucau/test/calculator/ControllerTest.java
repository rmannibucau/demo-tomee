package com.github.rmannibucau.test.calculator;

import com.github.rmannibucau.calculator.Controller;
import com.github.rmannibucau.calculator.Operation;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.webapp30.WebAppDescriptor;
import org.jboss.shrinkwrap.descriptor.api.webcommon30.WebAppVersionType;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.faces.webapp.FacesServlet;
import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class ControllerTest {
    @Deployment
    public static WebArchive war() {
        return ShrinkWrap.create(WebArchive.class, "calculator.war")
                    .addPackages(true, Controller.class.getPackage())
                    .addAsWebInfResource(new StringAsset(
                            Descriptors.create(WebAppDescriptor.class)
                            .version(WebAppVersionType._3_0)
                            .createServlet()
                                .servletName(FacesServlet.class.getSimpleName())
                                .servletClass(FacesServlet.class.getName())
                                .loadOnStartup(1)
                            .up()
                            .createServletMapping()
                                .servletName(FacesServlet.class.getSimpleName())
                                .urlPattern("*.xhtml")
                            .up()
                            .exportAsString()), "web.xml")
                    .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    private Controller controller;

    @Test
    public void TenMinusSixShouldDoFour() {
        final Controller.Computation computation = controller.getComputation();
        computation.setNumber1(10);
        computation.setNumber2(6);
        computation.setOperation(Operation.MINUS);
        assertEquals(4, computation.getResult(), 0);
    }
}
