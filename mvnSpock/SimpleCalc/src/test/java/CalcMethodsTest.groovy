import com.CalcMethods
import spock.lang.Specification

class CalcMethodsTest extends Specification {

    def "calc sum two numbers"() {
        expect:
        CalcMethods.sumTwoNumbers(new BigDecimal(a), new BigDecimal(b)) == c

        where:
        a | b | c
        1 | 2 | new BigDecimal(3)
        3 | 3 | new BigDecimal(6)
    }

    def "test understanding"() {
        expect:
        new BigDecimal(3) == new BigDecimal(3)
    }
}