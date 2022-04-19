package edu.fpdual.ejemplo.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses(PersonaTest.class)
@Suite
public class PersonaTests {
}
