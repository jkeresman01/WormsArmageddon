package com.keresman.worms.architecture.factory;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.keresman.worms.factory")
public class FactoryRulesTest {

    @ArchTest
    static final ArchRule factories_should_have_names_ending_with_the_word_factory =
            classes()
                    .that()
                    .resideInAPackage("..factory..")
                    .should()
                    .haveSimpleNameEndingWith("Factory")
                    .because("Factories should have names ending in \"Factory\".");

    static final ArchRule factories_should_suppress_default_constructor =
            classes()
                    .that()
                    .resideInAPackage("..factory..")
                    .should()
                    .haveOnlyPrivateConstructors()
                    .because("Factories should suppress default constructor.");

}
