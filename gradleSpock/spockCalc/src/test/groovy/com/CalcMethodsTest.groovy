package com

import spock.lang.Specification;


class CalcMethodsTest extends Specification {

    def "calc sum two numbers"() {
        expect:
        Calc.sum(a, b) == c

        where:
        a | b | c
        1 | 2 | 3
        3 | 3 | 6
    }

}