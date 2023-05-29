package com.maras.springtestharness.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {HarnessContextConfiguration.class})
@SpringBootTest
public class HarnessAbstractTestDefinition {
}
