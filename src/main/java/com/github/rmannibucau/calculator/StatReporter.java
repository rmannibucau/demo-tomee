package com.github.rmannibucau.calculator;

import org.apache.deltaspike.core.api.jmx.annotation.JmxManaged;
import org.apache.deltaspike.core.api.jmx.annotation.MBean;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@MBean(description = "stat of computation")
@ApplicationScoped
public class StatReporter implements Serializable {
    @JmxManaged(description = "number of computation")
    private AtomicLong total = new AtomicLong(0);

    public long getTotal() {
        return total.longValue();
    }

    public long incComputations() {
        return total.incrementAndGet();
    }
}
