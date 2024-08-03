package cn.xpbootcamp.refactor;

import cn.xpbootcamp.refactor.movie.CampusMovie;
import cn.xpbootcamp.refactor.movie.HistoryMovie;
import cn.xpbootcamp.refactor.movie.NewReleaseMovie;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CustomerTest {

    @Test
    void should_return_correct_result_when_call_statement() {
        Customer customer = new Customer("老王");
        customer.addRental(new Rental(new CampusMovie("同桌的你"), 4));
        customer.addRental(new Rental(new NewReleaseMovie("宠爱"), 5));
        customer.addRental(new Rental(new HistoryMovie("战狼2"), 6));

        assertThat("Rental Record for 老王：\n" +
                "\t同桌的你\t3.0\n" +
                "\t宠爱\t15.0\n" +
                "\t战狼2\t8.0\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points").isEqualTo(customer.statement());
    }

}