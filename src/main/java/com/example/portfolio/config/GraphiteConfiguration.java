package com.example.portfolio.config;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;

@Configuration
public class GraphiteConfiguration {

    @Bean
    public MetricRegistry metricRegistry() {
        return new MetricRegistry();
    }

    @Bean
    public GraphiteReporter graphiteReporter(MetricRegistry metricRegistry) {
        Graphite graphite = new Graphite(
                new InetSocketAddress("172.19.0.3", 2003));

        GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
                .prefixedWith("portfolio")
                .build(graphite);

        reporter.start(10, TimeUnit.SECONDS);

        return reporter;
    }

}