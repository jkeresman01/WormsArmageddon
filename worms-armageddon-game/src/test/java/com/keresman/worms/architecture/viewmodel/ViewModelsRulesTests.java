package com.keresman.worms.architecture.viewmodel;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.lang.reflect.Modifier;
import java.util.Set;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.keresman.worms.viewmodel")
public class ViewModelsRulesTests {
    @ArchTest
    static final ArchRule viewmodels_should_prohibit_inheritance =
            classes()
                    .that()
                    .resideInAPackage("..viewmodel..")
                    .should(beDeclaredFinal())
                    .because("Classes should be designed for inheritance or else prohibit");

    @ArchTest
    static final ArchRule viewmodels_should_encapsulate_fields =
            classes()
                    .that()
                    .resideInAPackage("..viewmodel..")
                    .should(encapsulateFields())
                    .because("View models should encapsulate fields");

    private static ArchCondition<JavaClass> beDeclaredFinal() {
        return new ArchCondition<>("be declared final") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                Set<JavaModifier> modifiers = javaClass.getModifiers();
                if (modifiers.contains(Modifier.FINAL)) {
                    String message = javaClass.getName() + " should be declared final";
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

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
