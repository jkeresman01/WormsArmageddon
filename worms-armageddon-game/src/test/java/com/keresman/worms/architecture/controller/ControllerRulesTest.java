package com.keresman.worms.architecture.controller;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Set;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.keresman.worms.controller")
public class ControllerRulesTest {

    @ArchTest
    static final ArchRule controllers_should_end_in_controller =
            classes()
                    .that()
                    .resideInAPackage("..controller..")
                    .should()
                    .haveSimpleNameEndingWith("Controller")
                    .because("Controllers should end in controller");


    @ArchTest
    static final ArchRule controllers_should_encapsulate_fields =
            classes()
                    .that()
                    .resideInAPackage("..controller..")
                    .should(encapsulateFields())
                    .because("Controllers should encapsulate fields");

    private static ArchCondition<JavaClass> encapsulateFields() {
        return new ArchCondition<>("have only private fields") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                Set<JavaField> fields = javaClass.getAllFields();

                fields.forEach(field -> {
                    if (!field.getModifiers().contains(JavaModifier.PRIVATE)) {
                        String message =
                                "Field '%s' in class %s should be private but is %s".formatted(
                                field.getName(),
                                javaClass.getName(),
                                field.getModifiers()
                        );
                        events.add(SimpleConditionEvent.violated(field, message));
                    }
                });
            }
        };
    }
}
