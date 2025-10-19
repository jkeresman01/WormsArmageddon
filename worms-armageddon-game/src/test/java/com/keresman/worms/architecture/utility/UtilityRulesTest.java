package com.keresman.worms.architecture.utility;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaConstructor;
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

@AnalyzeClasses(packages = "com.keresman.worms.utility")
public class UtilityRulesTest {

    @ArchTest
    static final ArchRule utility_classes_should_be_final =
            classes()
                    .that()
                    .resideInAPackage("..utility..")
                    .should(beDeclaredFinal())
                    .because("utility classes are not meant to be extended");

    @ArchTest
    static final ArchRule utility_classes_should_have_private_constructor =
            classes()
                    .that()
                    .resideInAPackage("..utility..")
                    .should(havePrivateNoArgsConstructor())
                    .because("utility classes should not be instantiated");

    @ArchTest
    static final ArchRule utility_classes_should_end_with_utils =
            classes()
                    .that()
                    .resideInAPackage("..utility..")
                    .should()
                    .haveSimpleNameEndingWith("Utils")
                    .because("utility classes should end with utils");

    @ArchTest
    static final ArchRule utilities_should_be_stateless =
            classes()
                    .that()
                    .resideInAPackage("..utility..")
                    .should()
                    .haveOnlyFinalFields();

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

    private static ArchCondition<JavaClass> havePrivateNoArgsConstructor() {
        return new ArchCondition<>("have a private no-args constructor") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                Set<JavaConstructor> constructors = javaClass.getConstructors();
                boolean hasPrivateNoArgsConstructor = constructors.stream()
                        .anyMatch(c ->
                                c.getRawParameterTypes().isEmpty()
                                        && c.getModifiers().contains(JavaModifier.PRIVATE));

                if (!hasPrivateNoArgsConstructor) {
                    String message = javaClass.getName()
                            + " should declare a private no-args constructor";
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }
}
